package com.db.grad.javaapi.utils;

import org.springframework.format.datetime.DateFormatter;

import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");

}

