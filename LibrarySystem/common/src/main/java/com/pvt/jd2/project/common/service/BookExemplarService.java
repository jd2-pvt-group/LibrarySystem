package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 22:17
 */
public interface BookExemplarService {

    void create(BookExemplar bookExemplar) throws BusinessLogicException;

    void delete(BookExemplar bookExemplar) throws BusinessLogicException;

    void update(BookExemplar bookExemplar) throws BusinessLogicException;

    boolean exists(BookExemplar bookExemplar) throws BusinessLogicException;

    void activate(BookExemplar bookExemplar) throws BusinessLogicException;

    void deactivate(BookExemplar bookExemplar) throws BusinessLogicException;

    BookExemplar findById(Long id) throws BusinessLogicException;

    List<BookExemplar> listBy(Book book) throws BusinessLogicException;

    List<BookExemplar> listBy(Book book, ActivationStatus status) throws BusinessLogicException;

    List<BookExemplar> list(ActivationStatus status) throws BusinessLogicException;

    List<BookExemplar> listLike(BookExemplar bookExemplar, ActivationStatus status) throws BusinessLogicException;
}
