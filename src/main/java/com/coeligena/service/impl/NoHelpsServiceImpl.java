package com.coeligena.service.impl;

import com.coeligena.dao.NoHelpDAO;
import com.coeligena.model.NoHelpsDO;
import com.coeligena.service.NoHelpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 回答没有帮助业务逻辑实现类
 * Created by Ellery on 2018/9/21.
 */
@Service("noHelpsService")
public class NoHelpsServiceImpl implements NoHelpsService {

    private NoHelpDAO noHelpDAO;

    /**
     * 添加回答没有帮助数据
     * @param noHelpsDO 回答没有帮助信息
     */
    @Override
    public void saveNoHelp(NoHelpsDO noHelpsDO) {
        this.noHelpDAO.addNoHelp(noHelpsDO);
    }

    /**
     * 由回答 id 和用户 id 查询回答没有帮助信息
     * @param answerId 回答 id
     * @param userId 用户 id
     * @return 回答没有帮助信息
     */
    @Override
    public NoHelpsDO queryNoHelpByAnswerIdAndUid(int answerId, int userId) {
        return this.noHelpDAO.queryNoHelpByAnswerIdAndUid(answerId, userId);
    }

    /**
     * 删除没有帮助信息
     * @param noHelpsDO 没有帮助信息
     */
    @Override
    public void deleteNoHelp(NoHelpsDO noHelpsDO) {
        this.noHelpDAO.deleteNoHelp(noHelpsDO);
    }

    @Autowired
    public void setNoHelpDAO(NoHelpDAO noHelpDAO) {
        this.noHelpDAO = noHelpDAO;
    }
}
