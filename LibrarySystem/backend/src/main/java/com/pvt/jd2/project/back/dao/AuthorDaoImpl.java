package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:39
 */
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public boolean create(Author address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Author address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Author> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}