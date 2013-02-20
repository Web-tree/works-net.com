package com.worksnet.DAO;

import java.util.List;

import com.worksnet.model.User;
import com.worksnet.utils.DB;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class UserDAO implements DAO {
    public void add(User user) {
        DB.save(user);
    }

    public void update(User user) {
        DB.saveOrUpdate(user);
    }

    public void delete(User user) {
        DB.delete(user);
    }

    public User getById(Long id) {
        return DB.get(User.class, id);
    }

    public List<User> getAll() {
        return DB.find("from user");
    }
}
