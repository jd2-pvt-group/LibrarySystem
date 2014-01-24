package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:00
 */
public interface PermissionDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Permission permission) throws DatabaseException;

    void delete(Permission permission) throws DatabaseException;

    Permission findById(Long id) throws DatabaseException;

    Permission findByCode(String code) throws DatabaseException;

    List<Permission> list() throws DatabaseException;

    List<Permission> findByPartOfCode(String partOfCode) throws DatabaseException;

    List<Permission> findByPartOfDescription(String partOfDescription) throws DatabaseException;

}
