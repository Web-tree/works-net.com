package com.worksnet.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 3/25/13
 *         Time: 11:28 AM
 */
public class RegistrationValidator {
    private static final int NAME_LENGTH = 50;
    private static final int EMAIL_LENGTH = 50;

    public void validate(User user, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "reg.error.empty.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "reg.error.empty.password");

        if (user.getUserName().length() > NAME_LENGTH) {
            errors.rejectValue("name", "reg.error.length.name", new Object[] {NAME_LENGTH}, "Wrong name length");
        }

        if (user.getEmail().length() > EMAIL_LENGTH) {
            errors.rejectValue("name", "reg.error.length.email", new Object[] {EMAIL_LENGTH}, "Wrong name length");
        }

        if (user.getUserName().length() < 1) {
            user.setUserName(user.getEmail());
        }

    }
}
