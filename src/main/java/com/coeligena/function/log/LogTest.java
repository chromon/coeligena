package com.coeligena.function.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * test log4j and log4j2
 * Created by Ellery on 2018/8/22.
 */
public class LogTest {

//    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
    private static final Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {

        // log4j
//        logger.info("Current Time: {}", System.currentTimeMillis());
//        logger.info("Current Time: " + System.currentTimeMillis());
//        logger.info("Current Time: {}", System.currentTimeMillis());
//        logger.trace("trace log");
//        logger.warn("warn log");
//        logger.debug("debug log");
//        logger.info("info log");
//        logger.error("error log");

        // log4j2
        new Thread(() -> {
            logger.info("info{}", "aaa");
            logger.debug("debug");
            logger.error("error");
        }).start();
        new Thread(() -> {
            logger.info("info");
            logger.debug("debug");
            logger.error("error");
        }).start();
    }
}
