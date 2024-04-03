package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

public class Emulator {
    private AbstractCache<String, String> cache;

    public void setCachingDirectory(String dir) {
        this.cache = new DirFileCache(dir);
    }

    public void loadInCache(String fileName) {
        this.cache.put(fileName);
    }

    public String getFromCache(String fileName) {
        return this.cache.get(fileName);
    }
}
