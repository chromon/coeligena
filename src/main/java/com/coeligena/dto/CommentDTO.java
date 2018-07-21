package com.coeligena.dto;

import com.coeligena.model.QuestionCommentsDO;
import com.coeligena.model.UsersDO;

/**
 * comment dto
 * Created by Ellery on 2018/7/2.
 */
public class CommentDTO {

    private int questionId;

    private UsersDO reviewer;

    private QuestionCommentsDO questionCommentsDO;

    private UsersDO user;

    private int commentAction;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public UsersDO getReviewer() {
        return reviewer;
    }

    public void setReviewer(UsersDO reviewer) {
        this.reviewer = reviewer;
    }

    public QuestionCommentsDO getQuestionCommentsDO() {
        return questionCommentsDO;
    }

    public void setQuestionCommentsDO(QuestionCommentsDO questionCommentsDO) {
        this.questionCommentsDO = questionCommentsDO;
    }

    public UsersDO getUser() {
        return user;
    }

    public void setUser(UsersDO user) {
        this.user = user;
    }

    public int getCommentAction() {
        return commentAction;
    }

    public void setCommentAction(int commentAction) {
        this.commentAction = commentAction;
    }
}
