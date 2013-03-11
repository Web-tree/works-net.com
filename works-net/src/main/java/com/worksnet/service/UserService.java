package com.worksnet.service;

import com.worksnet.dao.UserDAO;
import com.worksnet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class UserService extends BaseService<User> {

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
}