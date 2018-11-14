package com.coeligena.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * test message queue listener
 * Created by Ellery on 2018/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/redis-context.xml"})
@Transactional
@Rollback
public class TestMessageQueueListener {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSend() {
        redisTemplate.convertAndSend("hello-channel2", "hello world!");
    }
}
