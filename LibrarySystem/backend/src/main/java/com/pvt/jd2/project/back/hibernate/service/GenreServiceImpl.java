package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:05
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    @Transactional
    public void create(Genre genre) throws BusinessLogicException {
        try{
            genreDao.create(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Genre genre) throws BusinessLogicException {
        try{
            genreDao.delete(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(Genre genre) throws BusinessLogicException {
        try{
            genreDao.update(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(Genre genre) throws BusinessLogicException {
        try{
            return genreDao.exists(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Genre findById(Long id) throws BusinessLogicException {
        try{
            return genreDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Genre> findFor(Book book) throws BusinessLogicException {
        try{
            return genreDao.findFor(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Genre> list() throws BusinessLogicException {
        try{
            return genreDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Genre> listLike(Genre genre) throws BusinessLogicException {
        try{
            return genreDao.listLike(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
