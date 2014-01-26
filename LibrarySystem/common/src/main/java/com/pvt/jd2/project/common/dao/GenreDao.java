package com.pvt.jd2.project.common.dao;

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

    Genre findById(Long id) throws DatabaseException;

    List<Genre> list() throws DatabaseException;

    List<Genre> listByPartOfName(String partOfName) throws DatabaseException;

    List<Genre> listByPartOfDescription(String partOfDescription) throws DatabaseException;

}
