package com.coeligena.controller;

import com.coeligena.dto.CollectionDTO;
import com.coeligena.dto.CommentDTO;
import com.coeligena.dto.PagingListDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.info.Information;
import com.coeligena.model.CollectionFoldersDO;
import com.coeligena.model.CollectionsDO;
import com.coeligena.service.CollectionFoldersService;
import com.coeligena.service.CollectionsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private CollectionsService collectionsService;

    /**
     * 创建收藏夹 ajax controller
     * @param request http servlet request
     * @param collectionDTO 收藏夹数据传输对象
     * @return 创建信息
     */
    @RequestMapping(value = "/create-collection-folder", method = RequestMethod.POST)
    @ResponseBody
    public CollectionFoldersDO createCollectionFolder(HttpServletRequest request,
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

        return collectionFoldersDO;
    }

    /**
     * 查询收藏夹列表 with ajax
     * @param request http servlet request
     * @return 收藏夹列表
     */
    @RequestMapping(value = "/collection-folders-list", method = RequestMethod.POST)
    @ResponseBody
    public List<CollectionDTO> collectionFoldersList(HttpServletRequest request,
                                                           @ModelAttribute CollectionDTO collectionDTO) {
        List<CollectionDTO> collectionDTOList = new ArrayList<>();

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 收藏夹列表
        List<CollectionFoldersDO> collectionFoldersDOList = collectionFoldersService
                .queryCollectionFoldersByOwnerId(userInfoDTO.getUsersDO().getId());
        for (CollectionFoldersDO cfd: collectionFoldersDOList) {
            // 查询当前回答是否已被收藏夹收藏
            CollectionsDO collectionsDO = collectionsService.queryCollectionByAnswerIdAndFolderId(
                    collectionDTO.getAnswerId(), cfd.getId());
            CollectionDTO cdto = new CollectionDTO();
            cdto.setCollectionFoldersDO(cfd);
            if (collectionsDO != null) {
                cdto.setCollected(true);
            }
            collectionDTOList.add(cdto);
        }

        return collectionDTOList;
    }

    /**
     * 收藏回答到收藏夹 ajax
     * @param request http servlet request
     * @param collectionDTO collection dto
     * @return success info
     */
    @RequestMapping(value = "/add-to-collection-folders", method = RequestMethod.POST)
    @ResponseBody
    public String addToCollectionFolder(HttpServletRequest request,
                                        @ModelAttribute CollectionDTO collectionDTO) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 创建收藏信息
        CollectionsDO collectionsDO = new CollectionsDO();
        collectionsDO.setAnswerId(collectionDTO.getAnswerId());
        collectionsDO.setCollectionFolderId(collectionDTO.getFolderId());
        collectionsDO.setOwnerId(userInfoDTO.getUsersDO().getId());
        collectionsService.saveCollections(collectionsDO);

        // 更新收藏夹回答数量
        CollectionFoldersDO collectionFoldersDO = this.collectionFoldersService
                .queryCollectionFolderById(collectionDTO.getFolderId());
        collectionFoldersDO.setAnswersCount(collectionFoldersDO.getAnswersCount() + 1);
        this.collectionFoldersService.modifyCollectionFolders(collectionFoldersDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("success add to collection folders");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
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

    @Autowired
    public void setCollectionsService(CollectionsService collectionsService) {
        this.collectionsService = collectionsService;
    }
}
