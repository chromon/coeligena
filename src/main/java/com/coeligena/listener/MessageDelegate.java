package com.coeligena.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * message delegate
 * Created by Ellery on 2018/11/15.
 */
public interface MessageDelegate {

    void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    // pass the channel/pattern as well
    void handleMessage(Serializable message, String channel);
}
