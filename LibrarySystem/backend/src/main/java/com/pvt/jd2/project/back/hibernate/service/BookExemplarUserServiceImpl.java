package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.BookExemplarUserDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookExemplarUserService;
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
public class BookExemplarUserServiceImpl implements BookExemplarUserService {

    @Autowired
    private BookExemplarUserDao bookUserDao;

    @Override
    @Transactional
    public void create(BookExemplarUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.create(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(BookExemplarUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.update(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookExemplarUser bookUser) throws BusinessLogicException {
        try{
            bookUserDao.delete(bookUser);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public BookExemplarUser findByBookExemplar(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
           return bookUserDao.findByBookExemplar(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> list() throws BusinessLogicException {
        try{
            return bookUserDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByDebt() throws BusinessLogicException {
        try{
            return bookUserDao.listByDebt();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByDebtUser(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByDebtUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByIsContinued() throws BusinessLogicException {
        try{
            return bookUserDao.listByIsContinued();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByIsContinued(User user) throws BusinessLogicException {
        try{
            return bookUserDao.listByIsContinued(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserDao.listByStartDate(startDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserDao.listByEndDate(endDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserDao.listByStartDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUser> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserDao.listByEndDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
