package com.jandoblelim.androidchallengejanlim.utilities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by devskywalker on 03/1/18.
 */

public class StringUtil {

    public static String unixToDate(long unixSeconds) {
        Date date = new Date(unixSeconds*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("UTC-8"));
        return sdf.format(date);
    }

    public static String toHundreths(Double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.valueOf(df.format(d));
    }

}
