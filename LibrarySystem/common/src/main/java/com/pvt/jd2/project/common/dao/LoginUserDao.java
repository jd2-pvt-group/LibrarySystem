package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.LoginUser;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:33
 */
public interface LoginUserDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(LoginUser address) throws DatabaseException;

    void delete(LoginUser address) throws DatabaseException;

    LoginUser findById(Long id) throws DatabaseException;

    List<LoginUser> list() throws DatabaseException;

}
