package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 31.01.14
 * Time: 9:34
 */
public class UserValidator extends GenericValidator<User> {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.LOGIN, Messages.LOGIN_PAGE_LOGIN_IS_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.PASSWORD, Messages.LOGIN_PAGE_PASSWORD_IS_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, User_.PASS_NUMBER, Messages.USER_INFO_PASS_NUMBER_IS_EMPTY);
        User user = (User)target;
        if ( userService.isLoginExist(user.getId(), user.getLogin())) {
            errors.rejectValue(User_.LOGIN, Messages.USER_INFO_LOGIN_EXISTS);
        }

        if (userService.isPassportNumberExist(user.getId(), user.getPassportNumber())){
            errors.rejectValue(User_.PASS_NUMBER, Messages.USER_INFO_PASS_NUMBER_EXISTS);
        }
    }
}
