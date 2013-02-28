package com.worksnet.dao;

import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class UserDAO extends BaseDAO<User> {
    @Override
    protected String getAllQuery() {
        return "from User";
    }
}
