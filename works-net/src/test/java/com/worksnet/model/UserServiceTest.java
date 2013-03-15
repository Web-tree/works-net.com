package com.worksnet.model;

import junit.framework.TestCase;

import org.junit.Test;

import com.worksnet.service.UserService;

/**
 * @author maxim.levicky
 *         Date: 3/11/13
 *         Time: 1:11 PM
 */
public class UserServiceTest extends TestCase {
    private UserService service;

    public UserServiceTest() {

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = new UserService();
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("TestUser");


        int userId = service.add(user);
        user.setId(userId);
        User dbUser = service.getById(userId);
        assertEquals(user, dbUser);
    }
}
