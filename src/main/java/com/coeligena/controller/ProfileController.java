package com.coeligena.controller;

import com.coeligena.dto.ProfileDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.model.RelationshipsDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.RelationshipsService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * profile controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class ProfileController {

    private UsersService usersService;
    private RelationshipsService relationshipsService;

    @RequestMapping(value = "/people/{userId}", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, @PathVariable int userId, Model model) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        ProfileDTO profileDTO = new ProfileDTO();

        // 查询个人主页信息
        UsersDO usersDO = usersService.queryUserByUserId(userId);
        profileDTO.setUsersDO(usersDO);

        // 查询关注信息
        RelationshipsDO relationshipsDO = relationshipsService.queryRelationshipsByUidAndFid(
                userInfoDTO.getUsersDO().getId(), userId);
        if (relationshipsDO != null) {
            profileDTO.setFollowed(true);
        }

        model.addAttribute("profileInfo", profileDTO);

        return "profile";
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setRelationshipsService(RelationshipsService relationshipsService) {
        this.relationshipsService = relationshipsService;
    }
}
