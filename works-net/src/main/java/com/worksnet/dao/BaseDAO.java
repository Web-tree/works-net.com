package com.worksnet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worksnet.model.Model;
import com.worksnet.utils.DB;

/**
 * @author maxim.levicky
 *         Date: 2/28/13
 *         Time: 5:12 PM
 */
abstract public class BaseDAO<T extends Model> implements DAO<T> {
    @Autowired
    private DB db;

    public void add(T model) {
        db.save(model);
    }

    public void update(T model) {
        db.saveOrUpdate(model);
    }

    public void delete(T model) {
        db.delete(model);
    }

    @SuppressWarnings("unchecked")
    public T getById(int id) {
        return db.get(getClassType(), id);
    }

    public List<T> getAll() {
        return db.find(getAllQuery());
    }

    abstract protected String getAllQuery();

    abstract protected Class<T> getClassType();
}