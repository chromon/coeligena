package com.coeligena.listener;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.FeedsDO;
import org.springframework.data.redis.core.RedisTemplate;
import sun.util.resources.cldr.eu.CalendarData_eu_ES;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * default message delegate
 * Created by Ellery on 2018/11/15.
 */
public class DefaultMessageDelegate implements MessageDelegate {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void handleMessage(String message) {
        System.out.println("---- handle message 1: ----");
        System.out.println(message);
    }

    @Override
    public void handleMessage(Map message) {
        System.out.println("---- handle message 2: ----");
        System.out.println(message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println("---- handle message 3: ----");
        System.out.println(new String(message));
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.out.println("---- handle message 4: ----");
        System.out.println(message + " --> " + channel);
    }

    /**
     * 动态发布处理队列
     * @param message 消息
     * @param channel 频道
     */
    @Override
    @SuppressWarnings("unchecked")
    public void feedHandleMessage(Serializable message, String channel) {

        // System.out.println(message + " --> " + channel);

        FeedsDO feedsDO = (FeedsDO) message;
        // 动态发布者 id，
        int feedsUserId = feedsDO.getFeedsUserId();
        // 动态发布者粉丝集合
        Set<String> followersSet = redisTemplate.opsForZSet()
                .range("user:" + feedsUserId + "::followers", 0 , -1);

        // 遍历粉丝集合，向每个粉丝的接收 feed 有续集添加动态信息
        // TODO 后序可扩展有选择性的发送
        for (String followersId: followersSet) {
            redisTemplate.opsForZSet().add("user:" + followersId + "::receiveFeed",
                    feedsDO, DateUtils.getDate());
        }
    }

    /**
     * 关注取关处理队列
     * @param message 消息
     * @param channel 频道
     */
    @Override
    public void followHandleMessage(Serializable message, String channel) {
        System.out.println(message + " --> " + channel);
    }
}
