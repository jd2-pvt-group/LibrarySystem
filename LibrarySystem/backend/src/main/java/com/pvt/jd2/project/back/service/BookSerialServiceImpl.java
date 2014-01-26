package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.BookSerialDao;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.BookSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:51
 */
@Service
public class BookSerialServiceImpl implements BookSerialService{

    @Autowired
    private BookSerialDao bookSerialDao;

    @Override
    @Transactional
    public void create(BookSerial bookSerial) throws BusinessLogicException {
        try{
            bookSerialDao.create(bookSerial);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(BookSerial bookSerial) throws BusinessLogicException {
        try{
            bookSerialDao.delete(bookSerial);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public BookSerial findById(Long id) throws BusinessLogicException {
        try{
            return bookSerialDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookSerial> list() throws BusinessLogicException {
        try{
            return bookSerialDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookSerial> listByPartOfName(String partOfName) throws BusinessLogicException {
        try{
            return bookSerialDao.listByPartOfName(partOfName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<BookSerial> listByPartOfDescription(String partOfDescription) throws BusinessLogicException {
        try{
            return bookSerialDao.listByPartOfDescription(partOfDescription);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
