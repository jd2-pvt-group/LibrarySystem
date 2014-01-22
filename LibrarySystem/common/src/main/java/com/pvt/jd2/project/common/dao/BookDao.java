package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:36
 */
public interface BookDao {

    boolean create(Book address) throws DatabaseException;

    boolean delete(Book address) throws DatabaseException;

    List<Book> list() throws DatabaseException;

}
