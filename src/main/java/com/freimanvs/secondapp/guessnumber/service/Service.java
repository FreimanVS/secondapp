package com.freimanvs.secondapp.guessnumber.service;

import java.util.List;

public interface Service<T> {
    Long add(T obj);
    List<T> getList();
    T getById(Long id);
    T getByName(String name);
    void deleteById(Long id);
    void updateById(Long id, T obj);
}
