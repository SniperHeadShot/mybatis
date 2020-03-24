package com.bat.ibatis.util;

import java.util.UUID;

public class UuidUtil {

    public static String createUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
