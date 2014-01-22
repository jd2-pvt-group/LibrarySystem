package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.LoginUser;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:33
 */
public interface LoginUserDao {

    boolean create(LoginUser address) throws DatabaseException;

    boolean delete(LoginUser address) throws DatabaseException;

    List<LoginUser> list() throws DatabaseException;

}
