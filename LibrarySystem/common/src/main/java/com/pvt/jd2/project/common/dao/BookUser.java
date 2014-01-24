package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:51
 */
public interface BookUser {

    BookUser findByBook(Book book) throws DatabaseException;

    List<BookUser> findByUser(User user) throws DatabaseException;

    List<BookUser> findByStartDate(Date startDate) throws DatabaseException;

    List<BookUser> findByEndDate(Date endDate) throws DatabaseException;

    List<BookUser> findByIsContinued() throws DatabaseException;

    List<BookUser> findByIsContinued(User user) throws DatabaseException;

}
