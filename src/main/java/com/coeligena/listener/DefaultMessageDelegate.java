package com.coeligena.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * default message delegate
 * Created by Ellery on 2018/11/15.
 */
public class DefaultMessageDelegate implements MessageDelegate {

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
}
