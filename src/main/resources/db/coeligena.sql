CREATE DATABASE coeligena;

USE coeligena;

/*
 * 验证用户表
 */
CREATE TABLE IF NOT EXISTS auth_users (
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT, /* 验证用户 ID（唯一标识） */
    email           VARCHAR(128) NULL, /* 邮箱*/
    phone           VARCHAR(16)  NULL, /* 手机 */
    password        VARCHAR(256) NOT NULL, /* 密码 */
    salt            VARCHAR(128) NOT NULL, /* 密码加密盐 */
    create_time     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 创建时间（时间戳） */
    last_login_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 最近一次登录时间（时间戳）*/
    last_login_ip   VARCHAR(15)  NOT NULL, /* 最近登录的IP地址 */
    is_muted_status TINYINT(4)   NOT NULL, /* 是否禁言状态：1-表示禁言，0-表示正常 */
    muted_time      TIMESTAMP             DEFAULT NULL, /* 禁言截止日期 */
    is_banned       TINYINT(4)   NOT NULL DEFAULT '0', /* 是否禁用账户 */
    remark          VARCHAR(256)          DEFAULT NULL, /* 备注信息 */
    PRIMARY KEY (id),
    INDEX (email),
    INDEX (phone),
    INDEX (password),
    INDEX (salt)
);

/*
 * 角色表
 * 一定数量的权限的集合，权限的载体
 */
CREATE TABLE IF NOT EXISTS roles (
    id          INT UNSIGNED        NOT NULL AUTO_INCREMENT, /* 角色 ID（唯一标识） */
    rolename    VARCHAR(32)         NOT NULL, /* 角色名 */
    pid         INT UNSIGNED                 DEFAULT '0', /* 父角色 ID */
    status      TINYINT(4) UNSIGNED NOT NULL, /* 启用状态：0-表示禁用，1-表示启用 */
    create_time TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 创建时间（时间戳） */
    update_time TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 更改时间（时间戳）*/
    remark      VARCHAR(256)                 DEFAULT NULL, /* 备注信息 */
    PRIMARY KEY (id),
    INDEX (rolename),
    INDEX (pid)
);

/*
 * 验证用户与角色对应表
 */
CREATE TABLE IF NOT EXISTS role_auth_user (
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    role_id      INT UNSIGNED NOT NULL DEFAULT '0', /* 角色 ID（唯一标识） */
    auth_user_id INT UNSIGNED NOT NULL DEFAULT '0', /* 验证用户 ID（唯一标识） */
    PRIMARY KEY (id),
    INDEX (role_id),
    INDEX (auth_user_id)
);

/*
 * 权限表
 */
CREATE TABLE IF NOT EXISTS permissions (
    id          INT UNSIGNED     NOT NULL AUTO_INCREMENT, /* 权限 ID（唯一标识） */
    name        VARCHAR(32)      NOT NULL, /* 权限名称（英文名，对应应用控制器、应用、方法名） */
    title       VARCHAR(64)               DEFAULT NULL, /* 权限名称 */
    status      TINYINT(4)                DEFAULT '0', /* 启用状态：0-表示禁用，1-表示启用 */
    remark      VARCHAR(256)              DEFAULT NULL, /* 备注信息 */
    sort        INT(11) UNSIGNED          DEFAULT '50', /* 排序值（默认值为50） */
    pid         INT(11) UNSIGNED NOT NULL DEFAULT '0', /* 父权限 ID（如:方法pid对应相应的控制器） */
    level       TINYINT(4)       NOT NULL DEFAULT '0', /* 权限类型：1-表示应用（模块）, 2-表示控制器, 3-表示方法 */
    create_time TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 创建时间（时间戳） */
    update_time TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 更改时间（时间戳）*/
    PRIMARY KEY (id),
    INDEX (pid)
);

/**
 * 角色权限对应表
 */
CREATE TABLE IF NOT EXISTS role_permission (
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    role_id       INT UNSIGNED NOT NULL DEFAULT '0', /* 角色 ID（唯一标识） */
    permission_id INT UNSIGNED NOT NULL DEFAULT '0', /* 权限 ID（唯一标识） */
    PRIMARY KEY (id),
    INDEX (role_id),
    INDEX (permission_id)
);


/*
 * 用户信息表
 */
CREATE TABLE IF NOT EXISTS users (
    id                 INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 用户ID（唯一标识） */
    fullname           VARCHAR(64)      NOT NULL, /* 全名 */
    gender             TINYINT(4)       NOT NULL DEFAULT '0', /* 性别  1:male , 2:female , 3: other */
    avatar_path        VARCHAR(512)              DEFAULT NULL, /* 头像路径 */
    location           VARCHAR(128)              DEFAULT NULL, /* 居住位置 */
    business_id        INT(11)                   DEFAULT '0', /* 所属行业 ID */
    employment         VARCHAR(128)              DEFAULT NULL, /* 公司或组织名称 */
    position           VARCHAR(128)              DEFAULT NULL, /* 职位 */
    education          VARCHAR(128)              DEFAULT NULL, /* 学校或教育机构 */
    major              VARCHAR(128)              DEFAULT NULL, /* 专业 */
    description        VARCHAR(256)              DEFAULT NULL, /* 个人描述 */
    autograph          VARCHAR(128)              DEFAULT NULL, /* 签名 */
    approval_count     INT(11)          NOT NULL DEFAULT '0', /* 获得赞同数 */
    thank_count        INT(11)          NOT NULL DEFAULT '0', /* 获得感谢数 */
    question_count     INT(11)          NOT NULL DEFAULT '0', /* 提问数 */
    answer_count       INT(11)          NOT NULL DEFAULT '0', /* 回答数 */
    collect_count      INT(11)          NOT NULL DEFAULT '0', /* 收藏夹数 */
    invite_count       INT(11)          NOT NULL DEFAULT '0', /* 邀请回答数 */
    profile_view_count INT(11)          NOT NULL DEFAULT '0', /* 主页浏览数 */
    personality_url    VARCHAR(64)               DEFAULT NULL, /* 个性网址 */
    is_email_active    TINYINT(4)       NOT NULL DEFAULT '0', /* 邮箱是否激活 0：否， 1：是 */
    is_phone_active    TINYINT(4)       NOT NULL DEFAULT '0', /* 手机是否激活 0：否， 1：是 */
    auth_user_id       INT              NOT NULL DEFAULT '0', /* 用户ID */
    PRIMARY KEY (id),
    INDEX (fullname),
    INDEX (personality_url),
    INDEX (auth_user_id)
);


/*
 * 账户激活数据表
 */
CREATE TABLE IF NOT EXISTS activations (
    id                   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 账户激活数据 ID */
    activation_code      VARCHAR(32)      NOT NULL, /* 账户激活码 */
    activation_type_code VARCHAR(16)      NOT NULL, /* 账户激活码类型：email url 或 phone code */
    create_time          TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP, /* 激活码创建时间 */
    expire_time          TIMESTAMP                 DEFAULT NULL, /* 激活码过期时间 */
    create_ip            VARCHAR(15)      NOT NULL, /* 激活码创建时 IP */
    activation_time      TIMESTAMP                 DEFAULT NULL, /* 触发激活时间 */
    activation_ip        VARCHAR(15)               DEFAULT NULL, /* 激活时 IP */
    user_id              INT(11)          NOT NULL DEFAULT '0', /* 用户 ID */
    PRIMARY KEY (id),
    INDEX (activation_code),
    INDEX (activation_type_code)
);

/* 
 * 用户关注表
 *
 * 	关注
 *	粉丝
 *	双向关注(互粉)
 *	无关系
	
 *	查询关注列表
 *	查询粉丝列表
 *	查询双向关注列表
 *	判断两个用户的关系
 *	查询带关系状态的任一列表
 * */
CREATE TABLE IF NOT EXISTS relationships (
    id          INT(11) NOT NULL AUTO_INCREMENT, /* 关系ID（唯一标识） */
    user_id     INT(11) NOT NULL DEFAULT '0', /* 用户ID */
    followed_id INT(11) NOT NULL DEFAULT '0', /* 当前用户关注的人  */
    PRIMARY KEY (id),
    INDEX (user_id),
    INDEX (followed_id)
);

/* 
 * 问题表 
 */
CREATE TABLE IF NOT EXISTS questions (
    id               INT(11)      NOT NULL AUTO_INCREMENT, /* 问题ID（唯一标识） */
    question_content VARCHAR(255) NOT NULL, /* 问题标题 */
    question_detail  TEXT         NOT NULL DEFAULT NULL, /* 问题内容 */
    question_time    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 提问时间 */
    update_time      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 问题更新时间 */
    answer_count     INT(11)      NOT NULL DEFAULT '0', /* 回答数 */
    view_count       INT(11)      NOT NULL DEFAULT '0', /* 浏览次数 */
    follower_count   INT(11)      NOT NULL DEFAULT '0', /* 关注人数 */
    comment_count    INT(11)      NOT NULL DEFAULT '0', /* 评论数 */
    question_ip      VARCHAR(15)  NOT NULL, /* 提问 IP 地址 */
    is_locked        TINYINT(4)   NOT NULL DEFAULT '0', /* 是否被锁定 1：是， 0：否 */
    is_anonymous     TINYINT(4)   NOT NULL DEFAULT '0', /* 是否匿名 1：是， 0：否 */
    is_recommend     TINYINT(4)   NOT NULL DEFAULT '0', /* 是否是推荐问题 1：是，0：否 */
    user_id          INT(11)      NOT NULL DEFAULT '0', /* 提问用户 */
    PRIMARY KEY (id),
    INDEX (question_content),
    INDEX (is_recommend),
    INDEX (user_id)
);

/*
 * 问题关注表
 */
CREATE TABLE IF NOT EXISTS follow (
    id          INT(11)   NOT NULL AUTO_INCREMENT, /* 问题关注ID（唯一标识）*/
    question_id INT(11)   NOT NULL DEFAULT '0', /* 被关注的问题ID（唯一标识） */
    follower_id INT(11)   NOT NULL DEFAULT '0', /* 问题关注人ID（唯一标识）*/
    follow_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 问题关注时间 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (follower_id)
);

/*
 * 问题评论表
 */
CREATE TABLE IF NOT EXISTS question_comments (
    id                   INT(11)    NOT NULL AUTO_INCREMENT, /* 评论ID（唯一标识） */
    question_id          INT(11)    NOT NULL DEFAULT '0', /* 被评论的问题ID（唯一标识） */
    reviewer_id          INT(11)    NOT NULL DEFAULT '0', /* 评论用户ID（唯一标识） */
    parent_comment_id    INT(11)    NOT NULL DEFAULT '0', /* 被回复评论的ID（唯一标识） */
    comment_content      TEXT       NOT NULL, /* 评论内容 */
    comment_time         TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 评论时间 */
    is_featured_comments TINYINT(4) NOT NULL DEFAULT '0', /* 是否是精选评论 0：否，1：是 */
    approval_count       INT(11)    NOT NULL DEFAULT '0', /* 赞同数量 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (reviewer_id),
    INDEX (parent_comment_id),
    INDEX (is_featured_comments),
    INDEX (approval_count)
);

/*
 * 问题话题节点表
 */
CREATE TABLE IF NOT EXISTS topic_nodes (
    id                 INT(11)      NOT NULL AUTO_INCREMENT, /* 话题节点 ID（唯一标识） */
    topic_name         VARCHAR(256) NOT NULL, /* 话题名称 */
    topic_introduction TEXT         NOT NULL DEFAULT '', /* 话题描述 */
    image_path         VARCHAR(512) NOT NULL DEFAULT '', /* 话题图片路径 */
    follow_count       INT(11)      NOT NULL DEFAULT '0', /* 话题关注者数量 */
    create_time        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 话题创建时间 */
    is_merged_to       TINYINT(4)   NOT NULL DEFAULT '0', /* 是否合并到其他节点 0：否，1：是*/
    PRIMARY KEY (id),
    INDEX (topic_name)
);

/*
 * 问题话题关系表
 */
CREATE TABLE IF NOT EXISTS topic_relations (
    id              INT(11) NOT NULL AUTO_INCREMENT, /* 话题关系 ID（唯一标识） */
    parent_topic_id INT(11) NOT NULL DEFAULT '0', /* 父话题 ID */
    child_topic_id  INT(11) NOT NULL DEFAULT '0', /* 子话题 ID */
    PRIMARY KEY (id),
    INDEX (parent_topic_id),
    INDEX (child_topic_id)
);

/*
 * 问题话题编辑锁定表
 */
CREATE TABLE IF NOT EXISTS topic_lock (
    id                     INT(11)    NOT NULL AUTO_INCREMENT, /* 话题编辑锁定 ID（唯一标识） */
    is_locked_all          TINYINT(4) NOT NULL DEFAULT '0', /* 是否完全锁定 0：是，1：否 */
    is_locked_name         TINYINT(4) NOT NULL DEFAULT '0', /* 是否锁定话题名称 0：是，1：否 */
    is_locked_introduction TINYINT(4) NOT NULL DEFAULT '0', /* 是否锁定话题描述 0：是，1：否 */
    is_locked_image        TINYINT(4) NOT NULL DEFAULT '0', /* 是否锁定话题图片编辑 0：是，1：否 */
    is_locked_parent       TINYINT(4) NOT NULL DEFAULT '0', /* 是否锁定父话题 0：是，1：否 */
    is_locked_child        TINYINT(4) NOT NULL DEFAULT '0', /* 是否锁定子话题 0：是，1：否 */
    topic_id               INT(11)    NOT NULL DEFAULT '0', /* 话题 ID */
    PRIMARY KEY (id),
    INDEX (topic_id)
);

/*
 * 问题话题合并表
 *  合并本话题至意义相近的其他话题。
 *  本话题会被删除，相关内容会自动迁移至目标话题中，同时添加话题别名。
 *  请将不常用的话题合并至常用话题。
 */
CREATE TABLE IF NOT EXISTS topic_merge (
    id           INT(11)   NOT NULL AUTO_INCREMENT, /* 话题合并 ID（唯一标识） */
    merged_to_id INT(11)   NOT NULL DEFAULT '0', /* 合并到话题 ID */
    merged_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 合并时间 */
    topic_id     INT(11)   NOT NULL DEFAULT '0', /* 话题 ID */
    PRIMARY KEY (id),
    INDEX (merged_to_id),
    INDEX (topic_id)
);

/*
 * 问题话题别名表
 */
CREATE TABLE IF NOT EXISTS topic_alias (
    id          INT(11)      NOT NULL AUTO_INCREMENT, /* 话题别名 ID（唯一标识） */
    topic_alias VARCHAR(256) NOT NULL, /* 话题别名 */
    topic_id    INT(11)      NOT NULL DEFAULT '0', /* 话题 ID */
    PRIMARY KEY (id),
    INDEX (topic_id)
);

/*
 * 问题话题日志表
 */
CREATE TABLE IF NOT EXISTS topic_logs (
    id            INT(11)     NOT NULL AUTO_INCREMENT, /* 话题日志 ID（唯一标识） */
    topic_id      INT(11)     NOT NULL DEFAULT '0', /* 话题节点 ID（唯一标识） */
    user_id       INT(11)     NOT NULL DEFAULT '0', /* 日志操作人员 ID（唯一标识） */
    event         VARCHAR(64) NOT NULL, /* 日志事件 */
    reason        TEXT        NOT NULL, /* 修改理由 */
    revision_text TEXT        NOT NULL, /* 实际修改结果（HTML） */
    log_time      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 日志记录时间 */
    PRIMARY KEY (id),
    INDEX (topic_id),
    INDEX (user_id)
);

/*
 * 问题标签表
 */
CREATE TABLE IF NOT EXISTS question_tags (
    id                INT(11) NOT NULL AUTO_INCREMENT, /* 标签ID（唯一标识） */
    question_topic_id INT(11) NOT NULL DEFAULT '0', /* 话题 ID */
    question_id       INT(11) NOT NULL DEFAULT '0', /* 标签的问题ID（唯一标识） */
    PRIMARY KEY (id),
    INDEX (question_topic_id),
    INDEX (question_id)
);

/*
 * 问题日志表
 *
 * event 包括 添加了问题，添加了话题，编辑了问题，编辑了补充说明，移除了补充说明，移除了话题等
 */
CREATE TABLE IF NOT EXISTS question_logs (
    id            INT(11)     NOT NULL AUTO_INCREMENT, /* 日志ID（唯一标识） */
    question_id   INT(11)     NOT NULL DEFAULT '0', /* 问题 ID（唯一标识） */
    user_id       INT(11)     NOT NULL DEFAULT '0', /* 操作人员 ID（唯一标识） */
    event         VARCHAR(64) NOT NULL, /* 日志事件 */
    reason        TEXT        NOT NULL, /* 修改理由 */
    revision_text TEXT        NOT NULL, /* 实际修改结果（HTML） */
    log_time      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 日志记录时间 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (user_id)
);

/**
 * 问题回答邀请表
 */
CREATE TABLE IF NOT EXISTS invites (
    id          INT(11)   NOT NULL AUTO_INCREMENT, /* 邀请ID（唯一标识） */
    question_id INT(11)   NOT NULL DEFAULT '0', /* 问题ID */
    inviter_id  INT(11)   NOT NULL DEFAULT '0', /* 邀请人ID */
    invitee_id  INT(11)   NOT NULL DEFAULT '0', /* 被邀请人ID */
    invite_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 邀请时间 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (inviter_id),
    INDEX (invitee_id)
);

/* 
 * 回答表
 */
CREATE TABLE IF NOT EXISTS answers (
    id             INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 回答ID（唯一标识） */
    question_id    INT(11)          NOT NULL DEFAULT '0', /* 问题ID（唯一标识） */
    author_id      INT(11)          NOT NULL DEFAULT '0', /* 作者ID（唯一标识） */
    answer_content MEDIUMTEXT       NOT NULL, /* 回答 */
    answer_time    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 回答或更新时间 */
    against_count  INT(11)          NOT NULL DEFAULT '0', /* 反对数 */
    approval_count INT(11)          NOT NULL DEFAULT '0', /* 支持数 */
    comment_count  INT(11)          NOT NULL DEFAULT '0', /* 评论数 */
    thanks_count   INT(11)          NOT NULL DEFAULT '0', /* 感谢数 */
    nohelp_count   INT(11)          NOT NULL DEFAULT '0', /* 没有帮助数 */
    is_sec_licence TINYINT(4)       NOT NULL DEFAULT '0', /* 是否作者保留权利 */
    is_top_answer  TINYINT(4)       NOT NULL DEFAULT '0', /* 是否是精华回答 */
    is_anonymous   TINYINT(4)       NOT NULL DEFAULT '0', /* 是否匿名 1：是， 0：否 */
    is_force_fold  TINYINT(4)       NOT NULL DEFAULT '0', /* 是否强制折叠 1：是， 0：否 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (author_id),
    INDEX (answer_time),
    INDEX (approval_count),
    INDEX (nohelp_count),
    INDEX (against_count),
    INDEX (is_top_answer),
    INDEX (is_force_fold),
    INDEX (author_id)
);

/*
 * 回答投票表
 */
CREATE TABLE IF NOT EXISTS votes (
    id        INT(11)    NOT NULL AUTO_INCREMENT, /* 投票ID（唯一标识） */
    answer_id INT(11)    NOT NULL DEFAULT '0', /* 回答ID（唯一标识） */
    voter_id  INT(11)    NOT NULL DEFAULT '0', /* 投票用户ID */
    vote_time TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 回答投票时间 */
    vote_type TINYINT(4) NOT NULL DEFAULT '0', /* 投票 1:up、2:down、3:unconcern */
    PRIMARY KEY (id),
    INDEX (answer_id),
    INDEX (voter_id),
    INDEX (vote_type)
);

/* 
 * 回答评论表
 */
CREATE TABLE IF NOT EXISTS answer_comments (
    id                   INT(11)    NOT NULL AUTO_INCREMENT, /* 评论ID（唯一标识） */
    answer_id            INT(11)    NOT NULL DEFAULT '0', /* 被评论的回答ID（唯一标识） */
    reviewer_id          INT(11)    NOT NULL DEFAULT '0', /* 评论用户ID（唯一标识） */
    parent_comment_id    INT(11)    NOT NULL DEFAULT '0', /* 被回复评论的ID（唯一标识） */
    comment_content      TEXT       NOT NULL, /* 评论内容 */
    comment_time         TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 评论时间 */
    approval_count       INT(11)    NOT NULL DEFAULT '0', /* 赞同数量 */
    is_featured_comment  TINYINT(4) NOT NULL DEFAULT '0', /* 是否是精选评论 0：否，1：是 */
    PRIMARY KEY (id),
    INDEX (answer_id),
    INDEX (reviewer_id),
    INDEX (parent_comment_id),
    INDEX (is_featured_comment)
);

/*
 * 评论赞同表
 */
CREATE TABLE IF NOT EXISTS comment_approvals (
    id            INT(11)   NOT NULL AUTO_INCREMENT, /* 赞同ID（唯一标识） */
    comment_id    INT(11)   NOT NULL DEFAULT '0', /* 被赞同评论ID（唯一标识） */
    approval_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 评论点赞时间 */
    user_id       INT(11)   NOT NULL DEFAULT '0', /* 点赞用户ID（唯一标识） */
    PRIMARY KEY (id),
    INDEX (comment_id),
    INDEX (user_id)
);

/*
 * 回答感谢表
 */
CREATE TABLE IF NOT EXISTS thanks (
    id         INT(11)   NOT NULL AUTO_INCREMENT, /* 感谢ID（唯一标识） */
    answer_id  INT(11)   NOT NULL DEFAULT '0', /* 被感谢回答ID */
    thanker_id INT(11)   NOT NULL DEFAULT '0', /* 感谢用户ID */
    thank_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 感谢回答时间 */
    PRIMARY KEY (id),
    INDEX (answer_id),
    INDEX (thanker_id)
);

/*
 * 回答没有帮助表
 */
CREATE TABLE IF NOT EXISTS nohelps (
    id          INT(11)   NOT NULL AUTO_INCREMENT, /* 回答没有帮助ID（唯一标识） */
    answer_id   INT(11)   NOT NULL DEFAULT '0', /* 没有帮助的回答 ID */
    user_id     INT(11)   NOT NULL DEFAULT '0', /* 用户 ID */
    nohelp_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 回答没有帮助时间 */
    PRIMARY KEY (id),
    INDEX (answer_id),
    INDEX (user_id)
);

/**
 * 回答草稿表
 */
CREATE TABLE IF NOT EXISTS drafts (
    id            INT(11)    NOT NULL AUTO_INCREMENT, /* 草稿ID（唯一标识） */
    question_id   INT(11)    NOT NULL DEFAULT '0', /* 草稿问题 id */
    draft_content MEDIUMTEXT NOT NULL, /* 草稿内容 */
    last_update   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 草稿更新时间 */
    is_anonymous  TINYINT(4) NOT NULL DEFAULT '0', /* 草稿是否匿名 1：是， 0：否 */
    user_id       INT(11)    NOT NULL DEFAULT '0', /* 草稿回答用户 */
    PRIMARY KEY (id),
    INDEX (question_id),
    INDEX (user_id)
);

/*
 * 回答收藏夹表
 */
CREATE TABLE IF NOT EXISTS collection_folders (
    id              INT(11)      NOT NULL AUTO_INCREMENT, /* 收藏夹ID（唯一标识） */
    folder_name     VARCHAR(256) NOT NULL, /* 收藏夹名称 */
    description     VARCHAR(256)          DEFAULT NULL, /* 收藏夹描述 */
    answers_count   INT(11)      NOT NULL DEFAULT '0', /* 包含回答数量 */
    followers_count INT(11)      NOT NULL DEFAULT '0', /* 关注者数量 */
    is_public       TINYINT(4)   NOT NULL DEFAULT '1', /* 是否公开 0：否， 1：是 */
    owner_id        INT(11)      NOT NULL DEFAULT '0', /* 创建者ID */
    PRIMARY KEY (id),
    INDEX (owner_id)
);

/*
 * 回答收藏表
 */
CREATE TABLE IF NOT EXISTS collections (
    id                   INT(11) NOT NULL AUTO_INCREMENT, /* 收藏 ID（唯一标识） */
    answer_id            INT(11) NOT NULL DEFAULT '0', /* 被收藏的回答 ID */
    collection_folder_id INT(11) NOT NULL DEFAULT '0', /* 所属收藏夹 ID */
    owner_id             INT(11) NOT NULL DEFAULT '0', /* 收藏夹所属用户 ID */
    PRIMARY KEY (id),
    INDEX (answer_id),
    INDEX (collection_folder_id),
    INDEX (owner_id)
);

/*
 * 收藏夹关注表
 */
CREATE TABLE IF NOT EXISTS collection_folder_follow (
    id                   INT(11) NOT NULL AUTO_INCREMENT, /* 收藏关注 ID（唯一标识） */
    collection_folder_id INT(11) NOT NULL DEFAULT '0', /* 收藏夹 ID */
    follower_id          INT(11) NOT NULL DEFAULT '0', /* 收藏夹关注者 ID */
    PRIMARY KEY (id),
    INDEX (collection_folder_id),
    INDEX (follower_id)
);

/**
 * 动态表
 */
CREATE TABLE IF NOT EXISTS feeds (
    id                INT(11)    NOT NULL AUTO_INCREMENT, /* 动态ID */
    feeds_id          INT(11)    NOT NULL DEFAULT '0', /* 动态类型所对应的ID,如关注和提出问题对应的是问题ID，赞同回答和回答问题对应的是回答ID */
    feeds_type        TINYINT(4) NOT NULL DEFAULT '0', /* 动态类型 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题*/
    parent_feeds_id   INT(11)    NOT NULL DEFAULT '0', /* 父动态类型所对应的ID，赞同回答和回答问题对应的是问题ID */
    parent_feeds_type TINYINT(4)          DEFAULT '0', /* 父动态类型 1：赞同该回答——对应问题，2：回答了该问题——对应问题*/
    feeds_time        TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 动态时间 */
    feeds_user_id     INT(11)    NOT NULL DEFAULT '0', /* 动态发起人 */
    PRIMARY KEY (id),
    INDEX (feeds_id),
    INDEX (feeds_type),
    INDEX (parent_feeds_id),
    INDEX (parent_feeds_type),
    INDEX (feeds_user_id)
);

/*
 * 屏蔽用户
 */
CREATE TABLE IF NOT EXISTS blocks (
    id         INT(11) NOT NULL AUTO_INCREMENT, /* 屏蔽表ID（唯一标识） */
    user_id    INT(11) NOT NULL DEFAULT '0', /* 当前用户ID */
    blocked_id INT(11) NOT NULL DEFAULT '0', /* 被屏蔽用户ID */
    PRIMARY KEY (id),
    INDEX (user_id),
    INDEX (blocked_id)
);

/*
 * 设置表
 */
CREATE TABLE IF NOT EXISTS settings (
    id                    INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 设置 ID（唯一标识） */
    is_privacy_protection TINYINT(4)       NOT NULL DEFAULT '1', /* 是否隐私保护（站外搜索到我的内容，不会被显示姓名）0：否，1：是 */
    message_receive       TINYINT(4)       NOT NULL DEFAULT '0', /* 别人给我发私信，0：允许所有人给我发私信，1：只允许我关注的人给我发私信 */
    stranger_inbox        TINYINT(4)       NOT NULL DEFAULT '0', /* 开启陌生人私信箱，0：否，1：是 */
    message_email         TINYINT(4)       NOT NULL DEFAULT '0', /* 有私信时邮件提醒，0：否，1：是 */
    invite_me             TINYINT(4)       NOT NULL DEFAULT '0', /* 邀请我回答问题，0：接收所有人的消息，1：只接收关注人的消息 */
    new_answer            TINYINT(4)       NOT NULL DEFAULT '0', /* 关注的问题有了新回答，0：接收所有人的消息，1：只接收关注人的消息 */
    new_article           TINYINT(4)       NOT NULL DEFAULT '0', /* 关注的专栏有了新文章，0：接收消息，1：不接收消息 */
    new_book              TINYINT(4)       NOT NULL DEFAULT '0', /* 关注的人有了新的电子书，0：接收消息，1：不接收消息 */
    at_comment_me         TINYINT(4)       NOT NULL DEFAULT '0', /* @/评论我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    agree_thank_me        TINYINT(4)       NOT NULL DEFAULT '0', /* 赞同、感谢我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    like_comment          TINYINT(4)       NOT NULL DEFAULT '0', /* 赞了我的评论，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    like_article          TINYINT(4)       NOT NULL DEFAULT '0', /* 赞了我的文章，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    like_book             TINYINT(4)       NOT NULL DEFAULT '0', /* 赞了我的电子书，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    admire_article        TINYINT(4)       NOT NULL DEFAULT '0', /* 赞赏了我的文章，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    follow_me             TINYINT(4)       NOT NULL DEFAULT '0', /* 有人关注了我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    follow_column         TINYINT(4)       NOT NULL DEFAULT '0', /* 有人关注了我的专栏，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    follow_collection     TINYINT(4)       NOT NULL DEFAULT '0', /* 有人关注了我的收藏，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息*/
    weekly_email          TINYINT(4)       NOT NULL DEFAULT '0', /* 是否接受每周精选，0：否，1：是 */
    new_product_email     TINYINT(4)       NOT NULL DEFAULT '0', /* 新产品或活动通知，0：否，1：是 */
    PRIMARY KEY (id)
);

/*
 *  专栏表
 */
CREATE TABLE IF NOT EXISTS columns (
    id                     INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 专栏表 ID（唯一标识） */
    column_name            VARCHAR(128)     NOT NULL, /* 专栏名称 */
    column_intro           VARCHAR(255)     NOT NULL, /* 专栏介绍 */
    column_followers_count INT(11)          NOT NULL DEFAULT '0', /* 专栏关注人数 */
    article_count          INT(11)          NOT NULL DEFAULT '0', /* 专栏文章数 */
    column_create_time     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 专栏创建时间 */
    is_locked              TINYINT(4)       NOT NULL DEFAULT '0', /* 专栏是否被锁定 1：是，0：否 */
    column_author_id       INT(11)          NOT NULL DEFAULT '0',
    PRIMARY KEY (id),
    INDEX (column_author_id)
);

/*
 * 专栏文章表
 */
CREATE TABLE IF NOT EXISTS articles (
    id                  INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 专栏文章 ID（唯一标识） */
    article_title       VARCHAR(255)     NOT NULL, /* 文章标题 */
    article_content     MEDIUMTEXT       NOT NULL, /* 文章正文 */
    title_image         VARCHAR(255)              DEFAULT '', /* 文章题图 */
    compose_time        TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 创作时间 */
    compose_update_time TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 文章更新时间 */
    comments_count      INT(11)          NOT NULL DEFAULT '0', /* 评论数量 */
    views_count         INT(11)          NOT NULL DEFAULT '0', /* 浏览数量 */
    approval_count      INT(11)          NOT NULL DEFAULT '0', /* 文章点赞数量 */
    is_locked           TINYINT(4)       NOT NULL DEFAULT '0', /* 文章是否被锁定 1：是，0：否 */
    column_id           INT(11)          NOT NULL DEFAULT '0', /* 专栏 ID */
    author_id           INT(11)          NOT NULL DEFAULT '0', /* 文章作者 ID */
    PRIMARY KEY (id),
    INDEX (column_id),
    INDEX (author_id)
);

/*
 * 专栏主题表
 */
CREATE TABLE IF NOT EXISTS column_topics (
    id            INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 专栏主题表ID（唯一标识） */
    topic_name    VARCHAR(64)      NOT NULL, /* 专栏主题名称 */
    article_count INT(11)          NOT NULL DEFAULT '0', /* 专栏主题包含文章数 */
    column_id     INT(11)          NOT NULL DEFAULT '0', /* 专栏 ID */
    PRIMARY KEY (id),
    INDEX (topic_name),
    INDEX (column_id)
);

/*
 * 专栏文章主题关联表
 */
CREATE TABLE IF NOT EXISTS article_topics (
    id              INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, /* 专栏文章主题表ID（唯一标识） */
    column_topic_id INT(11)          NOT NULL DEFAULT '0', /* 专栏主题 ID */
    article_id      INT(11)          NOT NULL DEFAULT '0', /* 文章 ID */
    PRIMARY KEY (id),
    INDEX (column_topic_id),
    INDEX (article_id)
);

/**
 * 专栏文章草稿表
 */
CREATE TABLE IF NOT EXISTS article_drafts (
    id               INT(11)    NOT NULL AUTO_INCREMENT, /* 草稿ID（唯一标识） */
    column_id        INT(11)    NOT NULL DEFAULT '0', /* 草稿专栏 id */
    draft_content    MEDIUMTEXT NOT NULL, /* 草稿内容 */
    last_update_time TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 草稿更新时间 */
    is_anonymous     TINYINT(4) NOT NULL DEFAULT '0', /* 草稿是否匿名 1：是， 0：否 */
    user_id          INT(11)    NOT NULL DEFAULT '0', /* 草稿作者 */
    PRIMARY KEY (id),
    INDEX (column_id),
    INDEX (user_id)
);

/*
 * 公共提醒内容表
 */
CREATE TABLE IF NOT EXISTS notification_text (
    id      INT(11) NOT NULL AUTO_INCREMENT, /* 消息提醒内容ID（唯一标识） */
    content TEXT    NOT NULL, /* 消息提醒内容 */
    PRIMARY KEY (id)
);

/*
 * 公共提醒消息表
 */
CREATE TABLE IF NOT EXISTS notifications (
    id               INT(11)     NOT NULL AUTO_INCREMENT, /* 公共消息ID（唯一标识） */
    text_id          INT(11)     NOT NULL DEFAULT '0', /* 消息内容ID */
    send_time        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 发送时间 */
    read_time        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 阅读时间 */
    message_type     VARCHAR(64) NOT NULL, /* 消息类型  */
    is_read          TINYINT(4)  NOT NULL DEFAULT '0', /* 是否已读 0:否 ，1：是  */
    message_group_id INT(11)     NOT NULL DEFAULT '0', /* 关注问题的用户组  0:默认所有人*/
    PRIMARY KEY (id),
    INDEX (text_id),
    INDEX (is_read),
    INDEX (message_group_id)
);

/*
 * 私信内容表
 */
CREATE TABLE IF NOT EXISTS message_text (
    id      INT(11) NOT NULL AUTO_INCREMENT, /* 消息内容ID（唯一标识） */
    content TEXT    NOT NULL, /* 消息内容 */
    PRIMARY KEY (id)
);

/*
 * 私人消息表
 */
CREATE TABLE IF NOT EXISTS private_messages (
    id              INT(11)     NOT NULL AUTO_INCREMENT, /* 用户消息ID（唯一标识） */
    sender_id       INT(11)     NOT NULL DEFAULT '0', /* 发送用户ID */
    recipient_id    INT(11)     NOT NULL DEFAULT '0', /* 接收用户ID */
    text_id         INT(11)     NOT NULL DEFAULT '0', /* 消息内容ID */
    send_time       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 发送时间  设置时间时不需要更新*/
    read_time       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, /* 阅读时间 */
    message_type    VARCHAR(64) NOT NULL, /* 消息类型  */
    sender_isdel    TINYINT(4)  NOT NULL DEFAULT '0', /* 发送用户是否删除 0:否 ，1：是 */
    recipient_isdel TINYINT(4)  NOT NULL DEFAULT '0', /* 接收用户是否删除 0:否 ，1：是 */
    is_read         TINYINT(4)  NOT NULL DEFAULT '0', /* 是否已读 0:否 ，1：是  */
    PRIMARY KEY (id),
    INDEX (sender_id),
    INDEX (recipient_id),
    INDEX (text_id),
    INDEX (is_read)
);

/**
 * 消息组表
 * 	（^为直接插入存储 ， #为动态读取）
 *
 * 用户对用户：
 * 	1. 私信（私信页面） ^ -- PrivateMsg
 *
 * 系统对用户：
 * 	1. 提醒（提醒页面）
 * 		*某人（trigger_id）邀请你回答一个问题（question_id）^
        -- InviteMsg
 * 		*某人（trigger_id）评论（comment_id）了你的问题（question_id）^
        -- CommentQuestionMsg
 * 		*某人（trigger_id）回答（answer_id）了你的问题（question_id）^
        -- AnswerQuestionMsg
 * 		*某人（trigger_id）评论（comment_id）了你在某问题（question_id）下的回答（answer_id）^
        -- CommentAnswerMsg
 * 		*某人（trigger_id）赞同了你在某问题（question_id）下的回答（answer_id）^
        -- AgreeAnswerMsg
 * 		*某人（trigger_id）感谢了你在某问题（question_id）下的回答（answer_id）^
        -- ThankAnswerMsg
 *      *某人（trigger_id）赞同了你在问题（question_id）下的评论（comment_id）^
        -- AgreeQuestionComment
 *      *某人（trigger_id）赞同了你在问题（question_id）下某人（answerer_id）回答下的评论（comment_id）^
        -- AgreeAnswerComment
 *      *某人（trigger_id）赞同了你在专栏文章（article_id）下的评论（comment_id）^
        -- AgreeArticleComment
 * 		*二级回复 某人（trigger_id）回复了你在某问题（question_id）下的评论（comment_id）^
        -- ReplyQuestionCommentMsg
 * 		*二级回复 某人（trigger_id）回复了你在某问题（question_id）下某人（answerer_id）回答下的评论（comment_id）^
        -- ReplyAnswerCommentMsg
 * 		*二级回复 某人（trigger_id）回复了你在某专栏文章（article_id）下的评论（comment_id）^
        -- ReplyArticleCommentMsg
 * 		*某人（trigger_id）关注了你^
        -- FollowingYouMsg
 * 		*@用户（trigger_id） 提到了你^
        -- AtYouMsg
 * 		**某人（trigger_id）在你关注的问题（question_id）发表了一个新回答（answer_id） #
        -- NewAnswerMsg
 * 	2. 系统通知（私信页面）
 * 		*系统公告私信 #	-- SystemMessage
 */
CREATE TABLE IF NOT EXISTS message_groups (
    id          INT(11) NOT NULL AUTO_INCREMENT, /* 消息组 ID（唯一标识） */
    trigger_id  INT(11) NOT NULL DEFAULT '0', /* 触发用户 ID */
    question_id INT(11) NOT NULL DEFAULT '0', /* 问题 ID */
    article_id  INT(11) NOT NULL DEFAULT '0', /* 专栏文章 ID */
    answer_id   INT(11) NOT NULL DEFAULT '0', /* 回答 ID */
    answerer_id INT(11) NOT NULL DEFAULT '0', /* 回答用户 ID */
    comment_id  INT(11) NOT NULL DEFAULT '0', /* 评论 ID */
    user_id     INT(11) NOT NULL DEFAULT '0', /* 用户 ID */
    PRIMARY KEY (id),
    INDEX (trigger_id),
    INDEX (question_id),
    INDEX (article_id),
    INDEX (answer_id),
    INDEX (answerer_id),
    INDEX (comment_id),
    INDEX (user_id)
);

/**
 * 举报类型表
 */
CREATE TABLE IF NOT EXISTS report_type (
    id                  INT(11)     NOT NULL AUTO_INCREMENT, /* 举报类型主键 ID（唯一标识） */
    report_type_content VARCHAR(64) NOT NULL, /* 举报类型 */
    is_common           INT(11)     NOT NULL DEFAULT '0', /* 判断是否是通用类型（即回答评论类型） */
    PRIMARY KEY (id)
);

/**
 * 举报表
 */
CREATE TABLE IF NOT EXISTS reports (
    id                 INT(11)      NOT NULL AUTO_INCREMENT, /* 举报主键ID（唯一标识） */
    report_type_id     INT(11)      NOT NULL DEFAULT '0', /* 举报类型 ID */
    report_category    TINYINT(4)   NOT NULL DEFAULT '0', /* 举报内容所属分类 1：问题，2：回答，3：评论 */
    report_category_id INT(11)      NOT NULL, /* 举报内容所属分类对应的问题、评论、回答id */
    report_time        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 举报时间 */
    report_reason      VARCHAR(512) NOT NULL, /* 举报理由 */
    is_resolved        TINYINT(4)   NOT NULL DEFAULT '0', /* 是否处理完成，1：是，0：否 */
    user_id            INT(11)      NOT NULL DEFAULT '0', /* 举报用户 ID（唯一标识） */
    PRIMARY KEY (id),
    INDEX (report_type_id),
    INDEX (report_category),
    INDEX (is_resolved),
    INDEX (user_id)
);

/*
 * 所属行业表
 */
CREATE TABLE IF NOT EXISTS business (
    id       INT(11)     NOT NULL AUTO_INCREMENT, /* 所在行业主键ID（唯一标识） */
    job_name VARCHAR(64) NOT NULL, /* 所在行业名称 */
    PRIMARY KEY (id)
);

/*
 * 页面信息表
 */
CREATE TABLE IF NOT EXISTS pages (
    id          INT(11)     NOT NULL AUTO_INCREMENT, /* 页面信息 ID */
    url_token   VARCHAR(32) NOT NULL, /* 页面 URL */
    title       VARCHAR(255)         DEFAULT NULL, /* 页面 title */
    keywords    VARCHAR(255)         DEFAULT NULL, /* 页面关键字 */
    description VARCHAR(255)         DEFAULT NULL, /* 页面描述 */
    contents    TEXT, /* 页面 content 信息 */
    enabled     INT(11)     NOT NULL DEFAULT '0', /* 页面是否可用 */
    PRIMARY KEY (id),
    UNIQUE KEY (url_token),
    INDEX (url_token)
)