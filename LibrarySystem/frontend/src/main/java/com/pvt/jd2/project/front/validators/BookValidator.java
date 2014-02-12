package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.metamodel.Book_;
import com.pvt.jd2.project.common.service.BookService;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 1:36
 */
public class BookValidator implements Validator {

    @Autowired
    private BookService bookService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, Book_.ISBN, Messages.BOOK_TYPE_ADD_ISBN_IS_EMPTY);
        ValidationUtils.rejectIfEmpty(errors, Book_.NAME, Messages.BOOK_ADD_BOOK_NAME_IS_EMPTY);
        ValidationUtils.rejectIfEmpty(errors, Book_.PUBLISHER, Messages.BOOK_ADD_NO_PUBLISHER);
        ValidationUtils.rejectIfEmpty(errors, Book_.AUTHORS, Messages.BOOK_ADD_NO_AUTHORS);
        ValidationUtils.rejectIfEmpty(errors, Book_.GENRES, Messages.BOOK_ADD_NO_GENRES);
        Book book = (Book)target;
        if (bookService.exists(book)) {
            errors.rejectValue(Book_.ISBN, Messages.BOOK_TYPE_ADD_ISBN_EXISTS);
        }
    }

}
