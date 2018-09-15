package com.coeligena.controller;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.dto.AnswerCommentsDTO;
import com.coeligena.dto.CommentDTO;
import com.coeligena.dto.PagingListDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;
import com.coeligena.model.AnswersDO;
import com.coeligena.model.CommentApprovalsDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.AnswerCommentsService;
import com.coeligena.service.CommentApprovalsService;
import com.coeligena.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 回答评论 controller
 * Created by Ellery on 2018/8/14.
 */
@Controller
public class AnswerCommentController {

    private AnswerCommentsService answerCommentsService;
    private UsersService usersService;
    private CommentApprovalsService commentApprovalsService;
    private AnswersDAO answersDAO;

    /**
     * 回答评论列表
     * @param request http servlet request
     * @return 回答评论列表
     */
    @RequestMapping(value = "/answer-comment-list", method = RequestMethod.GET)
    @ResponseBody
    public PagingListDTO<CommentDTO> answerCommentList(HttpServletRequest request,
                                                       @RequestParam("answerId") int answerId) {
        return answerCommentsPagingList(request, 1, answerId);
    }

    /**
     * 回答评论翻页
     * @param request http servlet request
     * @param pageNum 页数
     * @return 回答评论列表
     */
    @RequestMapping(value = "/answer-comments-with-page", method = RequestMethod.GET)
    @ResponseBody
    public PagingListDTO<CommentDTO> answerCommentsWithPage(HttpServletRequest request,
                                                            @RequestParam("pageNum") int pageNum,
                                                            @RequestParam("answerId") int answerId) {
        return answerCommentsPagingList(request, pageNum, answerId);
    }

    /**
     * 分页查询回答评论
     * @param request http servlet request
     * @param pageNum 页数
     * @return 回答评论列表
     */
    private PagingListDTO<CommentDTO> answerCommentsPagingList(HttpServletRequest request, int pageNum, int answerId) {

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        List<CommentDTO> commentDTOList = new ArrayList<>();

        int count = this.answerCommentsService.queryAnswerCommentsCount(answerId);

        // 初始化分页信息
        Page page = new Page(pageNum, 2);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        List<AnswerCommentsDO> answerCommentsDOList = this.answerCommentsService
                .queryAnswerCommentsByPage(page, answerId);
        for (AnswerCommentsDO answerCommentsDO: answerCommentsDOList) {
            CommentDTO commentDTO = new CommentDTO();

            // 查询被评论用户信息
            UsersDO reviewer = null;
            if (answerCommentsDO.getReviewerId() != 0) {
                reviewer = this.usersService.queryUserByUserId(answerCommentsDO.getReviewerId());
            }

            // 查询评论用户信息
            UsersDO user = this.usersService.queryUserByUserId(answerCommentsDO.getUserId());

            // 查询是否赞踩
            CommentApprovalsDO commentApprovalsDO = this.commentApprovalsService
                    .queryCommentApprByCommentIdAndUserId(answerCommentsDO.getId(), (byte) 2, userInfoDTO.getUsersDO().getId());
            // 指明是回答评论
            if (commentApprovalsDO != null) {
                if (commentApprovalsDO.getCommentAction() == 2) {
                    commentDTO.setUnlike(true);
                } else if (commentApprovalsDO.getCommentAction() == 1) {
                    commentDTO.setLike(true);
                }
            }

            commentDTO.setAnswerId(answerId);
            commentDTO.setReviewer(reviewer);
            commentDTO.setAnswerCommentsDO(answerCommentsDO);
            commentDTO.setUser(user);

            commentDTOList.add(commentDTO);
        }

        return new PagingListDTO<>(commentDTOList, page);
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
     * 提交回答评论
     * @param request http servlet request
     * @param answerCommentsDTO 回答评论 dto
     * @return 回答评论信息
     */
    @RequestMapping(value = "/answer-comment-reply", method = RequestMethod.POST)
    @ResponseBody
    public CommentDTO answersCommentReplay(HttpServletRequest request,
                                     @ModelAttribute AnswerCommentsDTO answerCommentsDTO) {
        return this.postAnswerCommentsFunc(request, answerCommentsDTO);
    }

    /**
     * 回答评论点赞
     * @param request http servlet request
     * @param commentDTO 评论 dto
     * @return success or not
     */
    @RequestMapping(value = "/answer-comments-like", method = RequestMethod.POST)
    @ResponseBody
    public String questionCommentsLike(HttpServletRequest request, @ModelAttribute CommentDTO commentDTO) throws JsonProcessingException {

        // 赞：1，踩：2
        int commentAction = commentDTO.getCommentAction();
        int commentId = commentDTO.getCommentId();

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Timestamp now = DateUtils.currentTime();

        // 由评论 id 查询回答评论
        AnswerCommentsDO answerCommentsDO = answerCommentsService.queryAnswerCommentById(commentId);

        // 由评论 id 和用户 id 查询是否由评论赞同内容
        CommentApprovalsDO caDO = this.commentApprovalsService
                .queryCommentApprByCommentIdAndUserId(commentId, (byte) 2, userInfoDTO.getUsersDO().getId());

        // 赞
        if (caDO == null) {
            // 评论赞同反对不存在（没攒没踩）
            // 保存评论赞同反对信息
            CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
            commentApprovalsDO.setCommentId(commentId);
            commentApprovalsDO.setCommentType((byte) 2);
            if (commentAction == 1) {
                commentApprovalsDO.setCommentAction((byte) 1);
            } else if (commentAction == 2) {
                commentApprovalsDO.setCommentAction((byte) 2);
            }
            commentApprovalsDO.setApprovalTime(now);
            commentApprovalsDO.setUserId(userInfoDTO.getUsersDO().getId());
            this.commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

            // 更新回答评论赞同反对数量
            if (commentAction == 1) {
                answerCommentsDO.setApprovalCount(1);
            } else if (commentAction == 2) {
                answerCommentsDO.setOpposeCount(1);
            }
            this.answerCommentsService.modifyAnswerComment(answerCommentsDO);
        } else {

            // 评论已投票
            if (commentAction == 1) {
                // 评论赞同存在
                if (caDO.getCommentAction() == 1) {
                    //（已赞）直接删除赞
                    this.commentApprovalsService.deleteCommentApprovals(caDO);

                    // 更新回答评论赞同数量
                    answerCommentsDO.setApprovalCount(answerCommentsDO.getApprovalCount() - 1);
                    this.answerCommentsService.modifyAnswerComment(answerCommentsDO);
                } else if (caDO.getCommentAction() == 2) {
                    // （已踩）更新动作
                    caDO.setCommentAction((byte) 1);
                    this.commentApprovalsService.modifyCommentApprovals(caDO);

                    // 更新回答评论赞同数量
                    answerCommentsDO.setOpposeCount(answerCommentsDO.getOpposeCount() - 1);
                    answerCommentsDO.setApprovalCount(answerCommentsDO.getApprovalCount() + 1);
                    this.answerCommentsService.modifyAnswerComment(answerCommentsDO);
                }
            } else if (commentAction == 2) {
                // 评论反对
                if (caDO.getCommentAction() == 1) {
                    // （已赞）更新动作
                    caDO.setCommentAction((byte) 2);
                    this.commentApprovalsService.modifyCommentApprovals(caDO);

                    // 更新回答踩数量
                    answerCommentsDO.setApprovalCount(answerCommentsDO.getApprovalCount() - 1);
                    answerCommentsDO.setOpposeCount(answerCommentsDO.getOpposeCount() + 1);
                    this.answerCommentsService.modifyAnswerComment(answerCommentsDO);
                } else if (caDO.getCommentAction() == 2) {
                    // （已踩）直接删除
                    this.commentApprovalsService.deleteCommentApprovals(caDO);

                    // 更新回答踩数量
                    answerCommentsDO.setOpposeCount(answerCommentsDO.getOpposeCount() - 1);
                    this.answerCommentsService.modifyAnswerComment(answerCommentsDO);
                }
            }
        }

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("answer comment vote success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    /**
     * 回答评论处理方法
     * @param request http servlet request
     * @param answerCommentsDTO 回答评论 dto
     * @return 评论信息
     */
    private CommentDTO postAnswerCommentsFunc(HttpServletRequest request,
                                              AnswerCommentsDTO answerCommentsDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Timestamp now = DateUtils.currentTime();

        // 保存回答评论信息
        AnswerCommentsDO answerCommentsDO = new AnswerCommentsDO();
        answerCommentsDO.setAnswerId(answerCommentsDTO.getAnswerId());
        answerCommentsDO.setReviewerId(answerCommentsDTO.getReviewerId());
        answerCommentsDO.setParentCommentId(answerCommentsDTO.getParentCommentId());
        answerCommentsDO.setCommentContent(answerCommentsDTO.getCommentContent());
        answerCommentsDO.setCommentTime(now);
        answerCommentsDO.setUserId(userInfoDTO.getUsersDO().getId());
        this.answerCommentsService.saveAnswerComment(answerCommentsDO);

        // 更新回答评论数
        AnswersDO answersDO = this.answersDAO.queryAnswersById(answerCommentsDTO.getAnswerId());
        answersDO.setCommentCount(answersDO.getCommentCount() + 1);
        this.answersDAO.updateAnswers(answersDO);

        // 查询被评论者信息
        UsersDO reviewer = usersService.queryUserByUserId(answerCommentsDTO.getReviewerId());

        // 返回信息
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setAnswerCommentsDO(answerCommentsDO);
        commentDTO.setReviewer(reviewer);
        commentDTO.setUser(userInfoDTO.getUsersDO());
        return commentDTO;
    }

    @Autowired
    public void setAnswerCommentsService(AnswerCommentsService answerCommentsService) {
        this.answerCommentsService = answerCommentsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setCommentApprovalsService(CommentApprovalsService commentApprovalsService) {
        this.commentApprovalsService = commentApprovalsService;
    }

    @Autowired
    public void setAnswersDAO(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }
}
