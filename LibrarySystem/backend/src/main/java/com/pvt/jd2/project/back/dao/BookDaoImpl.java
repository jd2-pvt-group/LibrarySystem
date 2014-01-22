package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:42
 */
public class BookDaoImpl implements BookDao {
    @Override
    public boolean create(Book address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Book address) throws DatabaseException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Book> list() throws DatabaseException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
