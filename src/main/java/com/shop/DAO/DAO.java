package com.shop.DAO;

import java.util.List;

public interface DAO<T, UUID> {
    void save(T t);

    void update(T t);

    void delete(UUID UUID);

    T findByID(UUID UUID);

    T findByName(String name);

    List<T> getAll();

    int getCount();
}
