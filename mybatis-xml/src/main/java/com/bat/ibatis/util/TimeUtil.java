package com.bat.ibatis.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static final DateTimeFormatter DF_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public static String getLocalDateTime() {
        return LocalDateTime.now().format(DF_DATE);
    }
}
