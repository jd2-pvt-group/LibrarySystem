package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:40
 */
public class GenreDaoImpl implements GenreDao {
    @Override
    public boolean create(Genre address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Genre address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Genre> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
