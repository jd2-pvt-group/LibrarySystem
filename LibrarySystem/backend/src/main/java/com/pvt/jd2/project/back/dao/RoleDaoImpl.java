package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.RoleDao;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:43
 */
public class RoleDaoImpl implements RoleDao {
    @Override
    public boolean create(Role address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Role address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Role> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
