package com.coeligena.service;

import com.coeligena.model.NoHelpsDO;

/**
 * 回答没有帮助业务逻辑
 * Created by Ellery on 2018/9/21.
 */
public interface NoHelpsService {

    /**
     * 添加回答没有帮助数据
     * @param noHelpsDO 回答没有帮助信息
     */
    void saveNoHelp(NoHelpsDO noHelpsDO);

    /**
     * 由回答 id 和用户 id 查询回答没有帮助信息
     * @param answerId 回答 id
     * @param userId 用户 id
     * @return 回答没有帮助信息
     */
    NoHelpsDO queryNoHelpByAnswerIdAndUid(int answerId, int userId);

    /**
     * 删除没有帮助信息
     * @param noHelpsDO 没有帮助信息
     */
    void deleteNoHelp(NoHelpsDO noHelpsDO);
}
