package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.MessageDao;
import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 22:45
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    @Transactional
    public void create(Message message) throws BusinessLogicException {
        try{
            messageDao.create(message);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(Message message) throws BusinessLogicException {
        try{
            messageDao.update(message);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(String code) throws BusinessLogicException {
        try{
            return messageDao.exists(code);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Message findBy(String code, Language language) throws BusinessLogicException {
        try{
            return messageDao.findBy(code, language);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
