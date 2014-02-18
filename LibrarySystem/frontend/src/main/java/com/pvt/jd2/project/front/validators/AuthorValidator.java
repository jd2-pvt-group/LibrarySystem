package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.metamodel.Author_;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 2:53
 */
public class AuthorValidator implements Validator {

    @Autowired
    private AuthorService authorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Author_.FIRST_NAME, Messages.AUTHOR_FIRST_NAME_IS_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Author_.LAST_NAME, Messages.AUTHOR_LAST_NAME_IS_EMPTY);
        Author author = (Author)target;
        if (authorService.exists(author)){
            errors.rejectValue(Author_.FIRST_NAME, Messages.AUTHOR_EXISTS);
        }
    }

}
