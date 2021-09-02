package com.leprofi.bwlevels.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class Logger {
    private static String log_format = "[%date%] %color%%type%: %message%" + Color.RESET;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    public static void error(String message) {
        String output = log_format;
        output = output.replace("%date%", dateFormat.format(System.currentTimeMillis()));
        output = output.replace("%color%", Color.RED);
        output = output.replace("%type%", "ERROR");
        output = output.replace("%message%", message);

        System.out.println(output);
    }

    public static void warn(String message) {
        String output = log_format;
        output = output.replace("%date%", dateFormat.format(System.currentTimeMillis()));
        output = output.replace("%color%", Color.YELLOW);
        output = output.replace("%type%", "WARNING");
        output = output.replace("%message%", message);

        System.out.println(output);
    }
    public static void info(String message) {
        String output = log_format;
        output = output.replace("%date%", dateFormat.format(System.currentTimeMillis()));
        output = output.replace("%color%", "");
        output = output.replace("%type%", "INFO");
        output = output.replace("%message%", message);

        System.out.println(output);
    }
}
