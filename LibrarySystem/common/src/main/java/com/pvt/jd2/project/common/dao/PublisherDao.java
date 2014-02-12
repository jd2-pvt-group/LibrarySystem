package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 21:03
 */
public interface PublisherDao {

    void create(Publisher publisher) throws DatabaseException;

    void delete(Publisher publisher) throws DatabaseException;

    void update(Publisher publisher) throws DatabaseException;

    boolean exists(Publisher publisher) throws DatabaseException;

    Publisher findById(Long id) throws DatabaseException;

    Publisher findFor(Book book) throws DatabaseException;

    List<Publisher> list() throws DatabaseException;

    List<Publisher> listLike(Publisher publisher) throws DatabaseException;

}
