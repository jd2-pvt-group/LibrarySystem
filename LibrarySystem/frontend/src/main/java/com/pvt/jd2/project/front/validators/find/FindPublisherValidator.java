package com.pvt.jd2.project.front.validators.find;

import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.domain.metamodel.Publisher_;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.validators.generic.GenericValidator;
import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 0:19
 */
public class FindPublisherValidator extends GenericValidator<Publisher> {

    @Override
    public boolean supports(Class<?> clazz) {
        return Publisher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Publisher formBean = (Publisher)target;
        if ((formBean.getName().isEmpty()) && (formBean.getAddress().isEmpty())) {
            errors.rejectValue(Publisher_.NAME, Messages.PUBLISHER_FIELDS_ARE_EMPTY);
        }
    }
}
