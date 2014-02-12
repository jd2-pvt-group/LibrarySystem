package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:42
 */
public interface BookService {

    void create(Book book) throws BusinessLogicException;

    void delete(Book book) throws BusinessLogicException;

    boolean exists(Book book) throws BusinessLogicException;

    Book findById(Long id) throws BusinessLogicException;

    Book findByIdFull(Long id) throws BusinessLogicException;

    Book findByIsbn(String isbn) throws BusinessLogicException;

    List<Book> list() throws BusinessLogicException;

    List<Book> listLike(Book book) throws BusinessLogicException;

}
