package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:33
 */
public interface GenreDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSetSessionFactory();

    void create(Genre address) throws DatabaseException;

    void delete(Genre address) throws DatabaseException;

    Genre findById(Long id) throws DatabaseException;

    List<Genre> findByPartOfName(String partOfName) throws DatabaseException;

    List<Genre> list() throws DatabaseException;

}
