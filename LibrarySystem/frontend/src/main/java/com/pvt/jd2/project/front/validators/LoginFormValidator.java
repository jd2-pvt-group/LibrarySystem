package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.front.formbeans.LoginForm;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 28.01.14
 * Time: 15:42
 */
public class LoginFormValidator extends GenericValidator<LoginForm> {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.LOGIN, Messages.LOGIN_PAGE_LOGIN_IS_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.PASSWORD, Messages.LOGIN_PAGE_PASSWORD_IS_EMPTY);
    }

}
