package com.worksnet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worksnet.model.User;
import com.worksnet.utils.DB;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class UserDAO<T extends User> implements DAO<User> {
    @Autowired
    private DB db;

    @Override
    public void add(User user) {
        db.save(user);
    }

    @Override
    public void update(User user) {
        db.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        db.delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getById(int id) {
        return db.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return db.find("from User");
    }
}
