package com.worksnet.validator;

import com.worksnet.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:11 PM
 */
@Component
public class UserValidator {
    public void validate(User user, BindingResult result) {
    }
}
