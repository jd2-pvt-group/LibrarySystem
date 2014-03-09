package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.metamodel.Role_;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 02.02.14
 * Time: 3:05
 */
public class FindRoleValidator extends GenericValidator<Role> {

    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Role formBean = (Role)target;
        if ((formBean.getName().isEmpty()) && (formBean.getDescription().isEmpty())) {
            errors.rejectValue(Role_.NAME, Messages.ROLE_FIND_FIELDS_ARE_EMPTY);
        }
    }

}
