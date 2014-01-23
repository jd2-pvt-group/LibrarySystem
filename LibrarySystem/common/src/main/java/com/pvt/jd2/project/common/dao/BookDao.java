package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:36
 */
public interface BookDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Book address) throws DatabaseException;

    void delete(Book address) throws DatabaseException;

    Book findById(Long id) throws DatabaseException;

    List<Book> list() throws DatabaseException;

    Book findByIsbn(String isbn) throws DatabaseException;

    List<Book> findByPartOfName(String partOfName) throws DatabaseException;

}
