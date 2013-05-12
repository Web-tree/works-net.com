package com.worksnet.validator;

import com.worksnet.model.Work;
import com.worksnet.model.workdetails.WorkDetail;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:11 PM
 */
@Component
public class WorkValidator {
    public void validate(Work work, BindingResult result) {
    }

    public void validate(WorkDetail detail, Errors error) {

    }
}
