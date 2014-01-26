package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookExemplarDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.domain.BookExemplarId;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.BookExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.create(bookExemplar);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.delete(bookExemplar);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void activate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.activate(bookExemplar);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void deactivate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.deactivate(bookExemplar);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public BookExemplar findByBookExemplarId(BookExemplarId bookExemplarId) throws BusinessLogicException {
        try{
            return bookExemplarDao.findByBookExemplarId(bookExemplarId);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookExemplar> listByBook(Book book, ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.listByBook(book, status);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookExemplar> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.list(status);
        }catch(Exception e){
            throw new BusinessLogicException(e);
        }
    }
}
