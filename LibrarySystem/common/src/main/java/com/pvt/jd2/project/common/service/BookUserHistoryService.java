package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUserHistory;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:44
 */
public interface BookUserHistoryService {

    void create(BookUserHistory bookUserHistory) throws BusinessLogicException;

    void delete(BookUserHistory bookUserHistory) throws BusinessLogicException;

    BookUserHistory findById(Long id) throws BusinessLogicException;

    List<BookUserHistory> list() throws BusinessLogicException;

    List<BookUserHistory> listByBook(Book book) throws BusinessLogicException;

    List<BookUserHistory> listByUser(User user) throws BusinessLogicException;

    List<BookUserHistory> listByInTime(boolean isInTime) throws BusinessLogicException;

    List<BookUserHistory> listByInTime(User user, boolean isInTime) throws BusinessLogicException;

    List<BookUserHistory> listByContinued(boolean isContinued) throws BusinessLogicException;

    List<BookUserHistory> listByContinued(User user, boolean isContinued) throws BusinessLogicException;

    List<BookUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

    List<BookUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException;


}
