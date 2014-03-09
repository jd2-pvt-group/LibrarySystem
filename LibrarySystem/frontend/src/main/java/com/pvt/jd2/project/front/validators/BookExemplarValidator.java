package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.domain.metamodel.BookExemplar_;
import com.pvt.jd2.project.common.service.BookExemplarService;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 04.02.14
 * Time: 8:47
 */
public class BookExemplarValidator extends GenericValidator<BookExemplar> {

    @Autowired
    private BookExemplarService bookExemplarService;

    @Override
    public boolean supports(Class<?> clazz) {
        return BookExemplar.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookExemplar bookExemplar = (BookExemplar)target;
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.BOOK_ISBN, Messages.BOOK_ADD_NO_BOOK_TYPE);
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.BOOK_NAME, Messages.BOOK_ADD_BOOK_NAME_IS_EMPTY);
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.BOOK_PUBLISHER, Messages.BOOK_ADD_NO_PUBLISHER);
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.BOOK_AUTHORS, Messages.BOOK_ADD_NO_AUTHORS);
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.BOOK_GENRES, Messages.BOOK_ADD_NO_GENRES);
        ValidationUtils.rejectIfEmpty(errors, BookExemplar_.LIBRARY_CODE, Messages.BOOK_ADD_LIBRARY_CODE_IS_EMPTY);
        if ((bookExemplar.getBook().getId() != null) && (bookExemplar.getLibraryCode() != null)){
            if (bookExemplarService.exists(bookExemplar)){
                errors.rejectValue(BookExemplar_.LIBRARY_CODE, Messages.BOOK_ADD_ISBN_WITH_SUCH_LIBRARY_CODE_EXISTS);
            }
        }
    }

}
