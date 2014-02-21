package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:31
 */
public interface AuthorDao {

    void create(Author author) throws DatabaseException;

    void delete(Author author) throws DatabaseException;

    void update(Author author) throws DatabaseException;

    boolean exists(Author author) throws DatabaseException;

    List<Author> list() throws DatabaseException;

    List<Author> listWithout(List<Author> authors) throws DatabaseException;

    Author findById(Long id) throws DatabaseException;

    List<Author> listLike(Author author) throws DatabaseException;

    List<Author> findFor(Book book) throws DatabaseException;

}
