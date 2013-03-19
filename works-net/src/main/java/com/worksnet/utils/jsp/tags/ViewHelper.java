package com.worksnet.utils.jsp.tags;


import com.worksnet.model.User;
import com.worksnet.service.UserService;

/**
 * @author maxim.levicky
 *         Date: 3/19/13
 *         Time: 12:09 PM
 */
public class ViewHelper {


    public boolean checkCurrentUser(User user) {
        return checkCurrentUser(user.getId());
    }

    public static boolean checkCurrentUser(int userId) {
        return UserService.getCurrentUser().getId() == userId;
    }
}
