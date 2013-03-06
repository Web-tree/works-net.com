package com.worksnet.dao;

import java.util.List;

/**
 * @author Max Levicky
 *         Date: 02.03.13
 *         Time: 10:03
 */
public interface DAO<T> {
    public void add(T model);

    public void update(T model);

    public void delete(T model);

    @SuppressWarnings("unchecked")
    public T getById(int id);

    public List<T> getAll();
}
