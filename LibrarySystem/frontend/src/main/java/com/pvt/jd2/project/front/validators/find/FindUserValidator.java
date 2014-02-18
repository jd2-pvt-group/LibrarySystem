package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.pvt.jd2.project.common.domain.User;
/**
 * Created by Admin on 2/11/14.
 */
public class FindUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user= (User)o;
        if(user.getFirstName().isEmpty()&& user.getLastName().isEmpty()&&user.getPassportNumber().isEmpty()&&user.getAddress().isEmpty()){
            errors.rejectValue(User_.LOGIN, Messages.USER_FIND_ALL_FIELDS_EMPTY);
        }
    }

}
