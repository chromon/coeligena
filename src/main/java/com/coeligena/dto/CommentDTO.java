package com.coeligena.dto;

import com.coeligena.model.AnswersDO;
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

    private AnswersDO answersDO;

    private UsersDO user;

    private int commentAction;

    private int commentId;

    private boolean like;

    private boolean unlike;

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

    public AnswersDO getAnswersDO() {
        return answersDO;
    }

    public void setAnswersDO(AnswersDO answersDO) {
        this.answersDO = answersDO;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isUnlike() {
        return unlike;
    }

    public void setUnlike(boolean unlike) {
        this.unlike = unlike;
    }
}
