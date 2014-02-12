package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.BookExemplarUserHistoryDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookExemplarUserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:57
 */
@Service
public class BookExemplarUserHistoryServiceImpl implements BookExemplarUserHistoryService {

    @Autowired
    private BookExemplarUserHistoryDao bookUserHistoryDao;

    @Override
    @Transactional
    public void create(BookExemplarUserHistory bookUserHistory) throws BusinessLogicException {
        try{
            bookUserHistoryDao.create(bookUserHistory);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookExemplarUserHistory bookUserHistory) throws BusinessLogicException {
        try{
            bookUserHistoryDao.delete(bookUserHistory);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public BookExemplarUserHistory findById(Long id) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> list() throws BusinessLogicException {
        try{
            return bookUserHistoryDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByBookExemplar(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByBookExemplar(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByUser(User user) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByInTime(boolean isInTime) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByInTime(isInTime);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByInTime(User user, boolean isInTime) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByInTime(user, isInTime);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByInTime(BookExemplar bookExemplar, boolean isInTime) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByInTime(bookExemplar, isInTime);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByContinued(boolean isContinued) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByContinued(isContinued);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByContinued(User user, boolean isContinued) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByContinued(user, isContinued);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByContinued(BookExemplar bookExemplar, boolean isContinued) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByContinued(bookExemplar, isContinued);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByStartDate(startDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByEndDate(endDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByStartDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplarUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByEndDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
