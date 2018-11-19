package com.coeligena.controller;

import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.RelationshipsDO;
import com.coeligena.service.RelationshipsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * relationships controller
 * Created by Ellery on 2018/11/16.
 */
@Controller
public class RelationshipsController {

    @Resource
    private RedisTemplate redisTemplate;

    private RelationshipsService relationshipsService;

    /**
     * 关注/取关用户
     * @param request http servlet request
     * @param followId 被关注者 id
     * @param followAction 关注动作
     * @return 处理信息
     * @throws JsonProcessingException json format
     */
    @RequestMapping(value="/follow-user", method= RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public String followUser(HttpServletRequest request, int followId,
                             int followAction) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 返回消息
        Information info = new Information();

        if (followAction == 1) {
            // 关注

            // redis
            long time = DateUtils.getDate();
            redisTemplate.opsForZSet().add("following::" + userInfoDTO.getUsersDO().getId(),
                    String.valueOf(followId), time);
            redisTemplate.opsForZSet().add("followers::" + followId,
                    String.valueOf(userInfoDTO.getUsersDO().getId()), time);

            // db
            RelationshipsDO relationshipsDO = new RelationshipsDO();
            relationshipsDO.setUserId(userInfoDTO.getUsersDO().getId());
            relationshipsDO.setFollowedId(followId);
            relationshipsService.saveRelationships(relationshipsDO);
            info.setInfoType("success");
            info.setInfoContent("follow success.");
        } else {
            // 取关

            // redis
            redisTemplate.opsForZSet().remove("following::"+ userInfoDTO.getUsersDO().getId(),
                    String.valueOf(followId));
            redisTemplate.opsForZSet().remove("followers::" + followId,
                    String.valueOf(userInfoDTO.getUsersDO().getId()));

            // db
            RelationshipsDO relationshipsDO = relationshipsService.queryRelationshipsByUidAndFid(
                    userInfoDTO.getUsersDO().getId(), followId);
            if (relationshipsDO != null) {
                relationshipsService.deleteRelationships(relationshipsDO);
            }
            info.setInfoType("success");
            info.setInfoContent("cancel follow success.");
        }

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @Autowired
    public void setRelationshipsService(RelationshipsService relationshipsService) {
        this.relationshipsService = relationshipsService;
    }
}
