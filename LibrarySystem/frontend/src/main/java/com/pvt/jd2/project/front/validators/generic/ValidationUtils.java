package com.pvt.jd2.project.front.validators.generic;

import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.02.14
 * Time: 22:53
 */
public final class ValidationUtils {

    private ValidationUtils(){
    }

    public static <E> void invokeValidator(GenericValidator<E> validator, E object, Errors errors){
        org.springframework.validation.ValidationUtils.invokeValidator(validator, object, errors);
    }

}
