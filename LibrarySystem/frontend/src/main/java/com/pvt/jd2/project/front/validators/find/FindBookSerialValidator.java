package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.domain.metamodel.BookSerial_;
import com.pvt.jd2.project.front.util.Messages;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 6:25
 */
public class FindBookSerialValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookSerial.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookSerial formBean = (BookSerial)target;
        if ((formBean.getName().isEmpty()) && (formBean.getDescription().isEmpty())) {
            errors.rejectValue(BookSerial_.NAME, Messages.BOOK_SERIAL_FIELDS_ARE_EMPTY);
        }
    }
}
