package ru.job4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class WarningLog implements LogFile {
    private static final Logger LOG = LoggerFactory.getLogger(WarningLog.class.getName());

    @Override
    public void log(String fileName) {
        if (Arrays.asList(fileName.split(" ")).contains("WARNING")) {
            LOG.warn("warning message");
        }
    }
}
