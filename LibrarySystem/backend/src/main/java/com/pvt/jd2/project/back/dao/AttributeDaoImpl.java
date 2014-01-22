package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.AttributeDao;
import com.pvt.jd2.project.common.domain.Attribute;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:41
 */
public class AttributeDaoImpl implements AttributeDao {
    @Override
    public boolean create(Attribute address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Attribute address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Attribute> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
