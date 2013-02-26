package com.worksnet.dao;

import java.util.List;

import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:00 PM
 */
public interface DAO {
    public void add(User user);

    public void update(User user);

    public void delete(User user);

    public User getById(Long id);

    public List<User> getAll();
}
