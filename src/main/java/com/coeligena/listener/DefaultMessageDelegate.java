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
        FeedsDO feedsDO = (FeedsDO) message;
        int feedsUserId = feedsDO.getFeedsUserId();
        Set<String> followersSet = redisTemplate.opsForZSet()
                .rangeByScore("followers::" + feedsUserId, 0 , -1);
        for (String followersId: followersSet) {
            redisTemplate.opsForZSet().add("receiveFeed::" + followersId,
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
