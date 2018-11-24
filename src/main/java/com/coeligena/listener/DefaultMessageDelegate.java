package com.coeligena.listener;

import com.coeligena.dto.FollowDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.model.FeedsDO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import javax.annotation.Resource;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
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
    @SuppressWarnings("unchecked")
    public void followHandleMessage(Serializable message, String channel) {
        // System.out.println(message + " --> " + channel);

        FollowDTO followDTO = (FollowDTO) message;
        if (followDTO.getFollowAction() == 0) {
            // 取关
            // 遍历用户自己的接收 Feed，剔除其中已取关 ID 的动态记录
            Set<Object> feedsDOSet = redisTemplate.opsForZSet().range("user:" + followDTO.getUserId() + "::receiveFeed", 0, -1);
            for (Object obj: feedsDOSet) {
                FeedsDO feedsDO = (FeedsDO) obj;
                if (feedsDO.getFeedsUserId() == followDTO.getFollowedId()) {
                    redisTemplate.opsForZSet().remove(
                            "user:" + followDTO.getUserId() + "::receiveFeed", feedsDO);
                }
            }
        } else if (followDTO.getFollowAction() == 1) {
            // 关注
            // 拉取被关注者的发送 Feed 有序集中的动态，将最近的动态写入用户自己的接收 Feed 中
            // TODO 写入的动态可以扩展为：按照 score 由高到低排序，取前段一定数量
            Set<TypedTuple<Object>> feedsDOSet = redisTemplate.opsForZSet()
                    .reverseRangeWithScores("user:" + followDTO.getFollowedId() + "::sendFeed", 0, -1);
            for (TypedTuple<Object> tuple: feedsDOSet) {
                redisTemplate.opsForZSet().add("user:" + followDTO.getUserId() + "::receiveFeed",
                        tuple.getValue(), tuple.getScore());
            }
        }
    }
}
