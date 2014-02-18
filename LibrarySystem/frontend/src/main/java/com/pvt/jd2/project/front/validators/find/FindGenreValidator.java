package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.domain.metamodel.Genre_;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 09.02.14
 * Time: 22:33
 */
public class FindGenreValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Genre.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Genre formBean = (Genre)target;
        if ((formBean.getName().isEmpty()) && (formBean.getDescription().isEmpty())) {
            errors.rejectValue(Genre_.NAME, Messages.GENRE_FIELDS_ARE_EMPTY);
        }
    }
}
