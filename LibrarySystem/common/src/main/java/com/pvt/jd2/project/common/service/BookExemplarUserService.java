package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:28
 */
public interface BookExemplarUserService {

    void create(BookExemplarUser bookUser) throws BusinessLogicException;

    void update(BookExemplarUser bookUser) throws BusinessLogicException;

    void delete(BookExemplarUser bookUser) throws BusinessLogicException;

    BookExemplarUser findByBookExemplar(BookExemplar bookExemplar) throws BusinessLogicException;

    List<BookExemplarUser> list() throws BusinessLogicException;

    List<BookExemplarUser> listByUser(User user) throws BusinessLogicException;

    List<BookExemplarUser> listByDebt() throws BusinessLogicException;

    List<BookExemplarUser> listByDebtUser(User user) throws BusinessLogicException;

    List<BookExemplarUser> listByIsContinued() throws BusinessLogicException;

    List<BookExemplarUser> listByIsContinued(User user) throws BusinessLogicException;

    List<BookExemplarUser> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookExemplarUser> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookExemplarUser> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

    List<BookExemplarUser> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

}
