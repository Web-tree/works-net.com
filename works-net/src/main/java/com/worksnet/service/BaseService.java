package com.worksnet.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.worksnet.dao.DAO;
import com.worksnet.model.Model;

/**
 * @author maxim.levicky
 *         Date: 2/27/13
 *         Time: 12:47 PM
 */
abstract public class BaseService<T extends Model> {
    protected DAO<T> dao;

    public void setDao(DAO<T> dao) {
        this.dao = dao;
    }

    @Transactional
    public int add(T model) {
        return dao.add(model);
    }

    @Transactional
    public int update(T model) {
        return dao.update(model);
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
