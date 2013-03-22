package com.worksnet.dao;

import java.util.List;

/**
 * @author Max Levicky
 *         Date: 02.03.13
 *         Time: 10:03
 */
public interface DAO<T> {
    public int add(T model);

    public int saveOrUpdate(T model);

    public int save(T model);

    public void update(T model);

    public void delete(T model);

    @SuppressWarnings("unchecked")
    public T getById(int id);

    public List<T> getAll();
}
