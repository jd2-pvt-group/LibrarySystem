package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.LoginUserDao;
import com.pvt.jd2.project.common.domain.LoginUser;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:40
 */
public class LoginUserDaoImpl implements LoginUserDao{
    @Override
    public boolean create(LoginUser address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(LoginUser address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<LoginUser> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
