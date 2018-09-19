package com.coeligena.dao;

import com.coeligena.model.ThanksDO;

/**
 * <p>
 *     用户感谢数据访问对象
 * </p>
 * Created by Ellery on 2018/9/19.
 */
public interface ThanksDAO {

    /**
     * 添加用户感谢
     * @param thanksDO 感谢信息
     */
    void addThank(ThanksDO thanksDO);

    /**
     * 有回答 id 和感谢用户 id 查询感谢信息
     * @param answerId 问题 id
     * @param thankUserId 用户 id
     * @return 详细信息
     */
    ThanksDO queryThanksByAnswerIdAndUId(int answerId, int thankUserId);

    /**
     * 删除感谢
     * @param thanksDO 感谢信息
     */
    void deleteThank(ThanksDO thanksDO);
}
