package com.soebes.tools.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDelta {

    public static Date parseDate(String dateStr) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	Date result = null;

	try {
	    result = sdf.parse(dateStr);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return result;
    }

    public Long deltaInMilliSeconds(String startDate) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	return deltaInMilliSeconds(startDate, sdf.format(new Date()));
    }

    public Long deltaInMilliSeconds(Date startDate) {
	return deltaInMilliSeconds(startDate, new Date());
    }

    /**
     * The Magic happens here ;-)
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public Long deltaInMilliSeconds(String startDate, String endDate) {
	return deltaInMilliSeconds(parseDate(startDate), parseDate(endDate));
    }

    /**
     * @param startDate The date were we start from
     * @param endDate The end date.
     * @return The delta in milli seconds.
     */
    public Long deltaInMilliSeconds(Date startDate, Date endDate) {

	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();

	cal1.setTime(startDate);
	cal2.setTime(endDate);

	long milis1 = cal1.getTimeInMillis();
	long milis2 = cal2.getTimeInMillis();

	long diff = milis2 - milis1;

	return new Long(diff);
    }

    public Long deltaInSeconds(String startDate, String endDate) {
	long diff = deltaInMilliSeconds(startDate, endDate);
	return diff / 1000;
    }
}
