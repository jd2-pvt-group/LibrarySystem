package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookSerialDao;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.domain.metamodel.BookSerial_;
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
 * Time: 20:54
 */
public class BookSerialDaoImpl implements BookSerialDao{

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
    public void create(BookSerial bookSerial) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(bookSerial);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookSerial bookSerial) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookSerial);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookSerial findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookSerial)session.get(BookSerial.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookSerial.class);
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> findByPartOfName(String partOfName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookSerial.class);
            criteria.add(Restrictions.like(BookSerial_.NAME, partOfName));
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> findByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookSerial.class);
            criteria.add(Restrictions.like(BookSerial_.DESCRIPTION, partOfDescription));
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
