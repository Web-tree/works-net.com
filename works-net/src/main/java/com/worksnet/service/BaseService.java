package com.worksnet.service;

import com.worksnet.dao.BaseDAO;
import com.worksnet.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 2/27/13
 *         Time: 12:47 PM
 */
abstract public class BaseService<T extends Model> {
    protected BaseDAO<T> dao;

    @Autowired
    public void setDao(BaseDAO<T> dao) {
        this.dao = dao;
    }

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
