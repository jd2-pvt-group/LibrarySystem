package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 28.01.14
 * Time: 15:42
 */
public class LoginFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.LOGIN, Messages.LOGIN_PAGE_LOGIN_IS_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.PASSWORD, Messages.LOGIN_PAGE_PASSWORD_IS_EMPTY);
    }
}
