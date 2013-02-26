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
public class UserDAO implements DAO {
    @Autowired
    private DB db;

    public void setDb(DB db) {
        this.db = db;
    }

    public void add(User user) {
        db.save(user);
    }

    public void update(User user) {
        db.saveOrUpdate(user);
    }

    public void delete(User user) {
        db.delete(user);
    }

    public User getById(Long id) {
        return db.get(User.class, id);
    }

    public List<User> getAll() {
        return (List<User>) db.find("from User");
    }
}
