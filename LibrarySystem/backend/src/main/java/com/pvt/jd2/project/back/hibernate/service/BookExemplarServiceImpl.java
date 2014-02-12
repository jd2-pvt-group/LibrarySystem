package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.BookExemplarDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.domain.BookExemplarId;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 22:25
 */
@Service
public class BookExemplarServiceImpl implements BookExemplarService {

    @Autowired
    private BookExemplarDao bookExemplarDao;

    @Override
    @Transactional
    public void create(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.create(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.delete(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(BookExemplarId id) throws BusinessLogicException {
        try{
            return bookExemplarDao.exists(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void activate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.activate(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void deactivate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.deactivate(bookExemplar);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public BookExemplar findByBookExemplarId(BookExemplarId bookExemplarId) throws BusinessLogicException {
        try{
            return bookExemplarDao.findByBookExemplarId(bookExemplarId);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplar> listByBook(Book book, ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.listByBook(book, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplar> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.list(status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
