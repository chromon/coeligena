package com.coeligena.controller;

import com.coeligena.dto.*;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.digest.AnswerDigest;
import com.coeligena.function.paging.Page;
import com.coeligena.function.vote.WilsonScoreInterval;
import com.coeligena.model.*;
import com.coeligena.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    private ThanksService thanksService;
    private NoHelpsService noHelpsService;

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
        Timestamp now = DateUtils.currentTime();

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
     * @param request http servlet request
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
        Timestamp now = DateUtils.currentTime();

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
                // 更新排序分数
                double wsiScore = WilsonScoreInterval.getWSI(
                        answersDO.getApprovalCount(), answersDO.getAgainstCount());
                answersDO.setWsiScore(wsiScore);
            } else if (voteAction == 2) {
                // 反对
                votesDO1.setVoteType((byte) 2);
                // 更新回答反对数
                answersDO.setAgainstCount(answersDO.getAgainstCount() + 1);
                // 更新排序分数
                double wsiScore = WilsonScoreInterval.getWSI(
                        answersDO.getApprovalCount(), answersDO.getAgainstCount());
                answersDO.setWsiScore(wsiScore);
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
                    // 更新排序分数
                    double wsiScore = WilsonScoreInterval.getWSI(
                            answersDO.getApprovalCount(), answersDO.getAgainstCount());
                    answersDO.setWsiScore(wsiScore);
                    this.answersService.modifyAnswers(answersDO);
                } else if (voteAction == 2) {
                    // 反对（更新赞改踩）
                    votesDO.setVoteType((byte) 2);
                    this.votesService.modifyVotes(votesDO);
                    // 回答赞同数 - 1 反对数 + 1
                    answersDO.setApprovalCount(answersDO.getApprovalCount() - 1);
                    answersDO.setAgainstCount(answersDO.getAgainstCount() + 1);
                    // 更新排序分数
                    double wsiScore = WilsonScoreInterval.getWSI(
                            answersDO.getApprovalCount(), answersDO.getAgainstCount());
                    answersDO.setWsiScore(wsiScore);
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
                    // 更新排序分数
                    double wsiScore = WilsonScoreInterval.getWSI(
                            answersDO.getApprovalCount(), answersDO.getAgainstCount());
                    answersDO.setWsiScore(wsiScore);
                    this.answersService.modifyAnswers(answersDO);
                } else if (voteAction == 2) {
                    // 反对（取消反对，删除信息）
                    this.votesService.deleteVotes(votesDO);
                    // 回答反对数 - 1
                    answersDO.setAgainstCount(answersDO.getAgainstCount() - 1);
                    // 更新排序分数
                    double wsiScore = WilsonScoreInterval.getWSI(
                            answersDO.getApprovalCount(), answersDO.getAgainstCount());
                    answersDO.setWsiScore(wsiScore);
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
     * 回答默认排序
     * @param questionId 问题 id
     * @return 回答信息列表
     */
    @RequestMapping(value="/default-sort", method = RequestMethod.GET)
    @ResponseBody
    public List<AnswersDTO> defaultSortAnswer(HttpServletRequest request, @RequestParam("questionId") int questionId) {

        // 初始化分页信息
        int count = answersService.queryAnswersCountByQuestionId(questionId);
        Page page = new Page(1, 5);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        // 查询回答列表
        List<AnswersDO> answersList = answersService.queryAnswersByQuestionIdSortedWSIWithPage(page, questionId);
        return sortAnswerFunc(request, answersList);
    }

    /**
     * 按时间排序回答
     * @param questionId 问题 id
     * @return 回答信息列表
     */
    @RequestMapping(value="/time-sort", method = RequestMethod.GET)
    @ResponseBody
    public List<AnswersDTO> timeSortAnswer(HttpServletRequest request, @RequestParam("questionId")  int questionId) {

        // 初始化分页信息
        int count = answersService.queryAnswersCountByQuestionId(questionId);
        Page page = new Page(1, 5);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        // 查询回答列表
        List<AnswersDO> answersList = answersService.queryAnswersByQuestionIdWithPage(page, questionId);
        return sortAnswerFunc(request, answersList);
    }

    /**
     * 排序方法
     * @param request http servlet request
     * @param answersList 回答列表
     * @return 回答信息列表
     */
    private List<AnswersDTO> sortAnswerFunc(HttpServletRequest request, List<AnswersDO> answersList) {

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        List<AnswersDTO> answersDTOList = new ArrayList<>();
        for (AnswersDO answersDO: answersList) {
            // 查询作者信息
            UsersDO usersDO = usersService.queryUserByUserId(answersDO.getAuthorId());

            // 查询回答投票信息
            VotesDO votesDO = votesService.queryVotesByAnswerIdAndVoterId(
                    answersDO.getId(), usersDO.getId());

            // 查询感谢信息
            ThanksDO thanksDO = thanksService.queryThanksByAnswerIdAndUId(answersDO.getId(), userInfoDTO.getUsersDO().getId());

            // 查询是否提交没有帮助
            NoHelpsDO noHelpsDO = noHelpsService.queryNoHelpByAnswerIdAndUid(answersDO.getId(), userInfoDTO.getUsersDO().getId());

            // 回答信息
            AnswersDTO answersDTO = new AnswersDTO();
            answersDTO.setUsersDO(usersDO);
            answersDTO.setAnswersDO(answersDO);
            answersDTO.setVotesDO(votesDO);

            if (thanksDO != null) {
                answersDTO.setThanked(true);
            } else {
                answersDTO.setThanked(false);
            }

            if (noHelpsDO != null) {
                answersDTO.setNoHelp(true);
            } else {
                answersDTO.setNoHelp(false);
            }

            answersDTOList.add(answersDTO);
        }
        return answersDTOList;
    }

    @RequestMapping(value="/default-more-answers", method = RequestMethod.POST)
    @ResponseBody
    public PagingListDTO<AnswersDTO> defaultMoreAnswers(HttpServletRequest request,
                                        @RequestParam("questionId")  int questionId,
                                        @RequestParam("pageNum") int pageNum) {
        // 初始化分页信息
        int count = answersService.queryAnswersCountByQuestionId(questionId);
        int pageSize = 5;
        Page page = new Page(pageNum, pageSize);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        // 查询回答列表
        List<AnswersDO> answersList = answersService.queryAnswersByQuestionIdSortedWSIWithPage(page, questionId);

        return new PagingListDTO<>(sortAnswerFunc(request, answersList), page);
    }

    @RequestMapping(value="/time-more-answers", method = RequestMethod.POST)
    @ResponseBody
    public PagingListDTO<AnswersDTO> timeMoreAnswers(HttpServletRequest request,
                                                 @RequestParam("questionId")  int questionId,
                                                 @RequestParam("pageNum") int pageNum) {
        // 初始化分页信息
        int count = answersService.queryAnswersCountByQuestionId(questionId);
        Page page = new Page(pageNum, 5);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        // 查询回答列表
        List<AnswersDO> answersList = answersService.queryAnswersByQuestionIdWithPage(page, questionId);

        return new PagingListDTO<>(sortAnswerFunc(request, answersList), page);
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
    public void setThanksService(ThanksService thanksService) {
        this.thanksService = thanksService;
    }

    @Autowired
    public void setNoHelpsService(NoHelpsService noHelpsService) {
        this.noHelpsService = noHelpsService;
    }
}
