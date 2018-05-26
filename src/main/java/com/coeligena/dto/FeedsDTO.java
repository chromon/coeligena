package com.coeligena.dto;

import com.coeligena.model.AnswersDO;
import com.coeligena.model.FeedsDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.UsersDO;

/**
 * 首页动态内容传输对象
 *
 * Created by Ellery on 2018/5/26.
 */
public class FeedsDTO {

    private FeedsDO feedsDO;

    private QuestionsDO questionsDO;

    private AnswersDO   answersDO;

    private UsersDO usersDO;

    public FeedsDO getFeedsDO() {
        return feedsDO;
    }

    public void setFeedsDO(FeedsDO feedsDO) {
        this.feedsDO = feedsDO;
    }

    public QuestionsDO getQuestionsDO() {
        return questionsDO;
    }

    public void setQuestionsDO(QuestionsDO questionsDO) {
        this.questionsDO = questionsDO;
    }

    public AnswersDO getAnswersDO() {
        return answersDO;
    }

    public void setAnswersDO(AnswersDO answersDO) {
        this.answersDO = answersDO;
    }

    public UsersDO getUsersDO() {
        return usersDO;
    }

    public void setUsersDO(UsersDO usersDO) {
        this.usersDO = usersDO;
    }
}
