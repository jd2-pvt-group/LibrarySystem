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
public interface BookExemplarUserDao {

    void create(BookExemplarUser bookUser) throws DatabaseException;

    void update(BookExemplarUser bookUser) throws DatabaseException;

    void delete(BookExemplarUser bookUser) throws DatabaseException;

    BookExemplarUser findByBookExemplar(BookExemplar bookExemplar) throws DatabaseException;

    List<BookExemplarUser> list() throws DatabaseException;

    List<BookExemplarUser> listByUser(User user) throws DatabaseException;

    List<BookExemplarUser> listByDebt() throws DatabaseException;

    List<BookExemplarUser> listByDebtUser(User user) throws DatabaseException;

    List<BookExemplarUser> listByIsContinued() throws DatabaseException;

    List<BookExemplarUser> listByIsContinued(User user) throws DatabaseException;

    List<BookExemplarUser> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException;

    List<BookExemplarUser> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException;

    List<BookExemplarUser> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException;

    List<BookExemplarUser> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException;

}
