package com.coeligena.function.log;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

/**
 * overwrite lookup
 * Created by Ellery on 2018/8/25.
 */
@Plugin(name = "thread", category = StrLookup.CATEGORY)
public class ThreadLookup implements StrLookup {
    @Override
    public String lookup(String s) {
        return Thread.currentThread().getName();
    }

    @Override
    public String lookup(LogEvent logEvent, String s) {
        return logEvent.getThreadName() == null ? Thread.currentThread().getName()
                : logEvent.getThreadName();
    }
}
