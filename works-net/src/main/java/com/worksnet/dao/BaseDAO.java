package com.worksnet.dao;

import com.worksnet.model.Model;
import com.worksnet.utils.DB;
import org.hibernate.annotations.Table;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

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

    public boolean isModelExists(int id) {
        return (boolean) db.createQuery("SELECT 1 FROM " + getDaoTable() + " WHERE id = '?'")
                .setInteger(1, id)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public T getById(int id) {
        return db.get(getModelType(), id);
    }

    public String getDaoTable() {
        Annotation[] annotations = getModelType().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Table) {
                return ((Table) annotation).comment();
            }
        }
        throw new Error("Annotation Table not found in model " + getModelType().getCanonicalName());
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

    abstract protected Class<T> getModelType();

    abstract protected String getAllQuery();

}
