package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(Genre genre) throws BusinessLogicException {
        try{
            genreDao.create(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(Genre genre) throws BusinessLogicException {
        try{
            genreDao.delete(genre);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Genre findById(Long id) throws BusinessLogicException {
        try{
            return genreDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Genre> list() throws BusinessLogicException {
        try{
            return genreDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Genre> listByPartOfName(String partOfName) throws BusinessLogicException {
        try{
            return genreDao.listByPartOfName(partOfName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Genre> listByPartOfDescription(String partOfDescription) throws BusinessLogicException {
        try{
            return genreDao.listByPartOfDescription(partOfDescription);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
