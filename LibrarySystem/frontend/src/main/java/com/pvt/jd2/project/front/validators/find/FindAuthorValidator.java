package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.metamodel.Author_;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 3:35
 */
public class FindAuthorValidator extends GenericValidator<Author> {

    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author formBean = (Author)target;
        if ((formBean.getFirstName().isEmpty()) && (formBean.getLastName().isEmpty())) {
            errors.rejectValue(Author_.FIRST_NAME, Messages.AUTHOR_FIELDS_ARE_EMPTY);
        }
    }

}
