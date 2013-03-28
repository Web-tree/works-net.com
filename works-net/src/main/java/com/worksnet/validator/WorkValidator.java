package com.worksnet.validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.worksnet.model.Work;
import com.worksnet.model.workdetails.WorkDetail;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:11 PM
 */
public class WorkValidator {
    public void validate(Work work, BindingResult result) {
    }

    public void validate(WorkDetail detail, Errors error) {

    }
}
