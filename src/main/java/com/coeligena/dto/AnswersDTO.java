package com.coeligena.dto;

import com.coeligena.model.AnswersDO;
import com.coeligena.model.UsersDO;

/**
 * <p>
 *     answers dto
 * </p>
 * Created by Ellery on 2018/6/18.
 */
public class AnswersDTO {

    private AnswersDO answersDO;

    private UsersDO usersDO;

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
