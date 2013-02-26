package com.worksnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worksnet.dao.UserDAO;
import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Transactional
    public List<User> getList() {
        return userDAO.getAll();
    }
}