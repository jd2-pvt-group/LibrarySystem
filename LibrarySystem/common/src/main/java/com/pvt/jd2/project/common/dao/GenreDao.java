package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:19
 */
public interface GenreDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Genre genre) throws DatabaseException;

    void delete(Genre genre) throws DatabaseException;

    Genre findById(Long id) throws DatabaseException;

    List<Genre> list() throws DatabaseException;

    List<Genre> findByPartOfName(String partOfName) throws DatabaseException;

    List<Genre> findByPartOfDescription(String partOfDescription) throws DatabaseException;

}
