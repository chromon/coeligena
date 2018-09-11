package com.coeligena.controller;

import com.coeligena.dto.CollectionDTO;
import com.coeligena.dto.CommentDTO;
import com.coeligena.dto.PagingListDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.model.CollectionFoldersDO;
import com.coeligena.service.CollectionFoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * collections controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class CollectionsController {

    private CollectionFoldersService collectionFoldersService;

    /**
     * 创建收藏夹 ajax controller
     * @param request http servlet request
     * @param collectionDTO 收藏夹数据传输对象
     * @return 创建信息
     */
    @RequestMapping(value = "/create-collection-folder", method = RequestMethod.POST)
    @ResponseBody
    public String createCollectionFolder(HttpServletRequest request,
                                         @ModelAttribute CollectionDTO collectionDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 创建收藏夹
        CollectionFoldersDO collectionFoldersDO = new CollectionFoldersDO();
        collectionFoldersDO.setFolderName(collectionDTO.getFolderName());
        collectionFoldersDO.setDescription(collectionDTO.getDescription());
        collectionFoldersDO.setForPublic(collectionDTO.getForPublic());
        collectionFoldersDO.setOwnerId(userInfoDTO.getUsersDO().getId());
        collectionFoldersService.saveCollectionFolders(collectionFoldersDO);

        return "create collection folder success.";
    }

    /**
     * 查询收藏夹列表 with ajax
     * @param request http servlet request
     * @return 收藏夹列表
     */
    @RequestMapping(value = "/collection-folders-list", method = RequestMethod.GET)
    @ResponseBody
    public List<CollectionFoldersDO> collectionFoldersList(HttpServletRequest request) {

        List<CollectionFoldersDO> collectionFoldersDOList = new ArrayList<>();

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        collectionFoldersDOList = collectionFoldersService
                .queryCollectionFoldersByOwnerId(userInfoDTO.getUsersDO().getId());

        return collectionFoldersDOList;
    }

    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public String collections() {
        return "collections";
    }

    @RequestMapping(value = "/collection/{collectionId}", method = RequestMethod.GET)
    public String collection(@PathVariable int collectionId, Model model) {
        return "collection";
    }

    @RequestMapping(value = "/collection/{collectionId}/log", method = RequestMethod.GET)
    public String collectionLog(@PathVariable int collectionId, Model model) {
        return "collectionLog";
    }

    @Autowired
    public void setCollectionFoldersService(CollectionFoldersService collectionFoldersService) {
        this.collectionFoldersService = collectionFoldersService;
    }
}
