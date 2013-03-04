package com.worksnet.dao;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 3/1/13
 *         Time: 1:41 PM
 */
public interface DAO<T> {
    public void add(T model);

    public void update(T model);

    public void delete(T model);

    public T getById(int id);

    public List<T> getAll();
}
