package com.worksnet.dao;

import com.worksnet.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class UserDAO extends BaseDAO<User> {

    public User getByName(String name) throws UsernameNotFoundException {
        List<User> users = db.find("from User where name = ?", name);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User" + name + "not found");
        }
        return users.get(0);
    }

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }

    @Override
    protected String getAllQuery() {
        return "from User";
    }
}
