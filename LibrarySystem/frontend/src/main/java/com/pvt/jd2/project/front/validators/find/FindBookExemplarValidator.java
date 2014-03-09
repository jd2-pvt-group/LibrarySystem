package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.front.formbeans.FindBookExemplar;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 14.02.14
 * Time: 20:34
 */
public class FindBookExemplarValidator extends GenericValidator<FindBookExemplar> {

    @Override
    public boolean supports(Class<?> clazz) {
        return FindBookExemplar.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FindBookExemplar bookExemplar = (FindBookExemplar)target;
        if (bookExemplar.getBookExemplar().getBook().getName().isEmpty() &&
                bookExemplar.getBookExemplar().getBook().getDescription().isEmpty() &&
                bookExemplar.getBookExemplar().getBook().getIsbn().isEmpty() &&
                bookExemplar.getBookExemplar().getLibraryCode().isEmpty() &&
                bookExemplar.getStatus() == ActivationStatus.NONE){
            errors.rejectValue(FindBookExemplar.BOOK_EXEMPLAR_BOOK_ISBN, Messages.BOOK_EXEMPLAR_FIELDS_ARE_EMPTY);
        }
    }

}
