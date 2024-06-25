package ru.job4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TraceLog implements LogFile {
    private static final Logger LOG = LoggerFactory.getLogger(TraceLog.class.getName());

    @Override
    public void log(String fileName) {
        if (Arrays.asList(fileName.split(" ")).contains("TRACE")) {
            LOG.warn("warning message 123");
        }
    }
}
