package com.worksnet.dao;

import java.util.List;

import com.worksnet.model.Model;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:00 PM
 */
public interface DAO<T extends Model> {
    public void add(T user);

    public void update(T user);

    public void delete(T user);

    public T getById(int id);

    public List<T> getAll();
}
