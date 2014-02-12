package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:34
 */
public interface AuthorService {

    Author findById(Long id) throws BusinessLogicException;

    List<Author> findFor(Book book) throws BusinessLogicException;

    void create(Author author) throws BusinessLogicException;

    void delete(Author author) throws BusinessLogicException;

    void update(Author author) throws BusinessLogicException;

    boolean exists(Author author) throws BusinessLogicException;

    List<Author> list() throws BusinessLogicException;

    List<Author> listLike(Author author) throws BusinessLogicException;

}
