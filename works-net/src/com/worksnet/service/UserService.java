package com.worksnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worksnet.DAO.UserDAO;
import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public User getById(Long id) {
        return userDAO.getById(id);
    }

    public List<User> getList() {
        return userDAO.getAll();
    }
}