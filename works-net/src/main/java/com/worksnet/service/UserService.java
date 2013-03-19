package com.worksnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.worksnet.dao.UserDAO;
import com.worksnet.model.User;

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

    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        } else {
            return new User();
        }
    }

    public static boolean isAuthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }
}