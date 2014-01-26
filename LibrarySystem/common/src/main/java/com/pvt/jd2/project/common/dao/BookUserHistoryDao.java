package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUserHistory;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 1:24
 */
public interface BookUserHistoryDao {

    void create(BookUserHistory bookUserHistory) throws DatabaseException;

    void delete(BookUserHistory bookUserHistory) throws DatabaseException;

    BookUserHistory findById(Long id) throws DatabaseException;

    List<BookUserHistory> list() throws DatabaseException;

    List<BookUserHistory> listByBook(Book book) throws DatabaseException;

    List<BookUserHistory> listByUser(User user) throws DatabaseException;

    List<BookUserHistory> listByInTime(boolean isInTime) throws DatabaseException;

    List<BookUserHistory> listByInTime(User user, boolean isInTime) throws DatabaseException;

    List<BookUserHistory> listByContinued(boolean isContinued) throws DatabaseException;

    List<BookUserHistory> listByContinued(User user, boolean isContinued) throws DatabaseException;

    List<BookUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException;

    List<BookUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException;

    List<BookUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException;

    List<BookUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException;

}
