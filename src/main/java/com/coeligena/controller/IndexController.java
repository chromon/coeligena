package com.coeligena.controller;

import com.coeligena.dto.FeedsDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.FeedsDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.FeedsService;
import com.coeligena.service.QuestionsService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * index controller
 *
 * Created by Ellery on 2017/8/10.
 */

@Controller
public class IndexController {

    private FeedsService feedsService;
    private QuestionsService questionsService;
    private UsersService usersService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 首页内容
     * @param model model
     * @return 首页
     */
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {


        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        List<FeedsDO> feedsList = feedsService.queryAllFeeds();
        List<FeedsDTO> feedsDTOList = new ArrayList<>();

//        if (feedsList != null) {
//            for (FeedsDO feedsDO: feedsList) {
//
//                /*
//                    feeds_id  动态类型所对应的ID, 如关注和提出问题对应的是问题ID，赞同回答和回答问题对应的是回答ID
//                    feeds_type 动态类型 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题
//                    parent_feeds_id 父动态类型所对应的ID，赞同回答和回答问题对应的是问题ID
//                    parent_feeds_type 父动态类型 1：赞同该回答——对应问题，2：回答了该问题——对应问题
//                 */
//
//                // 提出问题
//                if (feedsDO.getFeedsType() == 4) {
//                    // 所提问题信息
//                    QuestionsDO questionsDO = questionsService.queryQuestionById(feedsDO.getFeedsId());
//                    // 提问用户信息
//                    UsersDO usersDO = usersService.queryUserByUserId(feedsDO.getFeedsUserId());
//
//                    FeedsDTO feedsDTO = new FeedsDTO();
//                    feedsDTO.setFeedsDO(feedsDO);
//                    feedsDTO.setQuestionsDO(questionsDO);
//                    feedsDTO.setUsersDO(usersDO);
//
//                    feedsDTOList.add(feedsDTO);
//                }
//            }
//        }
//
//        model.addAttribute("feedsDTOList", feedsDTOList);


        // 初始化分页信息
        int count = redisTemplate.opsForZSet().size("user:" + userInfoDTO.getUsersDO().getId() + "::receiveFeed").intValue();
        if (count > 0) {
            Page page = new Page(1, 2);
            page.setSize(count);
            page.setNavigatePages(3);
            page.init();

            // 由用户接收 feed 有续集查询动态
            Set<TypedTuple<Object>> feedsSet = redisTemplate.opsForZSet()
                    .reverseRangeWithScores("user:" + userInfoDTO.getUsersDO().getId() + "::receiveFeed",
                            page.getStartPos(), page.getEndPos());
            for (TypedTuple<Object> tuple : feedsSet) {
                FeedsDO feedsDO = (FeedsDO) tuple.getValue();
                // 提出/关注问题
                if (feedsDO.getFeedsType() == 4 || feedsDO.getFeedsType() == 1) {
                    // 所提问题/关注问题信息
                    QuestionsDO questionsDO = questionsService.queryQuestionById(feedsDO.getFeedsId());
                    // 提问用户/关注问题用户信息
                    UsersDO usersDO = usersService.queryUserByUserId(feedsDO.getFeedsUserId());

                    FeedsDTO feedsDTO = new FeedsDTO();
                    feedsDTO.setFeedsDO(feedsDO);
                    feedsDTO.setQuestionsDO(questionsDO);
                    feedsDTO.setUsersDO(usersDO);

                    feedsDTOList.add(feedsDTO);
                }
            }
        }

        model.addAttribute("feedsDTOList", feedsDTOList);

		return "../../index";
	}

	@Autowired
    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
