package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 1:24
 */
public interface BookExemplarUserHistoryDao {

    void create(BookExemplarUserHistory bookUserHistory) throws DatabaseException;

    void delete(BookExemplarUserHistory bookUserHistory) throws DatabaseException;

    BookExemplarUserHistory findById(Long id) throws DatabaseException;

    List<BookExemplarUserHistory> list() throws DatabaseException;

    List<BookExemplarUserHistory> listByBookExemplar(BookExemplar bookExemplar) throws DatabaseException;

    List<BookExemplarUserHistory> listByUser(User user) throws DatabaseException;

    List<BookExemplarUserHistory> listByInTime(boolean isInTime) throws DatabaseException;

    List<BookExemplarUserHistory> listByInTime(User user, boolean isInTime) throws DatabaseException;

    List<BookExemplarUserHistory> listByInTime(BookExemplar bookExemplar, boolean isInTime) throws DatabaseException;

    List<BookExemplarUserHistory> listByContinued(boolean isContinued) throws DatabaseException;

    List<BookExemplarUserHistory> listByContinued(User user, boolean isContinued) throws DatabaseException;

    List<BookExemplarUserHistory> listByContinued(BookExemplar bookExemplar, boolean isContinued) throws DatabaseException;

    List<BookExemplarUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException;

    List<BookExemplarUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException;

    List<BookExemplarUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException;

    List<BookExemplarUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException;

}
