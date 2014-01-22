package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:32
 */
public interface AuthorDao {

    boolean create(Author address) throws DatabaseException;

    boolean delete(Author address) throws DatabaseException;

    List<Author> list() throws DatabaseException;

}
