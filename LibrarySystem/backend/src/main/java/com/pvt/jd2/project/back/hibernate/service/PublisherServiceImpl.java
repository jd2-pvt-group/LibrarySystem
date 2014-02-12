package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.PublisherDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:18
 */
@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherDao publisherDao;

    @Override
    @Transactional
    public void create(Publisher publisher) throws BusinessLogicException {
        try{
            publisherDao.create(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Publisher publisher) throws BusinessLogicException {
        try{
            publisherDao.delete(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(Publisher publisher) throws BusinessLogicException {
        try{
            publisherDao.update(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(Publisher publisher) throws BusinessLogicException {
        try{
            return publisherDao.exists(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Publisher findById(Long id) throws BusinessLogicException {
        try{
            return publisherDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Publisher findFor(Book book) throws BusinessLogicException {
        try{
            return publisherDao.findFor(book);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Publisher> list() throws BusinessLogicException {
        try{
            return publisherDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Publisher> listLike(Publisher publisher) throws BusinessLogicException {
        try{
            return publisherDao.listLike(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
