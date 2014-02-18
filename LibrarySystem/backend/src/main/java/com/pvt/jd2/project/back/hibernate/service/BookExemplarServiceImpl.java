package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.dao.BookExemplarDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookExemplarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 22:25
 */
@Service
public class BookExemplarServiceImpl implements BookExemplarService {

    private static final Logger logger = LoggerFactory.getLogger(BookExemplarService.class);

    @Autowired
    private BookExemplarDao bookExemplarDao;

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void create(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.create(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.delete(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.update(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            return bookExemplarDao.exists(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void activate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.activate(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void deactivate(BookExemplar bookExemplar) throws BusinessLogicException {
        try{
            bookExemplarDao.deactivate(bookExemplar);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public BookExemplar findById(Long id) throws BusinessLogicException {
        try{
            return bookExemplarDao.findById(id);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<BookExemplar> listBy(Book book) throws BusinessLogicException {
        try{
            return bookExemplarDao.listBy(book);
        }catch (DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplar> listBy(Book book, ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.listBy(book, status);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplar> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return bookExemplarDao.list(status);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookExemplar> listLike(BookExemplar bookExemplar, ActivationStatus status) throws BusinessLogicException {
        try{
            Set<BookExemplar> result = new HashSet<BookExemplar>();
            List<Book> books = bookDao.listLike(bookExemplar.getBook());
            result.addAll(getListForBooks(books));
            result.addAll(bookExemplarDao.listLike(bookExemplar, status));
            return new ArrayList<BookExemplar>(result);
        }catch(DatabaseException e){
            logger.error("Database exception during execution: ", e);
            throw new BusinessLogicException(e);
        }
    }

    private Set<BookExemplar> getListForBooks(List<Book> books) {
        Set<BookExemplar> bookExemplars = new HashSet<BookExemplar>();
        for(Book book : books){
            bookExemplars.addAll(bookExemplarDao.listBy(book));
        }
        return bookExemplars;
    }

}
