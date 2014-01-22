package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:32
 */
public interface BookSerialDao {

    boolean create(BookSerial address) throws DatabaseException;

    boolean delete(BookSerial address) throws DatabaseException;

    List<BookSerial> list() throws DatabaseException;

}
