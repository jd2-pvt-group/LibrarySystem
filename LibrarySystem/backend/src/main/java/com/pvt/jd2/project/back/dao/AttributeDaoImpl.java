package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.AttributeDao;
import com.pvt.jd2.project.common.domain.Attribute;
import com.pvt.jd2.project.common.domain.metamodel.Attribute_;
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
 * Date: 22.01.14
 * Time: 15:41
 */
public class AttributeDaoImpl implements AttributeDao {

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
    public void create(Attribute address) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Attribute address) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Attribute findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Attribute)session.get(Attribute.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Attribute> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Attribute.class);
            return (List<Attribute>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Attribute> findByPartOfCode(String partOfCode) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Attribute.class);
            criteria.add(Restrictions.like(Attribute_.CODE, partOfCode));
            return (List<Attribute>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Attribute> findByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Attribute.class);
            criteria.add(Restrictions.like(Attribute_.DESCRIPTION, partOfDescription));
            return (List<Attribute>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
