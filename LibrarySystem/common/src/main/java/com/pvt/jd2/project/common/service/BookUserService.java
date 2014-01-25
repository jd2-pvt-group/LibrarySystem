package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.dao.BookUserDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:28
 */
public interface BookUserService {

    void setBookUserDao(BookUserDao bookUserDao);

    BookUserDao getBookUserDao();

    BookUser findByBook(Book book) throws BusinessLogicException;

    List<BookUser> list() throws BusinessLogicException;

    List<BookUser> findByUser(User user) throws BusinessLogicException;

    List<BookUser> findByDebt() throws BusinessLogicException;

    List<BookUser> findByDebtUser(User user) throws BusinessLogicException;

    List<BookUser> findByIsContinued() throws BusinessLogicException;

    List<BookUser> findByIsContinued(User user) throws BusinessLogicException;

}
