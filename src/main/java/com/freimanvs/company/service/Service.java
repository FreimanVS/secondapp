package com.freimanvs.company.service;

import java.util.List;

public interface Service<T> {
    long add(T obj);
    List<T> getList();
    T getById(long id);
    void deleteById(long id);
    void updateById(long id, T obj);
}
