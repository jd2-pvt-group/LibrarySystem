package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.domain.metamodel.Publisher_;
import com.pvt.jd2.project.common.service.PublisherService;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 07.02.14
 * Time: 23:58
 */
public class PublisherValidator implements Validator {

    @Autowired
    private PublisherService publisherService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Publisher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Publisher_.NAME, Messages.PUBLISHER_NAME_IS_EMPTY);
        Publisher publisher = (Publisher)target;
        if (publisherService.exists(publisher)){
            errors.rejectValue(Publisher_.NAME, Messages.PUBLISHER_NAME_EXISTS);
        }
    }

}
