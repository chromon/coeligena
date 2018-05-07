package com.coeligena.dto;

/**
 * <p>
 *     提问数据传输对象
 * </p>
 *
 * Created by Ellery on 2018/5/4.
 */
public class CreateQuestionDTO {

    private String questionContent;

    private String questionDetail;

    private String[] topics;

    private String anonymous;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public String getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }
}
