package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:44
 */
public interface BookExemplarUserHistoryService {

    void create(BookExemplarUserHistory bookUserHistory) throws BusinessLogicException;

    void delete(BookExemplarUserHistory bookUserHistory) throws BusinessLogicException;

    BookExemplarUserHistory findById(Long id) throws BusinessLogicException;

    List<BookExemplarUserHistory> list() throws BusinessLogicException;

    List<BookExemplarUserHistory> listByBookExemplar(BookExemplar bookExemplar) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByUser(User user) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByInTime(boolean isInTime) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByInTime(User user, boolean isInTime) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByInTime(BookExemplar bookExemplar, boolean isInTime) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByContinued(boolean isContinued) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByContinued(User user, boolean isContinued) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByContinued(BookExemplar bookExemplar, boolean isContinued) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

    List<BookExemplarUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

}
