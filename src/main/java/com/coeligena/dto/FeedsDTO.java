package com.coeligena.dto;

import com.coeligena.model.*;

import java.io.Serializable;

/**
 * 首页动态内容传输对象
 *
 * Created by Ellery on 2018/5/26.
 */
public class FeedsDTO implements Serializable {

    private FeedsDO feedsDO;

    private QuestionsDO questionsDO;

    private AnswersDO answersDO;

    private VotesDO votesDO;

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

    public VotesDO getVotesDO() {
        return votesDO;
    }

    public void setVotesDO(VotesDO votesDO) {
        this.votesDO = votesDO;
    }
}
