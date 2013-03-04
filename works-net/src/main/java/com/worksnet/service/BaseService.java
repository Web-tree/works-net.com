package com.worksnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.worksnet.dao.BaseDAO;
import com.worksnet.model.Model;

/**
 * @author maxim.levicky
 *         Date: 2/27/13
 *         Time: 12:47 PM
 */
abstract public class BaseService<T extends Model> {
    @Autowired
    private BaseDAO<T> dao;

    @Transactional
    public void add(T model) {
        dao.add(model);
    }

    @Transactional
    public void update(T model) {
        dao.update(model);
    }

    @Transactional
    public void delete(T model) {
        dao.delete(model);
    }

    @Transactional
    public T getById(int id) {
        return dao.getById(id);
    }

    @Transactional
    public List<T> getList() {
        return dao.getAll();
    }
}
