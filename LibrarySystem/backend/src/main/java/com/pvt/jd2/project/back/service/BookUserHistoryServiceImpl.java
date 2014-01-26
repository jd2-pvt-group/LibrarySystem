package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookUserHistoryDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUserHistory;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookUserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:57
 */
@Service
public class BookUserHistoryServiceImpl implements BookUserHistoryService {

    @Autowired
    private BookUserHistoryDao bookUserHistoryDao;

    @Override
    public void create(BookUserHistory bookUserHistory) throws BusinessLogicException {
        try{
            bookUserHistoryDao.create(bookUserHistory);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(BookUserHistory bookUserHistory) throws BusinessLogicException {
        try{
            bookUserHistoryDao.delete(bookUserHistory);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public BookUserHistory findById(Long id) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> list() throws BusinessLogicException {
        try{
            return bookUserHistoryDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByBook(Book book) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByBook(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByUser(User user) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByInTime(boolean isInTime) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByInTime(isInTime);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByInTime(User user, boolean isInTime) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByInTime(user, isInTime);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByContinued(boolean isContinued) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByContinued(isContinued);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByContinued(User user, boolean isContinued) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByContinued(user, isContinued);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByStartDate(startDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByEndDate(endDate, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByStartDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws BusinessLogicException {
        try{
            return bookUserHistoryDao.listByEndDateBetween(startDate, endDate);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
