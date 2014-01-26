package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookUserDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Transactional
    public void create(BookUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.create(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(BookUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.update(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.delete(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
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
    public List<BookUser> listByUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByDebt() throws BusinessLogicException {
        try{
            return bookUserDao.listByDebt();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByDebtUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByDebtUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByIsContinued() throws BusinessLogicException {
        try{
            return bookUserDao.listByIsContinued();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByIsContinued(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByIsContinued(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserDao.listByStartDate(startDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserDao.listByEndDate(endDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserDao.listByStartDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookUser> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserDao.listByEndDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
