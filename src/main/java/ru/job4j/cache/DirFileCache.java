package ru.job4j.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(String.format("%s/%s", cachingDir, key)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;

    }
}
