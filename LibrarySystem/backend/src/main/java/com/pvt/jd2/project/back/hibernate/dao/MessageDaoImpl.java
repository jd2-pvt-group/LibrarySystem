package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.MessageDao;
import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.domain.metamodel.Message_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 01.03.14
 * Time: 22:39
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Message.class);
    }

    @Override
    public void create(Message message) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(message);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(Message message) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(message);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(String code) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Message_.CODE, code));
            return criteria.list().size() != 0;
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Message findBy(String code, Language language) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Message_.CODE, code));
            criteria.add(Restrictions.eq(Message_.LANGUAGE, language));
            return (Message)criteria.uniqueResult();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }
}
