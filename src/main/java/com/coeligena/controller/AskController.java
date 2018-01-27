package com.coeligena.controller;

import com.coeligena.model.TopicNodesDO;
import com.coeligena.service.TopicNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *     ask controller
 * </p>
 * Created by Ellery on 2018/1/19.
 */
@Controller
public class AskController {

    private TopicNodesService topicNodesService;

    /**
     * 提问时话题自动补全
     * @param topicName 话题名称
     */
    @RequestMapping(value = "/topic-search", method = RequestMethod.GET)
    @ResponseBody
    public List<TopicNodesDO> topicAutoComplete(@RequestParam("topicName") String topicName) {

        System.out.println(topicName);
        List<TopicNodesDO> topicNodesDOList = topicNodesService.queryTopicNodesByName(topicName);

        if(topicNodesDOList != null) {
            for(TopicNodesDO tn: topicNodesDOList) {
                System.out.println(tn.getTopicName());
            }
        }

        return topicNodesDOList;
    }

    @Autowired
    public void setTopicNodesService(TopicNodesService topicNodesService) {
        this.topicNodesService = topicNodesService;
    }
}
