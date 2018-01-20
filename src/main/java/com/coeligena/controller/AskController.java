package com.coeligena.controller;

import com.coeligena.model.TopicNodesDO;
import com.coeligena.service.TopicNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/topic-search/{topicName}", method = RequestMethod.GET)
    public void topicAutoComplete(@PathVariable("topicName") String topicName) {

        System.out.println(topicName);
        List<TopicNodesDO> topicNodesDOList = topicNodesService.queryTopicNodesByName(topicName);

        if(topicNodesDOList != null) {
            for(TopicNodesDO tn: topicNodesDOList) {
                System.out.println(tn.getTopicName());
            }
        }

    }

    @Autowired
    public void setTopicNodesService(TopicNodesService topicNodesService) {
        this.topicNodesService = topicNodesService;
    }
}
