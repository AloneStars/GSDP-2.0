package com.gsdp.util;

import java.util.Calendar;

public class DateUtil {
	
	static String[] MONTH={"January","February","March","April","May","June","July","August","September","October","November","December"};
	static String[] WEEK={"Sunday","Monday","Thesday","Wednesday","Thursday","Friday","Saturday"};
	
	public static String getDataString(){
				
		 Calendar cal = Calendar.getInstance();
		 
	     int year = cal.get(Calendar.YEAR);//获取年份
	     int month=cal.get(Calendar.MONTH);//获取月份
	     int day=cal.get(Calendar.DATE);//获取日
	    /* int minute=cal.get(Calendar.MINUTE);//分
	     int second=cal.get(Calendar.SECOND);//秒
	     int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天*/
	     
	     return year+"-"+(month+1)+"-"+day;
		
		 //return MONTH[month]+" "+day+", "+year; //返回 January 24,2015
		
	}
	

	public static void main(String[] args) {
		
		System.out.println(getDataString());
		
    }
}
