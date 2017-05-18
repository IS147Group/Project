package com.company;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class gameTime {

	public static long setCurrentTime(){
		return System.currentTimeMillis();
	}
	public static void totalTime(long end, long start){
        NumberFormat formatter = new DecimalFormat("#0.00");
        double gametime = Math.pow(Math.sqrt(end-start),2);
        System.out.println("Total game time: "+ (formatter.format((gametime)/1000d))+" seconds");
	}
	public static void getCurrentTime(long currentTime){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(currentTime);
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
	}
}
