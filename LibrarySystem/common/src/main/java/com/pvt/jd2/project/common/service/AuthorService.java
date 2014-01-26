package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:34
 */
public interface AuthorService {

    Author findById(Long id) throws BusinessLogicException;

    void create(Author author) throws BusinessLogicException;

    void delete(Author author) throws BusinessLogicException;

    List<Author> list() throws BusinessLogicException;

    List<Author> listByFirstName(String firstName) throws BusinessLogicException;

    List<Author> listByLastName(String lastName) throws BusinessLogicException;

}
