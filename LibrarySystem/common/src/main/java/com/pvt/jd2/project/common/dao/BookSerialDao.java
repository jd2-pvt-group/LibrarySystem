package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 20:48
 */
public interface BookSerialDao {

    void create(BookSerial bookSerial) throws DatabaseException;

    void delete(BookSerial bookSerial) throws DatabaseException;

    void update(BookSerial bookSerial) throws DatabaseException;

    boolean exists(BookSerial bookSerial) throws DatabaseException;

    BookSerial findById(Long id) throws DatabaseException;

    BookSerial findFor(Book book) throws DatabaseException;

    List<BookSerial> list() throws DatabaseException;

    List<BookSerial> listLike(BookSerial bookSerial) throws DatabaseException;

}
