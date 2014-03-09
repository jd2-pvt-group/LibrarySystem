package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.metamodel.Book_;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 10.02.14
 * Time: 21:59
 */
public class FindBookValidator extends GenericValidator<Book> {

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book formBean = (Book)target;
        if ((formBean.getIsbn().isEmpty()) &&
                (formBean.getName().isEmpty()) &&
                (formBean.getDescription().isEmpty())){
            errors.rejectValue(Book_.ISBN, Messages.BOOK_TYPE_FIELDS_ARE_EMPTY);
        }
    }

}
