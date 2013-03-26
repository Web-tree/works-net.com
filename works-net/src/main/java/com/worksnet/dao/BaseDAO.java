package com.worksnet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
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
    protected DB db;

    public int add(T model) {
        return db.save(model);
    }

    public int saveOrUpdate(T model) {
        return db.saveOrUpdate(model);
    }

    public int save(T model) {
        return db.save(model);
    }
    public void update(T model) {
        db.update(model);
    }

    public void delete(T model) {
        db.delete(model);
    }

    @SuppressWarnings("unchecked")
    public T getById(int id) {
        return db.get(getClassType(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getByParam(Class clazz, String param, Object value) {
        return db.createCriteria(clazz)
                .add(Restrictions.eq(param, value))
                .list();
    }

    public List<T> getAll() {
        List<T> list = db.find(getAllQuery());
        return (list == null) ? getEmptyList() : list;
    }

    protected List<T> getEmptyList() {
        return new ArrayList<T>();
    }

    abstract protected Class<T> getClassType();

    abstract protected String getAllQuery();

}
