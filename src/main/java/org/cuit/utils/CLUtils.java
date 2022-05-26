package org.cuit.utils;

import java.sql.Timestamp;
import java.util.UUID;

public class CLUtils {

    static boolean printFlag = true;

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static void print(String msg){

    }

}
