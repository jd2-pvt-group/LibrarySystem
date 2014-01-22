package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:33
 */
public interface PublisherDao {

    boolean create(Publisher address) throws DatabaseException;

    boolean delete(Publisher address) throws DatabaseException;

    List<Publisher> list() throws DatabaseException;

}
