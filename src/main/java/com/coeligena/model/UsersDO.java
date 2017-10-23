package com.coeligena.model;

import javax.persistence.*;

/**
 * 用户信息实体类
 *
 * <p>
 * Created by Ellery on 2017/9/21.
 */
@Entity
@Table(name = "user")
public class UsersDO {

    /** 用户信息 id */
    private int id;

    /** 用户全名 */
    private String fullname;

    /** 性别 */
    private int gender;

    /** 头像路径 */
    private String avatarPath;

    /** 居住位置 */
    private String location;

    /** 行业 */
    private int businessId;

    /** 公司或组织名称 */
    private String employment;

    /** 职位 */
    private String position;

    /** 学校或教育机构 */
    private String education;

    /** 专业 */
    private String major;

    /** 个人描述 */
    private String description;

    /** 签名 */
    private String autograph;

    /** 获得赞同数 */
    private int approvalCount;

    /** 获得感谢数 */
    private int thankCount;

    /** 提问数 */
    private int questionCount;

    /** 回答数 */
    private int answerCount;

    /** 收藏夹数 */
    private int collectCount;

    /** 邀请回答数 */
    private int inviteCount;

    /** 主页浏览数 */
    private int profileViewCount;

    /** 个性网址 */
    private String personalityURL;

    /** 邮箱地址是否激活 */
    private byte isEmailActive;

    /** 手机是否激活 */
    private byte isPhoneActive;

    /** 验证用户 id */
    private int authUserId;

    /**
     * 获取用户信息 id
     * @return 用户信息 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置用户信息 id
     * @param id 用户信息 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取全名
     * @return 用户全名
     */
    @Column(name = "fullname", nullable = false, length = 64)
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置用户全名
     * @param fullname 用户全名
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 获取性别
     * @return 性别
     */
    @Column(name = "gender", nullable = false)
    public int getGender() {
        return gender;
    }

    /**
     * 设置性别
     * @param gender 性别
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取头像路径
     * @return 头像路径
     */
    @Column(name = "avatar_path", length = 256)
    public String getAvatarPath() {
        return avatarPath;
    }

    /**
     * 设置头像路径
     * @param avatarPath 头像路径
     */
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    /**
     * 获取居住位置
     * @return 居住位置
     */
    @Column(name = "location", length = 128)
    public String getLocation() {
        return location;
    }

    /**
     * 设置居住位置
     * @param location 居住位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取行业
     * @return 行业
     */
    @Column(name = "business_id")
    public int getBusinessId() {
        return businessId;
    }

    /**
     * 设置行业
     * @param businessId 行业
     */
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取公司或组织名称
     * @return 公司或组织名称
     */
    @Column(name = "employment", length = 128)
    public String getEmployment() {
        return employment;
    }

    /**
     * 设置公司或组织名称
     * @param employment 公司或组织名称
     */
    public void setEmployment(String employment) {
        this.employment = employment;
    }

    /**
     * 获取职位
     * @return 职位
     */
    @Column(name = "position", length = 128)
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 学校或教育机构
     * @return 学校或教育机构
     */
    @Column(name = "education", length = 128)
    public String getEducation() {
        return education;
    }

    /**
     * 设置学校或教育机构
     * @param education 学校或教育机构
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取专业
     * @return 专业
     */
    @Column(name = "major", length = 128)
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取个人描述
     * @return 个人描述
     */
    @Column(name = "description", length = 128)
    public String getDescription() {
        return description;
    }

    /**
     * 设置个人描述
     * @param description 个人描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取签名
     * @return 签名
     */
    @Column(name = "autograph", length = 128)
    public String getAutograph() {
        return autograph;
    }

    /**
     * 设置签名
     * @param autograph 签名
     */
    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    /**
     * 获取赞同数
     * @return 赞同数
     */
    @Column(name = "approve_count", nullable = false)
    public int getApprovalCount() {
        return approvalCount;
    }

    /**
     * 设置赞同数
     * @param approvalCount 赞同数
     */
    public void setApprovalCount(int approvalCount) {
        this.approvalCount = approvalCount;
    }

    /**
     * 获取获得的感谢数
     * @return  获得的感谢数
     */
    @Column(name = "thank_count", nullable = false)
    public int getThankCount() {
        return thankCount;
    }

    /**
     * 设置获得的感谢数
     * @param thankCount 获得的感谢数
     */
    public void setThankCount(int thankCount) {
        this.thankCount = thankCount;
    }

    /**
     * 获取提问数
     * @return 提问数
     */
    @Column(name = "question_count", nullable = false)
    public int getQuestionCount() {
        return questionCount;
    }

    /**
     * 设置提问数
     * @param questionCount 提问数
     */
    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    /**
     * 获取回答数
     * @return 回答数
     */
    @Column(name = "answer_count", nullable = false)
    public int getAnswerCount() {
        return answerCount;
    }

    /**
     * 设置回答数
     * @param answerCount 回答数
     */
    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    /**
     * 获取收藏夹数
     * @return 收藏夹数
     */
    @Column(name = "collect_count", nullable = false)
    public int getCollectCount() {
        return collectCount;
    }

    /**
     * 设置收藏夹数
     * @param collectCount 收藏夹数
     */
    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    /**
     * 获取个性网址
     * @return 个性网址
     */
    @Column(name = "personality_url", length = 64)
    public String getPersonalityURL() {
        return personalityURL;
    }

    /**
     * 设置个性网址
     * @param personalityURL 个性网址
     */
    public void setPersonalityURL(String personalityURL) {
        this.personalityURL = personalityURL;
    }

    /**
     * 获取邮箱是否激活
     * @return 邮箱是否激活
     */
    @Column(name = "is_email_active", nullable = false, columnDefinition = "tinyint")
    public byte getIsEmailActive() {
        return isEmailActive;
    }

    /**
     * 设置邮箱是否激活
     * @param isEmailActive 邮箱是否激活
     */
    public void setIsEmailActive(byte isEmailActive) {
        this.isEmailActive = isEmailActive;
    }

    /**
     * 获取邀请回答数量
     * @return 邀请回答数量
     */
    @Column(name = "invite_count", nullable = false)
    public int getInviteCount() {
        return inviteCount;
    }

    /**
     * 设置邀请回答数量
     * @param inviteCount 邀请回答数量
     */
    public void setInviteCount(int inviteCount) {
        this.inviteCount = inviteCount;
    }

    /**
     * 获取主页浏览数量
     * @return 主页浏览数量
     */
    @Column(name = "profile_view_count", nullable = false)
    public int getProfileViewCount() {
        return profileViewCount;
    }

    /**
     * 获取主页浏览数量
     * @param profileViewCount 主页浏览数量
     */
    public void setProfileViewCount(int profileViewCount) {
        this.profileViewCount = profileViewCount;
    }

    /**
     * 手机是否激活
     * @return 是否激活
     */
    @Column(name = "is_phone_active", nullable = false, columnDefinition = "tinyint")
    public byte getIsPhoneActive() {
        return isPhoneActive;
    }

    /**
     * 设置手机是否激活
     * @param isPhoneActive 手机是否激活
     */
    public void setIsPhoneActive(byte isPhoneActive) {
        this.isPhoneActive = isPhoneActive;
    }

    /**
     * 获取验证用户 id
     * @return 验证用户 id
     */
    @Column(name = "auth_user_id", nullable = false)
    public int getAuthUserId() {
        return authUserId;
    }

    /**
     * 设置验证用户 id
     * @param authUserId 验证用户 id
     */
    public void setAuthUserId(int authUserId) {
        this.authUserId = authUserId;
    }
}
