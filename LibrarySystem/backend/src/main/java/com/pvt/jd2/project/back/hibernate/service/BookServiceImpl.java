package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
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

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private GenreDao genreDao;

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
    public void update(Book book) throws BusinessLogicException {
        try{
            bookDao.update(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(Book book) throws BusinessLogicException {
        try{
            return bookDao.exists(book);
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
    public Book findByIdFull(Long id) throws BusinessLogicException {
        try{
            Book book = bookDao.findByIdFull(id);
            if (book == null){
                return null;
            }
            List<Author> authors = authorDao.findFor(book);
            List<Genre> genres = genreDao.findFor(book);
            book.setAuthors(authors);
            book.setGenres(genres);
            return book;
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
    public List<Book> listLike(Book book) throws BusinessLogicException {
        try{
            return bookDao.listLike(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
