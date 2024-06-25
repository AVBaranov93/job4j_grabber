package ru.job4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ErrorLog implements LogFile {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorLog.class.getName());

    @Override
    public void log(String fileName) {
        System.out.println("error");
    }
}
