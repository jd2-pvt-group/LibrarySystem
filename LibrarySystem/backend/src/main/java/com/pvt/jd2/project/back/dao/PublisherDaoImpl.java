package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.PublisherDao;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.domain.metamodel.Publisher_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 21:08
 */
public class PublisherDaoImpl implements PublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void create(Publisher publisher) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(publisher);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Publisher publisher) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(publisher);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Publisher findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Publisher)session.get(Publisher.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Publisher> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Publisher.class);
            return (List<Publisher>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Publisher> findByPartOfName(String partOfName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Publisher.class);
            criteria.add(Restrictions.like(Publisher_.NAME, partOfName));
            return (List<Publisher>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Publisher> findByPartOfAddress(String partOfAddress) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Publisher.class);
            criteria.add(Restrictions.like(Publisher_.ADDRESS, partOfAddress));
            return (List<Publisher>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
