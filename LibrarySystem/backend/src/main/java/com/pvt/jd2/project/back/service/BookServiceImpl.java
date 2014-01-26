package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookDao;
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
    public List<Book> list() throws BusinessLogicException {
        try{
            return bookDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Book> listByPartOfName(String partOfName) throws BusinessLogicException {
        try{
            return bookDao.listByPartOfName(partOfName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Book> listByPartOfDescription(String partOfDescription) throws BusinessLogicException {
        try{
            return bookDao.listByPartOfDescription(partOfDescription);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
