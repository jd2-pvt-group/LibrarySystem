package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:28
 */
public interface BookUserService {

    void create(BookUser bookUser) throws BusinessLogicException;

    void update(BookUser bookUser) throws BusinessLogicException;

    void delete(BookUser bookUser) throws BusinessLogicException;

    BookUser findByBook(Book book) throws BusinessLogicException;

    List<BookUser> list() throws BusinessLogicException;

    List<BookUser> listByUser(User user) throws BusinessLogicException;

    List<BookUser> listByDebt() throws BusinessLogicException;

    List<BookUser> listByDebtUser(User user) throws BusinessLogicException;

    List<BookUser> listByIsContinued() throws BusinessLogicException;

    List<BookUser> listByIsContinued(User user) throws BusinessLogicException;

    List<BookUser> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookUser> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException;

    List<BookUser> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

    List<BookUser> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException;

}
