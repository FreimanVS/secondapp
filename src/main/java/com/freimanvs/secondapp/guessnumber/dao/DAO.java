package com.freimanvs.secondapp.guessnumber.dao;

import java.util.List;

public interface DAO<T> {
    Long add(T obj);
    List<T> getList();
    T getById(Long id);
    T getByName(String name);
    void deleteById(Long id);
    void updateById(Long id, T obj);
}
