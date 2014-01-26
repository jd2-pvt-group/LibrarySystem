package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:42
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorsDao;

    @Override
    @Transactional
    public Author findById(Long id) throws BusinessLogicException {
        try{
            return authorsDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void create(Author author) throws BusinessLogicException {
        try{
            authorsDao.create(author);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Author author) throws BusinessLogicException {
        try{
            authorsDao.delete(author);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Author> list() throws BusinessLogicException {
        try{
            return authorsDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Author> listByFirstName(String firstName) throws BusinessLogicException {
        try{
            return authorsDao.listByPartOfFirstName(firstName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Author> listByLastName(String lastName) throws BusinessLogicException {
        try{
            return authorsDao.listByPartOfLastName(lastName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
