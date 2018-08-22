package com.coeligena.function.diff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ellery on 2018/8/22.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.info("Current Time: " + System.currentTimeMillis());
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }
}
