package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:33
 */
public interface GenreDao {

    boolean create(Genre address) throws DatabaseException;

    boolean delete(Genre address) throws DatabaseException;

    List<Genre> list() throws DatabaseException;

}
