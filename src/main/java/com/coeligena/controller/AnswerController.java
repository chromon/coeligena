package com.coeligena.controller;

import com.coeligena.dto.*;
import com.coeligena.function.digest.AnswerDigest;
import com.coeligena.model.*;
import com.coeligena.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     answer controller
 * </p>
 * Created by Ellery on 2018/6/12.
 */
@Controller
public class AnswerController {

    private UsersService usersService;
    private AnswersService answersService;
    private QuestionsService questionsService;
    private VotesService votesService;
    private FeedsService feedsService;
    private AnswerCommentsService answerCommentsService;

    /**
     * 回答问题 Ajax 请求
     * @param request request
     * @param postAnswerDTO 回答 dto
     * @return 回答详细信息
     */
    @RequestMapping(value="/answer-the-question", method = RequestMethod.POST)
    @ResponseBody
    public AnswersDO answerQuestion(HttpServletRequest request,
                                    @ModelAttribute PostAnswerDTO postAnswerDTO) {

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 更新用户回答数
        UsersDO usersDO = userInfoDTO.getUsersDO();
        usersDO.setAnswerCount(usersDO.getAnswerCount() + 1);
        usersService.modifyUsers(usersDO);

        // 更新问题回答数
        QuestionsDO questionsDO = questionsService.queryQuestionById(
                Integer.parseInt(postAnswerDTO.getQuestionId()));
        questionsDO.setAnswerCount(questionsDO.getAnswerCount() + 1);
        questionsService.modifyQuestion(questionsDO);

        // 添加回答
        AnswersDO answersDO = new AnswersDO();
        answersDO.setQuestionId(Integer.parseInt(postAnswerDTO.getQuestionId()));
        answersDO.setAuthorId(usersDO.getId());
        answersDO.setCover("");
        answersDO.setAnswerDigest(AnswerDigest.getDigest(postAnswerDTO.getAnswerContent(), 100, "..."));
        answersDO.setAnswerContent(postAnswerDTO.getAnswerContent());
        answersDO.setAnswerTime(now);
        answersDO.setAnonymous(Byte.parseByte(postAnswerDTO.getAnonymous()));
        answersDO.setReprintType(Byte.parseByte(postAnswerDTO.getReprintType()));
        answersDO.setCommentType(Byte.parseByte(postAnswerDTO.getCommentType()));
        answersService.saveAnswer(answersDO);

        return answersDO;
    }

    /**
     * 回答投票 ajax 请求
     * @param request httpservletrequest
     * @param answersDTO 回答信息传输对象
     * @return success or not
     */
    @RequestMapping(value = "/answer-vote", method = RequestMethod.POST)
    @ResponseBody
    public String answerVote(HttpServletRequest request,
                             @ModelAttribute AnswersDTO answersDTO) {

        int answerId = answersDTO.getAnswerId();
        // 赞：1，踩：2
        int voteAction = answersDTO.getVoteAction();

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 查询是否投过票
        VotesDO votesDO = this.votesService.queryVotesByAnswerIdAndVoterId(answerId, userInfoDTO.getUsersDO().getId());

        // 对应回答信息
        AnswersDO answersDO = this.answersService.queryAnswersById(answerId);

        if (votesDO == null) {
            // 赞同反对不存在
            // 保存赞同信息
            VotesDO votesDO1 = new VotesDO();
            votesDO1.setAnswerId(answerId);
            votesDO1.setVoterId(userInfoDTO.getUsersDO().getId());
            votesDO1.setVoteTime(now);
            if (voteAction == 1) {
                // 赞同
                votesDO1.setVoteType((byte) 1);
                // 更新回答赞同数
                answersDO.setApprovalCount(answersDO.getApprovalCount() + 1);
            } else if (voteAction == 2) {
                // 反对
                votesDO1.setVoteType((byte) 2);
                // 更新回答反对数
                answersDO.setAgainstCount(answersDO.getAgainstCount() + 1);
            }
            this.votesService.saveVotes(votesDO1);
            this.answersService.modifyAnswers(answersDO);
        } else {
            // 已存在投票信息
            if (votesDO.getVoteType() == 1) {
                // 已赞
                if (voteAction == 1) {
                    // 点赞（取消赞，直接删除信息）
                    this.votesService.deleteVotes(votesDO);
                    // 回答赞同数 - 1
                    answersDO.setApprovalCount(answersDO.getApprovalCount() - 1);
                    this.answersService.modifyAnswers(answersDO);
                } else if (voteAction == 2) {
                    // 反对（更新赞改踩）
                    votesDO.setVoteType((byte) 2);
                    this.votesService.modifyVotes(votesDO);
                    // 回答赞同数 - 1 反对数 + 1
                    answersDO.setApprovalCount(answersDO.getApprovalCount() - 1);
                    answersDO.setAgainstCount(answersDO.getAgainstCount() + 1);
                    this.answersService.modifyAnswers(answersDO);
                }
            } else if (votesDO.getVoteType() == 2) {
                // 已踩
                if (voteAction == 1) {
                    // 点赞（更新踩改赞）
                    votesDO.setVoteType((byte) 1);
                    this.votesService.modifyVotes(votesDO);
                    // 回答赞同数 + 1 反对数 - 1
                    answersDO.setApprovalCount(answersDO.getApprovalCount() + 1);
                    answersDO.setAgainstCount(answersDO.getAgainstCount() - 1);
                    this.answersService.modifyAnswers(answersDO);
                } else if (voteAction == 2) {
                    // 反对（取消反对，删除信息）
                    this.votesService.deleteVotes(votesDO);
                    // 回答反对数 - 1
                    answersDO.setAgainstCount(answersDO.getAgainstCount() - 1);
                    this.answersService.modifyAnswers(answersDO);
                }
            }
        }

        if ((votesDO == null || votesDO.getVoteType() == 2) && voteAction == 1) {
            // 添加动态
            FeedsDO feedsDO = new FeedsDO();
            // 动态类型所对应的ID,如关注和提出问题对应的是问题ID，赞同回答和回答问题对应的是回答ID
            feedsDO.setFeedsId(answersDO.getId());
            // 动态类型 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题
            byte feedsType = 2;
            feedsDO.setFeedsType(feedsType);
            feedsDO.setFeedsTime(now);
            feedsDO.setFeedsUserId(userInfoDTO.getUsersDO().getId());
            feedsService.saveFeeds(feedsDO);
        }

        return answersDO.getApprovalCount() + "";
    }

    /**
     * 提交回答评论
     * @param request http servlet request
     * @param answerCommentsDTO 回答评论 dto
     * @return 回答评论信息
     */
    @RequestMapping(value = "/answer-comment", method = RequestMethod.POST)
    @ResponseBody
    public CommentDTO answersComment(HttpServletRequest request,
                                     @ModelAttribute AnswerCommentsDTO answerCommentsDTO) {
        return this.postAnswerCommentsFunc(request, answerCommentsDTO);
    }

    /**
     * 问题评论处理方法
     * @param request http servlet request
     * @param answerCommentsDTO 回答评论 dto
     * @return 评论信息
     */
    private CommentDTO postAnswerCommentsFunc(HttpServletRequest request,
                                              AnswerCommentsDTO answerCommentsDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 保存回答评论信息
        AnswerCommentsDO answerCommentsDO = new AnswerCommentsDO();
        answerCommentsDO.setAnswerId(answerCommentsDTO.getAnswerId());
        answerCommentsDO.setReviewerId(answerCommentsDTO.getReviewerId());
        answerCommentsDO.setParentCommentId(answerCommentsDTO.getParentCommentId());
        answerCommentsDO.setCommentContent(answerCommentsDTO.getCommentContent());
        answerCommentsDO.setCommentTime(now);
        answerCommentsDO.setUserId(userInfoDTO.getUsersDO().getId());
        this.answerCommentsService.saveAnswerComment(answerCommentsDO);

        // 返回信息
        CommentDTO commentDTO = new CommentDTO();
//        commentDTO.setAnswerCommentsDO(answerCommentsDO);

        return commentDTO;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAnswersService(AnswersService answersService) {
        this.answersService = answersService;
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Autowired
    public void setVotesService(VotesService votesService) {
        this.votesService = votesService;
    }

    @Autowired
    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }

    @Autowired
    public void setAnswerCommentsService(AnswerCommentsService answerCommentsService) {
        this.answerCommentsService = answerCommentsService;
    }
}
