package com.worksnet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worksnet.model.Model;
import com.worksnet.model.User;
import com.worksnet.utils.DB;

/**
 * @author maxim.levicky
 *         Date: 2/28/13
 *         Time: 5:12 PM
 */
abstract public class BaseDAO<T extends Model> implements DAO<Model> {
    @Autowired
    private DB db;

    @Override
    public void add(Model model) {
        db.save(model);
    }

    @Override
    public void update(Model model) {
        db.saveOrUpdate(model);
    }

    @Override
    public void delete(Model model) {
        db.delete(model);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getById(int id) {
        return db.get(User.class, id);
    }

    public List<Model> getAll() {
        return db.find(getAllQuery());
    }

    abstract protected String getAllQuery();

}
