package com.coeligena.service.impl;

import com.coeligena.dao.QuestionTagsDAO;
import com.coeligena.model.QuestionTagsDO;
import com.coeligena.model.TopicNodesDO;
import com.coeligena.service.QuestionTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     问题标签业务逻辑实现类
 * </p>
 * Created by Ellery on 2018/5/20.
 */
@Service("questionTagsService")
public class QuestionTagsServiceImpl implements QuestionTagsService {

    private QuestionTagsDAO questionTagsDAO;

    @Override
    public void saveQuestionTag(QuestionTagsDO questionTagsDO) {
        this.questionTagsDAO.addQuestionTag(questionTagsDO);
    }

    @Override
    public List<TopicNodesDO> queryQuestionTagByQid(int questionId) {
        return this.questionTagsDAO.queryQuestionTagsByQid(questionId);
    }

    @Autowired
    public void setQuestionTagsDAO(QuestionTagsDAO questionTagsDAO) {
        this.questionTagsDAO = questionTagsDAO;
    }
}
