package com.pvt.jd2.project.front.validators;

import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.domain.metamodel.BookSerial_;
import com.pvt.jd2.project.common.service.BookSerialService;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 4:00
 */
public class BookSerialValidator implements Validator {

    @Autowired
    private BookSerialService bookSerialService;

    @Override
    public boolean supports(Class<?> clazz) {
        return BookSerial.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, BookSerial_.NAME, Messages.BOOK_SERIAL_NAME_IS_EMPTY);
        BookSerial bookSerial = (BookSerial)target;
        if (bookSerialService.exists(bookSerial)){
            errors.rejectValue(BookSerial_.NAME, Messages.BOOK_SERIAL_NAME_EXISTS);
        }
    }

}
