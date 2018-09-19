package com.coeligena.service.impl;

import com.coeligena.dao.ThanksDAO;
import com.coeligena.model.ThanksDO;
import com.coeligena.service.ThanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     感谢信息业务逻辑实现类
 * </p>
 * Created by Ellery on 2018/9/19.
 */
@Service("thanksService")
public class ThanksServiceImpl implements ThanksService {

    private ThanksDAO thanksDAO;

    /**
     * 添加用户感谢
     * @param thanksDO 感谢信息
     */
    @Override
    public void saveThank(ThanksDO thanksDO) {
        this.thanksDAO.addThank(thanksDO);
    }

    /**
     * 有回答 id 和感谢用户 id 查询感谢信息
     * @param answerId 问题 id
     * @param thankUserId 用户 id
     * @return 详细信息
     */
    @Override
    public ThanksDO queryThanksByAnswerIdAndUId(int answerId, int thankUserId) {
        return this.thanksDAO.queryThanksByAnswerIdAndUId(answerId, thankUserId);
    }

    /**
     * 删除感谢
     * @param thanksDO 感谢信息
     */
    @Override
    public void deleteThank(ThanksDO thanksDO) {
        this.thanksDAO.deleteThank(thanksDO);
    }

    @Autowired
    public void setThanksDAO(ThanksDAO thanksDAO) {
        this.thanksDAO = thanksDAO;
    }
}
