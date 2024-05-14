package ru.job4j.ood.lsp.store;

import java.util.List;

public interface Store<T> {
    void add(T t);

    List<T> getAllProducts();

    T findById(int id);

    T delete(int id);

    void clear();

    void addRestored(T t);
}
