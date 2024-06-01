package ru.job4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarningLog implements LogFile {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorLog.class.getName());

    @Override
    public void log(String fileName) {
        if ("WARNING".equals(fileName)) {
            LOG.trace("warning message");
        }
    }
}
