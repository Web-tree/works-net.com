package com.worksnet.model;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author maxim.levicky
 *         Date: 3/11/13
 *         Time: 12:17 PM
 */
public class UserTest extends TestCase {
    @Test
    public void testFields() {

        int id = 123;
        String name = "TestName";
        String email = "test@email.com";
        Date birth = new Date(System.currentTimeMillis());

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setBirth(birth);

        assertEquals("wrong id", user.getId(), id);
        assertEquals("wrong name", user.getName(), name);
        assertEquals("wrong email", user.getEmail(), email);
        assertEquals("wrong birth", user.getBirth(), birth);
    }

}
