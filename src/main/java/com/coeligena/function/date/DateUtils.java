package com.coeligena.function.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date utils
 * Created by Ellery on 2018/8/25.
 */
public class DateUtils {

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Timestamp currentTime() {
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return Timestamp.valueOf(dateFormat);
    }

    public static long getDate() {
        return new Date().getTime();
    }
}
