package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:37
 */
public interface UserDao {

    boolean create(User address) throws DatabaseException;

    boolean delete(User address) throws DatabaseException;

    List<User> list() throws DatabaseException;

}
