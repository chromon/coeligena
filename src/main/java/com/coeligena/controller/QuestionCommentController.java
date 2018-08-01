package com.coeligena.controller;

import com.coeligena.dto.CommentDTO;
import com.coeligena.dto.PagingListDTO;
import com.coeligena.dto.QuestionCommentDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.CommentApprovalsDO;
import com.coeligena.model.QuestionCommentsDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.CommentApprovalsService;
import com.coeligena.service.QuestionCommentService;
import com.coeligena.service.QuestionsService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * question comments controller
 * Created by Ellery on 2018/7/12.
 */
@Controller
public class QuestionCommentController {

    private UsersService usersService;
    private QuestionsService questionsService;
    private QuestionCommentService questionCommentService;
    private CommentApprovalsService commentApprovalsService;

    /**
     * 提交问题评论 ajax 请求
     * @param request httpservletrequest
     * @param questionCommentDTO 问题评论信息
     * @return 问题评论相关信息 dto
     */
    @RequestMapping(value = "/question-comment", method = RequestMethod.POST)
    @ResponseBody
    public CommentDTO questionComment(HttpServletRequest request,
                                      @ModelAttribute QuestionCommentDTO questionCommentDTO) {
        return this.postQuestionCommentFunc(request, questionCommentDTO);
    }

    /**
     * 查询问题评论列表
     * @return 问题评论列表
     */
    @RequestMapping(value = "/question-comment-list", method = RequestMethod.GET)
    @ResponseBody
    public PagingListDTO<CommentDTO> questionCommentList(HttpServletRequest request) {
        return questionCommentsPagingList(request, 1);
    }

    /**
     * 问题评论回复
     * @param request httpservletrequest
     * @param questionCommentDTO 问题评论信息
     * @return 问题评论相关信息
     */
    @RequestMapping(value = "/question-comment-reply", method = RequestMethod.POST)
    @ResponseBody
    public CommentDTO questionCommentReply(HttpServletRequest request,
                                           @ModelAttribute QuestionCommentDTO questionCommentDTO) {
        return this.postQuestionCommentFunc(request, questionCommentDTO);
    }

    /**
     * 问题评论分页请求
     * @param pageNum 页数
     * @return 问题评论列表
     */
    @RequestMapping(value = "/question-comments-with-page", method = RequestMethod.GET)
    @ResponseBody
    public PagingListDTO<CommentDTO> questionCommentsWithPage(HttpServletRequest request,
                                                              @RequestParam("pageNum") int pageNum) {
        return questionCommentsPagingList(request, pageNum);
    }

    /**
     * 问题评论点赞
     * @param commentDTO 评论 dto
     * @return success or not
     */
    @RequestMapping(value = "/question-comments-like", method = RequestMethod.POST)
    @ResponseBody
    public String questionCommentsLike(HttpServletRequest request, @ModelAttribute CommentDTO commentDTO) {

        // 赞：1，踩：2
        int commentAction = commentDTO.getCommentAction();
        int commentId = commentDTO.getCommentId();

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 查询问题评论
        QuestionCommentsDO questionCommentsDO = this.questionCommentService.queryQuestionCommentById(commentId);

        // 由评论 id 和用户 id 查询是否由评论赞同内容
        CommentApprovalsDO caDO = this.commentApprovalsService
                .queryCommentApprByCommentIdAndUserId(commentId, userInfoDTO.getUsersDO().getId());

        // 赞
        if (caDO == null) {
            // 评论赞同反对不存在（没攒没踩）
            // 保存评论赞同反对信息
            CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
            commentApprovalsDO.setCommentId(commentId);
            commentApprovalsDO.setCommentType((byte) 1);
            if (commentAction == 1) {
                commentApprovalsDO.setCommentAction((byte) 1);
            } else if (commentAction == 2) {
                commentApprovalsDO.setCommentAction((byte) 2);
            }
            commentApprovalsDO.setApprovalTime(now);
            commentApprovalsDO.setUserId(userInfoDTO.getUsersDO().getId());
            this.commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

            // 更新问题评论赞同反对数量
            if (commentAction == 1) {
                questionCommentsDO.setApprovalCount(1);
            } else if (commentAction == 2) {
                questionCommentsDO.setOpposeCount(1);
            }
            this.questionCommentService.modifyQuestionComments(questionCommentsDO);
        } else {
            // 评论已投票
            if (commentAction == 1) {
                // 评论赞同存在
                if (caDO.getCommentAction() == 1) {
                    //（已赞）直接删除赞
                    this.commentApprovalsService.deleteCommentApprovals(caDO);

                    // 更新问题评论赞同数量
                    questionCommentsDO.setApprovalCount(questionCommentsDO.getApprovalCount() - 1);
                    this.questionCommentService.modifyQuestionComments(questionCommentsDO);
                } else if (caDO.getCommentAction() == 2) {
                    // （已踩）更新动作
                    caDO.setCommentAction((byte) 1);
                    this.commentApprovalsService.modifyCommentApprovals(caDO);

                    // 更新问题评论赞同数量
                    questionCommentsDO.setOpposeCount(questionCommentsDO.getOpposeCount() - 1);
                    questionCommentsDO.setApprovalCount(questionCommentsDO.getApprovalCount() + 1);
                    this.questionCommentService.modifyQuestionComments(questionCommentsDO);
                }
            } else if (commentAction == 2) {
                // 评论反对
                if (caDO.getCommentAction() == 1) {
                    // （已赞）更新动作
                    caDO.setCommentAction((byte) 2);
                    this.commentApprovalsService.modifyCommentApprovals(caDO);

                    // 更新问题踩数量
                    questionCommentsDO.setApprovalCount(questionCommentsDO.getApprovalCount() - 1);
                    questionCommentsDO.setOpposeCount(questionCommentsDO.getOpposeCount() + 1);
                    this.questionCommentService.modifyQuestionComments(questionCommentsDO);
                } else if (caDO.getCommentAction() == 2) {
                    // （已踩）直接删除
                    this.commentApprovalsService.deleteCommentApprovals(caDO);

                    // 更新问题踩数量
                    questionCommentsDO.setOpposeCount(questionCommentsDO.getOpposeCount() - 1);
                    this.questionCommentService.modifyQuestionComments(questionCommentsDO);
                }
            }
        }

        return "question comment vote success.";
    }

    /**
     * 问题评论处理方法
     * @param request httpservletrequest
     * @param questionCommentDTO 问题评论信息
     * @return 问题评论相关信息
     */
    private CommentDTO postQuestionCommentFunc(HttpServletRequest request,
                                               QuestionCommentDTO questionCommentDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 保存问题评论信息
        QuestionCommentsDO questionCommentsDO = new QuestionCommentsDO();
        questionCommentsDO.setQuestionId(questionCommentDTO.getQuestionId());
        questionCommentsDO.setReviewerId(questionCommentDTO.getReviewerId());
        questionCommentsDO.setParentCommentId(questionCommentDTO.getParentCommentId());
        questionCommentsDO.setCommentContent(questionCommentDTO.getCommentContent());
        questionCommentsDO.setCommentTime(now);
        questionCommentsDO.setUserId(userInfoDTO.getUsersDO().getId());
        questionCommentService.saveQuestionComment(questionCommentsDO);

        // 更新问题评论数
        QuestionsDO questionsDO = questionsService.queryQuestionById(questionCommentDTO.getQuestionId());
        questionsDO.setCommentCount(questionsDO.getCommentCount() + 1);
        questionsService.modifyQuestion(questionsDO);

        // 查询被评论者信息
        UsersDO reviewer = usersService.queryUserByUserId(questionCommentDTO.getReviewerId());

        // 返回信息
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setQuestionId(questionCommentDTO.getQuestionId());
        commentDTO.setQuestionCommentsDO(questionCommentsDO);
        commentDTO.setReviewer(reviewer);
        commentDTO.setUser(userInfoDTO.getUsersDO());

        return commentDTO;
    }

    /**
     * 分页查询问题评论
     * @param pageNum 页码
     * @return 问题评论列表
     */
    private PagingListDTO<CommentDTO> questionCommentsPagingList(HttpServletRequest request, int pageNum) {

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        List<CommentDTO> commentDTOList = new ArrayList<>();

        // 查询全部评论
        int count = this.questionCommentService.queryQuestionCommentsCount();

        Page page = new Page(pageNum, 2);
        page.setSize(count);
        page.setNavigatePages(3);
        page.init();

        List<QuestionCommentsDO> questionCommentsDOList = this.questionCommentService.queryQuestionComments(page);
        for (QuestionCommentsDO questionCommentsDO: questionCommentsDOList) {

            CommentDTO commentDTO = new CommentDTO();

            // 查询被评论用户信息
            UsersDO reviewer = null;
            if (questionCommentsDO.getReviewerId() != 0) {
                reviewer = this.usersService.queryUserByUserId(questionCommentsDO.getReviewerId());
            }

            // 查询评论用户信息
            UsersDO user = this.usersService.queryUserByUserId(questionCommentsDO.getUserId());

            // 查询是否赞踩
            CommentApprovalsDO commentApprovalsDO = this.commentApprovalsService
                    .queryCommentApprByCommentIdAndUserId(questionCommentsDO.getId(), userInfoDTO.getUsersDO().getId());
            if (commentApprovalsDO != null) {
                if (commentApprovalsDO.getCommentAction() == 1) {
                    commentDTO.setLike(true);
                } else if (commentApprovalsDO.getCommentAction() == 2) {
                    commentDTO.setUnlike(true);
                }
            }

            commentDTO.setReviewer(reviewer);
            commentDTO.setQuestionCommentsDO(questionCommentsDO);
            commentDTO.setUser(user);

            commentDTOList.add(commentDTO);
        }

        return new PagingListDTO<>(commentDTOList, page);
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Autowired
    public void setQuestionCommentService(QuestionCommentService questionCommentService) {
        this.questionCommentService = questionCommentService;
    }

    @Autowired
    public void setCommentApprovalsService(CommentApprovalsService commentApprovalsService) {
        this.commentApprovalsService = commentApprovalsService;
    }
}
