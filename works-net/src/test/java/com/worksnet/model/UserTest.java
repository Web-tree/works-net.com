package com.worksnet.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

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
        user.setUserName(name);
        user.setEmail(email);
        user.setBirth(birth);

        assertEquals("wrong id", user.getId(), id);
        assertEquals("wrong name", user.getUserName(), name);
        assertEquals("wrong email", user.getEmail(), email);
        assertEquals("wrong birth", user.getBirth(), birth);
    }

}
