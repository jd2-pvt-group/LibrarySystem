package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:00
 */
public interface RoleDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Role role) throws DatabaseException;

    void delete(Role role) throws DatabaseException;

    Role findById(Long id) throws DatabaseException;

    Role findByName(String name) throws DatabaseException;

    List<Role> list() throws DatabaseException;

    List<Role> findByPartOfName(String partOfName) throws DatabaseException;

    List<Role> findByPartOfDescription(String partOfDescription) throws DatabaseException;

}
