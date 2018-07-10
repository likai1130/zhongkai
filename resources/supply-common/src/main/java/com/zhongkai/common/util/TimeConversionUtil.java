package com.zhongkai.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeConversionUtil
 * @Description: 时间转换
 * @date 2018/1/24
 * @Copyright © 2017北京数人科技有限公司
 */
public class TimeConversionUtil {
    /**
     * linux 时间戳转换成系统时间
     * @param time
     * @return
     */
    public static String unixTimeToDate(long time){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").format(new Date(time * 1000));
        return date;
    }

    /**
     * 时间转时间戳
     * @param time
     * @return
     * @throws ParseException
     */
    public static long dateToTimeStamp(String time) throws ParseException {
        long date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime();
        return date;
    }

    /**
     * 时间戳转时间
     * @param timeStamp
     * @return
     */
    public static String timeStampToDate(long timeStamp){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeStamp);
        return date;
    }
}
