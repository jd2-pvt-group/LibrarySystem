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
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 20:54
 */
@Repository
public class BookSerialDaoImpl implements BookSerialDao{

    @Autowired
    private SessionFactory sessionFactory;

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

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookSerial.class);
    }

    @Override
    public List<BookSerial> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> listByPartOfName(String partOfName) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(BookSerial_.NAME, partOfName));
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> listByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(BookSerial_.DESCRIPTION, partOfDescription));
            return (List<BookSerial>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
