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

    public User getByName(String name) {
        List<User> users = getByParam(User.class, "userName", name);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public User getByEmail(String email) throws UsernameNotFoundException {
        List<User> users = getByParam(User.class, "email", email);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    protected Class<User> getModelType() {
        return User.class;
    }

    @Override
    protected String getAllQuery() {
        return "from User";
    }
}
