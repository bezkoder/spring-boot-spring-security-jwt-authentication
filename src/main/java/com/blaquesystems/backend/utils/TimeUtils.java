package com.blaquesystems.backend.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Fredrick Oluoch
 * http://www.blaqueyard.com
 * 0720106420 | 0722508906
 * email: menty44@gmail.com
 */


public class TimeUtils {
    public static final TimeZone TIMEZONE = TimeZone.getTimeZone("Africa/Nairobi");

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    private static SimpleDateFormat[] getFormats() {
        return new SimpleDateFormat[] {
                new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.UK),
                new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.UK),
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z", Locale.UK),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.UK)
        };
    }

    public static Date parseTimestamp(String timestamp) {
        for (SimpleDateFormat format : getFormats()) {
            format.setTimeZone(TIMEZONE);
            try {
                return format.parse(timestamp);
            } catch (Exception ex) {
                continue;
            }
        }

        // All attempts to parse have failed
        return null;
    }


    public static String formatShortTime(long timestamp) {
        DateFormat format = DateFormat.getTimeInstance(DateFormat.SHORT);
        TimeZone tz = TIMEZONE;
        if (tz != null) {
            format.setTimeZone(tz);
        }
        return format.format(new Date(timestamp));
    }

    public static String formatTime(long timestamp, String f) {
        SimpleDateFormat format = new SimpleDateFormat(f, Locale.UK);
        return format.format(new Date(timestamp));
    }
    /**
     * Returns "Today", "Tomorrow", "Yesterday", or a short date format.
     */

    public static boolean isLive(long start, long end) {
        Calendar c_now = Calendar.getInstance();
        c_now.setTimeInMillis(System.currentTimeMillis());
        long t_now = c_now.getTimeInMillis();

        Calendar c_start = Calendar.getInstance();
        c_start.setTimeInMillis(start);
        c_start.set(c_now.get(Calendar.YEAR), c_now.get(Calendar.MONTH), c_now.get(Calendar.DAY_OF_MONTH),
                c_start.get(Calendar.HOUR_OF_DAY), c_start.get(Calendar.MINUTE), c_start.get(Calendar.SECOND));
        long t_start = c_start.getTimeInMillis();

        Calendar c_end = Calendar.getInstance();
        c_end.setTimeInMillis(end);
        c_end.set(c_now.get(Calendar.YEAR), c_now.get(Calendar.MONTH), c_now.get(Calendar.DAY_OF_MONTH)+1,
                c_end.get(Calendar.HOUR_OF_DAY), c_end.get(Calendar.MINUTE), c_end.get(Calendar.SECOND));
        long t_end = c_end.getTimeInMillis();

        return t_now > t_start && t_now < t_end;
    }



    public static int getElapsedYears(long start, long end) {
        if(start == -1) start = now();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start);

        int firstYearValue = calendar.get(Calendar.YEAR);

        calendar.setTimeInMillis(end);
        int secondYearValue = calendar.get(Calendar.YEAR);

        return secondYearValue - firstYearValue;
    }

    public static String formatDate(long time) {
        return formatDate(time, "EEEE dd, MMMM yyyy");
    }

    public static String formatDate(long time, String format) {
        return time > 0 ?  new SimpleDateFormat(format).format(time) : "";
    }

    public static String getMonthYear(long time) {
        return time > 0 ? new SimpleDateFormat("MMM#yyyy").format(time) : "";
    }

    public static String formatMonth(int month) {
        int m = month + 1;
        return ((m < 10) ? "0" : "") + m;
    }

    public static String formatDay(int day) {
        return ((day < 10) ? "0" : "") + day;
    }

    public static String getDay(long time) {
        return time > 0 ? new SimpleDateFormat("dd", Locale.UK).format(time) : "0";
    }

    public static String getMonth(long time) {
        return time > 0 ? new SimpleDateFormat("MM", Locale.UK).format(time) : "0";
    }

    public static String getYear(long time) {
        return time > 0 ? new SimpleDateFormat("yyyy", Locale.UK).format(time) : "0";
    }

    public static long now() {
        return System.currentTimeMillis();
    }
}

