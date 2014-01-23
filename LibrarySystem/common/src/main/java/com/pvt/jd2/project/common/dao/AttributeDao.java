package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Attribute;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:36
 */
public interface AttributeDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Attribute address) throws DatabaseException;

    void delete(Attribute address) throws DatabaseException;

    Attribute findById(Long id) throws DatabaseException;

    List<Attribute> list() throws DatabaseException;

    List<Attribute> findByPartOfCode(String partOfCode) throws DatabaseException;

    List<Attribute> findByPartOfDescription(String partOfDescription) throws DatabaseException;

}
