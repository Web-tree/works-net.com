package com.worksnet.service;

import com.worksnet.dao.UserDAO;
import com.worksnet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class UserService extends BaseService<User> {

    protected String rememberMeKey = "remember_me_key";

    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        } else {
            return new User();
        }
    }

    public static User createNewUser(String login) {
        User user = new User();
        user.setUserName(login);
        return user;
    }

    public static boolean isAuthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }

    public void loginByUser(User user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public UserDAO getDao() {
        return (UserDAO) dao;
    }

    public User getByName(String name) {
        return getDao().getByName(name);
    }

    public User getByEmail(String email) throws UsernameNotFoundException {
        return getDao().getByEmail(email);
    }


}