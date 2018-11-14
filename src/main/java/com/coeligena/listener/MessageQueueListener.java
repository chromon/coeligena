package com.coeligena.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Message listener
 * Created by Ellery on 2018/11/14.
 */
public class MessageQueueListener implements MessageListener{

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message, @Nullable byte[] bytes) {
        try {
            System.out.println("channel:" + new String(message.getChannel())
                    + ",message:" + new String(message.getBody(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
