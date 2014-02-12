package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Book;
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

    void update(Publisher publisher) throws BusinessLogicException;

    boolean exists(Publisher publisher) throws BusinessLogicException;

    Publisher findById(Long id) throws BusinessLogicException;

    Publisher findFor(Book book) throws BusinessLogicException;

    List<Publisher> list() throws BusinessLogicException;

    List<Publisher> listLike(Publisher publisher) throws BusinessLogicException;

}
