package com.worksnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.worksnet.dao.UserDAO;
import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 3/18/13
 *         Time: 10:54 AM
 */
@Service
public class UserDetailsService extends UserService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByName(username);
    }
}
