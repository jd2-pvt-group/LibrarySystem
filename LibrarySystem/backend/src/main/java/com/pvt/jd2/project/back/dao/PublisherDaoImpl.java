package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.PublisherDao;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:41
 */
public class PublisherDaoImpl implements PublisherDao {
    @Override
    public boolean create(Publisher address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Publisher address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Publisher> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}