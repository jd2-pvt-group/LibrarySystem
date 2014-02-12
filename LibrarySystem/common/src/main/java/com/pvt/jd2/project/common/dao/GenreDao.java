package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:19
 */
public interface GenreDao {

    void create(Genre genre) throws DatabaseException;

    void delete(Genre genre) throws DatabaseException;

    void update(Genre genre) throws DatabaseException;

    boolean exists(Genre genre) throws DatabaseException;

    Genre findById(Long id) throws DatabaseException;

    List<Genre> findFor(Book book) throws DatabaseException;

    List<Genre> list() throws DatabaseException;

    List<Genre> listLike(Genre genre) throws DatabaseException;

}
