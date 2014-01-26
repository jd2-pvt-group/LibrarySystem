package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:48
 */
public interface PublisherService {

    void create(Publisher publisher) throws BusinessLogicException;

    void delete(Publisher publisher) throws BusinessLogicException;

    Publisher findById(Long id) throws BusinessLogicException;

    List<Publisher> list() throws BusinessLogicException;

    List<Publisher> listByPartOfName(String partOfName) throws BusinessLogicException;

    List<Publisher> listByPartOfAddress(String partOfAddress) throws BusinessLogicException;

}
