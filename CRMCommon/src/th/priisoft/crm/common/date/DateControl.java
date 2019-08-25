package th.priisoft.crm.common.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import th.priisoft.crm.common.constant.Constants;



public class DateControl {
	private static final int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	public static final int DAYS_OF_MONTH = 1000 * 60 * 60 * 24;

	static {
		Locale.setDefault(Locale.US);
	}
	public static String millisecondToStringDate(long date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern, Constants.Date.EN_LOCALE);
		Date dd = new Date(date);
		return format.format(dd);
	}
	public static Date stringToDate(String date, String pattern) throws ParseException {
		if(date.length() != pattern.length()) {
			throw new ParseException("the date length and pattern length are not equal.",0);
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern, Constants.Date.EN_LOCALE);
		format.setLenient(false);
		return format.parse(date);
	}
	
	public static Date stringToDateyyyyMMdd(String date) throws ParseException {
		return stringToDate(date, Constants.Date.TIME_PATTERN_yyyy_MM_dd);
	}
	
	public static int stringToIntDate(String date, String pattern) throws ParseException {
		return Integer.parseInt(dateToString(stringToDate(date, pattern), Constants.Date.DATE_PATTERN_yyyyMMdd));
	}

	public static Date[] getMonthEndDate(java.util.Date date) {
		GregorianCalendar cl = new GregorianCalendar();
		cl.setTime(date);
		int month = cl.get(Calendar.MONTH);
		int year = cl.get(Calendar.YEAR);

		cl.roll(Calendar.MONTH, false);
		int monthRollDown = cl.get(Calendar.MONTH) + 1;
		if (month + 1 == 1) {
			year = year - 1;
		}
		GregorianCalendar clRoll = new GregorianCalendar();
		clRoll.set(year, monthRollDown, 1);
		int monthEnd = clRoll.getActualMaximum(Calendar.DAY_OF_MONTH);
		GregorianCalendar clMonthEnd = new GregorianCalendar();
		clMonthEnd.set(year, monthRollDown, monthEnd);
		Date[] dteParam = { clRoll.getTime(), clMonthEnd.getTime() };
		return dteParam;
	}

	
	public static Timestamp stringTotimestamp(String strDate, String inPattern) {
		Timestamp tms = null;
		if (strDate != null && strDate.trim().length() > 0) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(inPattern,Constants.Date.EN_LOCALE);
				tms = new Timestamp(formatter.parse(strDate).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return tms;
	}
	
	public static Timestamp stringToTimestampTH(String strDate, String inPattern) {
		Timestamp tms = null;
		if (strDate != null && strDate.trim().length() > 0) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(inPattern,Constants.Date.TH_LOCALE);
				tms = new Timestamp(formatter.parse(strDate).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return tms;
	}

	
	public static String timestampToString(java.sql.Timestamp indate, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				Constants.Date.EN_LOCALE);
		if (indate == null) {
			return null;
		} else {
			return formatter.format(indate);
		}
	}

	public static String toDayTimeString() {
		return toDayTimeString(Constants.Date.TIME_PATTERN_HHMMSS);
	}

	
	public static Timestamp toDaytoTimeStamp() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  00:00:00",
				Constants.Date.EN_LOCALE);
		java.util.Date datetoday = new java.util.Date();
		java.util.Date date = new java.util.Date(dateFormat.parse(
				dateFormat.format(datetoday.getTime())).getTime());
		dateFormat.format(date);
		Timestamp timeToday = new Timestamp(date.getTime());
		return timeToday;
	}

	
	public static Date intToDate(int inDate, String inPattern) {
		String dateString = String.valueOf(inDate);
		Date date = null;
		try {
			if (dateString != null) {
				date = stringToDate(dateString, inPattern);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String intDateToString(int inDate, String inPattern) {
		String dateStr = null;
		try {
			Date date = stringToDate(String.valueOf(inDate), Constants.Date.DATE_PATTERN_yyyyMMdd);
			dateStr = dateToString(date,inPattern);
		} catch(Exception e) {	e.printStackTrace();	}
		return dateStr;
	}
	
	public static String intDateToString(int inDate) {
		String dateStr = null;
		try {
			Date date = stringToDate(String.valueOf(inDate), Constants.Date.DATE_PATTERN_yyyyMMdd);
			dateStr = dateToString(date,Constants.Date.DATE_PATTERN_ddMMyyyy);
		} catch(Exception e) {	e.printStackTrace();	}
		return dateStr;
	}
	
	public static Calendar monthYear(String yyyymm) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, Integer.parseInt(yyyymm.substring(0, 4)));
		calendar.set(Calendar.YEAR, Integer.parseInt(yyyymm.substring(4, 2)));
		return calendar;
	}
	
	///---	TODO Thai	---//
	public static String intDateToStringThai(int inDate, String inPattern) {
		String dateStr = "";
		try {
			Date date = stringToDate(String.valueOf(inDate), Constants.Date.DATE_PATTERN_yyyyMMdd);
			dateStr = dateToStringThai(date);
		} catch(Exception e) {	e.printStackTrace();	}
		return dateStr;
	}
	public static String dateToStringThaiDDMMYYYY(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date); 
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		return String.format("%s/%s/%s", String.format("%1$2s", day).replace(' ', '0'),String.format("%1$2s", month+1).replace(' ', '0'),year+543);
	}
	
	public static String dateToStringThai(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date); 
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		return String.format("%d %s %d", day,monthThai(month+1),year+543);
	}
	
	public static String monthThai(int month) {
		String thai = "";
		switch (month) {
		case 1:		thai = "มกราคม";	break;
		case 2:		thai = "กุมภาพันธ์";	break;
		case 3:		thai = "มีนาคม";	break;
		case 4:		thai = "เมษายน";	break;
		case 5:		thai = "พฤษภาคม";	break;
		case 6:		thai = "มิถุนายน";	break;
		case 7:		thai = "กรกฎาคม";	break;
		case 8:		thai = "สิงหาคม";	break;
		case 9:		thai = "กันยายน";	break;
		case 10:	thai = "ตุลาคม";	break;
		case 11:	thai = "พฤศจิกายน";	break;
		case 12:	thai = "ธันวาคม";	break;
		default:	break;
		}
		return thai;
	}
	
	public static String intTimeToString(int inDate) {
		String timeFormat = String.format("%06d", inDate);
		return String.format("%s:%s", timeFormat.substring(0, 2), timeFormat.substring(2, 4));
	}
	public static String toDayTimeString(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Constants.Date.EN_LOCALE);
		Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
		return formatter.format(time);
	}

	public static java.sql.Date today() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static java.sql.Date getPreviousDate(java.sql.Date thisDay, int day)
			throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(
				Constants.Date.DATE_PATTERN_ddMMyyyy, Constants.Date.EN_LOCALE);
		Calendar c = Calendar.getInstance();
		c.setTime(thisDay);
		c.add(Calendar.DATE, -day);
		java.sql.Date date = new java.sql.Date(formatter.parse(
				formatter.format(c.getTime())).getTime());
		return date;
	}

	public static Date getNextDate(Date thisDay) {
		return new Date(thisDay.getTime() + MILLIS_IN_DAY);
	}

	
	public static int getDiffDate(float calendarItem, Date d1, Date d2) {
		int x = 1000;
		if (calendarItem == Calendar.DAY_OF_MONTH) {
			x = x * 60 * 60 * 24;
		} else if (calendarItem == Calendar.HOUR_OF_DAY) {
			x = x * 60 * 60;
		} else if (calendarItem == Calendar.MINUTE) {
			x = x * 60;
		} else if (calendarItem == Calendar.SECOND) {
			x = 1000;
		} else
			return 1;
		return (int) ((d2.getTime() - d1.getTime()) / (x));
	}
	
	public static String getDiffHHmm(long diffTime) {
		diffTime = diffTime / (1000 * 60);
		return String.format("%02d", diffTime / 60) +":"+ String.format("%02d", diffTime % 60);
	}

	public static int getDiffDateExclWeekend(Date d1, Date d2) {

		int remdays = getDiffDate(Calendar.DAY_OF_MONTH, d1, d2); // actual
																	// number of
																	// remaining
																	// days,
																	// including
																	// weekends
		int numweekends = 2 * (remdays / 7); // get number of weekends
												// encompassed that overlapped

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);

		int remweekends = remdays % 7 + cal.get(Calendar.DAY_OF_WEEK);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) { // if current
																	// day is
																	// Saturday,
																	// need to
																	// re-calibrate
																	// as Friday
			numweekends--;
		} else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) { // if
																		// current
																		// day
																		// is
																		// Sunday,
																		// need
																		// to
																		// re-calibrate
																		// as
																		// Monday
			numweekends++;
		}

		if (remweekends == 7) { // Saturday in future
			numweekends++;
		} else if (remweekends > 7) { // in future
			numweekends += 2;
		} else if (remweekends == 1) { // Sunday in past
			numweekends--;
		} else if (remweekends < 1) { // in past
			numweekends -= 2;
		}

		// System.out.println(d1 + " - " + d2);
		// System.out.println("remdays=" + remdays + ",numweekends=" +
		// numweekends);
		// System.out.println("remweekends=" + remweekends + ",dayofweek=" +
		// cal.get(Calendar.DAY_OF_WEEK));

		return remdays - numweekends;
	}

	public static long systemTimeToLong() {
		String timeStr = "";
		String hoursStr = addString(new Integer(java.util.Calendar
				.getInstance().get(java.util.Calendar.HOUR_OF_DAY)).toString(),
				"0", 2, false);
		String minutesStr = addString(new Integer(java.util.Calendar
				.getInstance().get(java.util.Calendar.MINUTE)).toString(), "0",
				2, false);
		String secondsStr = addString(new Integer(java.util.Calendar
				.getInstance().get(java.util.Calendar.SECOND)).toString(), "0",
				2, false);
		timeStr = hoursStr.trim() + minutesStr.trim() + secondsStr.trim();
		return Long.valueOf(timeStr).longValue();
	}

	public static String addString(String word, String str, int num,
			boolean rightText) {

		StringBuffer stb = new StringBuffer(num);
		int len = (word == null) ? 0 : word.length();
		int sp = num - len;
		word = (word == null) ? "" : word;
		str = (str == null) ? " " : str;
		if (sp > 0) {
			stb.append(word);
			if (!rightText)
				stb.reverse();
			for (int i = 0; i < sp; i++)
				stb.append(str);
			if (!rightText)
				stb.reverse();
		} else {
			if (rightText)
				stb.append(word.substring(0, num));
			else
				stb.append(word.substring(len - num));
		}
		return stb.toString();
	}

	public static Date yesterday(long numberDate) {
		long x = 1000;
		numberDate = x * 60 * 60 * 24 * numberDate;
		Date yesterday = new Date(today().getTime() - numberDate);
		return yesterday;
	}

	public static Date tomorrow(long numberDate) {
		long x = 1000;
		numberDate = x * 60 * 60 * 24 * numberDate;
		Date yesterday = new Date(today().getTime() + numberDate);
		return yesterday;
	}
	
	public static Date clearTimeOfDate(Date inDate) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static String dateToString(Date indate, String pattern) { 
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Constants.Date.EN_LOCALE);
		if (indate == null) {
			return null;
		} else {
			return formatter.format(indate);
		}
	}
	
	public static String changeFormatDate(String date, String inPattern,String outPatern) throws Exception {
		Date tmpDate = stringToDate(date,inPattern);
		return dateToString(tmpDate, outPatern);
	}
}