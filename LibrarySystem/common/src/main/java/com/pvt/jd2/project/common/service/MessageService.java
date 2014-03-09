package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 22:39
 */
public interface MessageService {

    void create(Message message) throws BusinessLogicException;

    void update(Message message) throws BusinessLogicException;

    boolean exists(String code) throws BusinessLogicException;

    Message findBy(String code, Language language) throws BusinessLogicException;

}
