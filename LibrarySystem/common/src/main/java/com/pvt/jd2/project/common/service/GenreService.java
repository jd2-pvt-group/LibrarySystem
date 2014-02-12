package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:45
 */
public interface GenreService {

    void create(Genre genre) throws BusinessLogicException;

    void delete(Genre genre) throws BusinessLogicException;

    void update(Genre genre) throws BusinessLogicException;

    boolean exists(Genre genre) throws BusinessLogicException;

    Genre findById(Long id) throws BusinessLogicException;

    List<Genre> findFor(Book book) throws BusinessLogicException;

    List<Genre> list() throws BusinessLogicException;

    List<Genre> listLike(Genre genre) throws BusinessLogicException;

}
