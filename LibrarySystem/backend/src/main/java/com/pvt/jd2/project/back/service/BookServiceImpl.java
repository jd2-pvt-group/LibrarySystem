package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:45
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void create(Book book) throws BusinessLogicException {
        try{
            bookDao.create(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Book book) throws BusinessLogicException {
        try{
           bookDao.delete(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void activate(Book book) throws BusinessLogicException {
        try{
            bookDao.activate(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void deactivate(Book book) throws BusinessLogicException {
        try{
            bookDao.deactivate(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Book findById(Long id) throws BusinessLogicException {
        try{
            return bookDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Book findByIsbn(String isbn) throws BusinessLogicException {
        try{
            return bookDao.findByIsbn(isbn);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Book> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return bookDao.list(status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Book> listByPartOfName(String partOfName, ActivationStatus status) throws BusinessLogicException {
        try{
            return bookDao.listByPartOfName(partOfName, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Book> listByPartOfDescription(String partOfDescription, ActivationStatus status) throws BusinessLogicException {
        try{
            return bookDao.listByPartOfDescription(partOfDescription, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
