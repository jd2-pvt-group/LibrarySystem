package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.PermissionDao;
import com.pvt.jd2.project.common.dao.PublisherDao;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(Publisher publisher) throws BusinessLogicException {
        try{
            publisherDao.create(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(Publisher publisher) throws BusinessLogicException {
        try{
            publisherDao.delete(publisher);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Publisher findById(Long id) throws BusinessLogicException {
        try{
            return publisherDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Publisher> list() throws BusinessLogicException {
        try{
            return publisherDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Publisher> listByPartOfName(String partOfName) throws BusinessLogicException {
        try{
            return publisherDao.listByPartOfName(partOfName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Publisher> listByPartOfAddress(String partOfAddress) throws BusinessLogicException {
        try{
            return publisherDao.listByPartOfAddress(partOfAddress);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
