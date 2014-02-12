package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:37
 */
public interface BookSerialService {

    void create(BookSerial bookSerial) throws BusinessLogicException;

    void delete(BookSerial bookSerial) throws BusinessLogicException;

    void update(BookSerial bookSerial) throws BusinessLogicException;

    boolean exists(BookSerial bookSerial) throws BusinessLogicException;

    BookSerial findById(Long id) throws BusinessLogicException;

    BookSerial findFor(Book book) throws BusinessLogicException;

    List<BookSerial> list() throws BusinessLogicException;

    List<BookSerial> listLike(BookSerial bookSerial) throws BusinessLogicException;

}
