package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookUserDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:33
 */
@Service
public class BookUserServiceImpl implements BookUserService {

    @Autowired
    private BookUserDao bookUserDao;

    @Override
    public void setBookUserDao(BookUserDao bookUserDao) {
        this.bookUserDao = bookUserDao;
    }

    @Override
    public BookUserDao getBookUserDao() {
        return bookUserDao;
    }

    @Override
    @Transactional
    public BookUser findByBook(Book book) throws BusinessLogicException {
        try{
           return bookUserDao.findByBook(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> list() throws BusinessLogicException {
        try{
            return bookUserDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> findByUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.findByUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> findByDebt() throws BusinessLogicException {
        try{
            return bookUserDao.findByDebt();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> findByDebtUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.findByDebtUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> findByIsContinued() throws BusinessLogicException {
        try{
            return bookUserDao.findByIsContinued();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> findByIsContinued(User user) throws BusinessLogicException {
        try{
            return bookUserDao.findByIsContinued(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
