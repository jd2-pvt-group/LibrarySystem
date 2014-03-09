package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.metamodel.Role_;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.RoleService;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.02.14
 * Time: 22:46
 */
public class RoleValidator extends GenericValidator<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Role_.NAME, Messages.ROLE_INFO_NAME_IS_EMPTY);
        Role role = (Role)target;
        if (roleService.exists(role)){
            errors.rejectValue(Role_.NAME, Messages.ROLE_INFO_NAME_EXISTS);
        }
    }

}
