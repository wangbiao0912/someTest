package com.after.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {
  /**
   * 默认时间字符串的格式
   */
  public static final String DEFAULT_FORMAT_STR = "yyyyMMddHHmmss";

  public static final String DATE_FORMAT_STR = "yyyyMMdd";

  /**
   * 获取系统时间的昨天
   * @return
   */
  public static String getSysTime(){
    Calendar ca = Calendar.getInstance();
    ca.set(Calendar.DATE, ca.get(Calendar.DATE)-1);
    Date d = ca.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String a = sdf.format(d);
    return a;
  }

  /**
   * 获取当前时间
   * @param date
   * @return
   */
  public static String getCurrentDate(String formatStr)
  {
    if (null == formatStr)
    {
      formatStr=DEFAULT_FORMAT_STR;
    }
    return date2String(new Date(), formatStr);
  }

/*  *//**
   * 返回年月日
   * @return yyyyMMdd
   *//*
  public static String getTodayChar8(String dateFormat){
    return DateFormatUtils.format(new Date(), dateFormat);
  }*/

  /**
   * 将Date日期转换为String
   * @param date
   * @param formatStr
   * @return
   */
  public static String date2String(Date date, String formatStr)
  {
    if (null == date || null == formatStr)
    {
      return "";
    }
    SimpleDateFormat df = new SimpleDateFormat(formatStr);

    return df.format(date);
  }
}
