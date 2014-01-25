package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:51
 */
public interface BookUserDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    BookUser findByBook(Book book) throws DatabaseException;

    List<BookUser> list() throws DatabaseException;

    List<BookUser> findByUser(User user) throws DatabaseException;

    List<BookUser> findByDebt() throws DatabaseException;

    List<BookUser> findByDebtUser(User user) throws DatabaseException;

    List<BookUser> findByIsContinued() throws DatabaseException;

    List<BookUser> findByIsContinued(User user) throws DatabaseException;

}
