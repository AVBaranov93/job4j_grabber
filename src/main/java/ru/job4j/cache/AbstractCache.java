package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key) {
        cache.put(key, new SoftReference<>(load(key)));
    }

    public final V get(K key) {
        return cache.getOrDefault(key, new SoftReference<>(load(key))).get();
    }

    protected abstract V load(K key);
}
