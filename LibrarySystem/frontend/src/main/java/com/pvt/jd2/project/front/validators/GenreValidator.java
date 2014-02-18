package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.domain.metamodel.Genre_;
import com.pvt.jd2.project.common.domain.metamodel.Publisher_;
import com.pvt.jd2.project.common.service.GenreService;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 09.02.14
 * Time: 15:09
 */
public class GenreValidator implements Validator {

    @Autowired
    private GenreService genreService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Genre.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Genre_.NAME, Messages.GENRE_NAME_IS_EMPTY);
        Genre genre = (Genre)target;
        if (genreService.exists(genre)){
            errors.rejectValue(Genre_.NAME, Messages.GENRE_NAME_EXISTS);
        }
    }
}
