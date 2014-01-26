package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:51
 */
public interface BookUserDao {

    void create(BookUser bookUser) throws DatabaseException;

    void update(BookUser bookUser) throws DatabaseException;

    void delete(BookUser bookUser) throws DatabaseException;

    BookUser findByBook(Book book) throws DatabaseException;

    List<BookUser> list() throws DatabaseException;

    List<BookUser> listByUser(User user) throws DatabaseException;

    List<BookUser> listByDebt() throws DatabaseException;

    List<BookUser> listByDebtUser(User user) throws DatabaseException;

    List<BookUser> listByIsContinued() throws DatabaseException;

    List<BookUser> listByIsContinued(User user) throws DatabaseException;

    List<BookUser> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException;

    List<BookUser> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException;

    List<BookUser> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException;

    List<BookUser> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException;

}
