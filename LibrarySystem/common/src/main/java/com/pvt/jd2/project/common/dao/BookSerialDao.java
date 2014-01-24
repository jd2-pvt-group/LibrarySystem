package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 20:48
 */
public interface BookSerialDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(BookSerial bookSerial) throws DatabaseException;

    void delete(BookSerial bookSerial) throws DatabaseException;

    BookSerial findById(Long id) throws DatabaseException;

    List<BookSerial> list() throws DatabaseException;

    List<BookSerial> findByPartOfName(String partOfName) throws DatabaseException;

    List<BookSerial> findByPartOfDescription(String partOfDescription) throws DatabaseException;

}
