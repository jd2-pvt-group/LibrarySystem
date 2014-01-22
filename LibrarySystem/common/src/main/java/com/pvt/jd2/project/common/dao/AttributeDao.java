package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Attribute;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:36
 */
public interface AttributeDao {

    boolean create(Attribute address) throws DatabaseException;

    boolean delete(Attribute address) throws DatabaseException;

    List<Attribute> list() throws DatabaseException;

}
