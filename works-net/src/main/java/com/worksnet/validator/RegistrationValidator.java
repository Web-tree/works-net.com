package com.worksnet.validator;

import com.worksnet.model.User;
import com.worksnet.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author maxim.levicky
 *         Date: 3/25/13
 *         Time: 11:28 AM
 */
@Component
public class RegistrationValidator {
    private static final int NAME_LENGTH = 50;
    private static final int EMAIL_LENGTH = 50;
    private static final int PASS_MIN_LENGTH = 6;
    private static final int PASS_MAX_LENGTH = 60;

    public void validate(User user, Errors errors, UserService service) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "reg.error.empty.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "reg.error.empty.password");

        if (user.getUserName().length() > NAME_LENGTH) {
            errors.rejectValue("name", "reg.error.length.name", new Object[]{NAME_LENGTH}, "Wrong name length");
        }

        if (user.getEmail().length() > EMAIL_LENGTH) {
            errors.rejectValue("name", "reg.error.length.email", new Object[]{EMAIL_LENGTH}, "Wrong email length");
        }

        if (user.getUserName().length() < 1) {
            user.setUserName(user.getEmail());
        }

        int passLength = user.getPassword().length();
        if (passLength < PASS_MIN_LENGTH || passLength > PASS_MAX_LENGTH) {
            errors.rejectValue("password", "reg.error.length.pass", new Object[]{PASS_MIN_LENGTH, PASS_MAX_LENGTH},
                    "Wrong password length");
        }

        if (null != service.getByName(user.getUsername())) {
            errors.rejectValue("userName", "reg.error.duplicateUsername", new Object[]{user.getUsername()},
                    "Username already exist");
        }

        if (null != service.getByEmail(user.getEmail())) {
            errors.rejectValue("email", "reg.error.duplicateEmail", new Object[]{user.getEmail()},
                    "Email already exist");
        }
    }
}
