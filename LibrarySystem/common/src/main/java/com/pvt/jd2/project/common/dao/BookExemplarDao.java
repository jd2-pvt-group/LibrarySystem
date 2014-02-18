package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 20:40
 */
public interface BookExemplarDao {

    void create(BookExemplar bookExemplar) throws DatabaseException;

    void delete(BookExemplar bookExemplar) throws DatabaseException;

    void update(BookExemplar bookExemplar) throws DatabaseException;

    boolean exists(BookExemplar bookExemplar) throws DatabaseException;

    void activate(BookExemplar bookExemplar) throws DatabaseException;

    void deactivate(BookExemplar bookExemplar) throws DatabaseException;

    BookExemplar findById(Long id) throws DatabaseException;

    List<BookExemplar> listBy(Book book) throws DatabaseException;

    List<BookExemplar> listBy(Book book, ActivationStatus status) throws DatabaseException;

    List<BookExemplar> list(ActivationStatus status) throws DatabaseException;

    List<BookExemplar> listLike(BookExemplar bookExemplar, ActivationStatus status) throws DatabaseException;

}
