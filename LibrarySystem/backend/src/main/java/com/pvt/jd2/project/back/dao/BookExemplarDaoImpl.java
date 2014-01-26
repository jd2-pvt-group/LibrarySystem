package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookExemplarDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.domain.metamodel.BookExemplar_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 21:42
 */
@Repository
public class BookExemplarDaoImpl implements BookExemplarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(bookExemplar);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookExemplar);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void activate(BookExemplar bookExemplar) throws DatabaseException {
        try{
            if (!bookExemplar.isActive()){
                bookExemplar.setActive(true);
                Session session = sessionFactory.getCurrentSession();
                session.merge(bookExemplar);
            }
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void deactivate(BookExemplar bookExemplar) throws DatabaseException {
        try{
            if (bookExemplar.isActive()){
                bookExemplar.setActive(false);
                Session session = sessionFactory.getCurrentSession();
                session.merge(bookExemplar);
            }
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookExemplar findByBookExemplarId(BookExemplarId bookExemplarId) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookExemplar)session.get(BookExemplar.class, bookExemplarId);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookExemplar.class);
    }

    private void updateCriteria(Criteria criteria, ActivationStatus status){
        switch (status){
            case INACTIVE:
                criteria.add(Restrictions.eq(BookExemplar_.IS_ACTIVE, false));
                break;
            case ACTIVE:
                criteria.add(Restrictions.eq(BookExemplar_.IS_ACTIVE, true));
                break;
        }
    }

    @Override
    public List<BookExemplar> listByBook(Book book, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplar_.BOOK, book));
            updateCriteria(criteria, status);
            return (List<BookExemplar>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplar> list(ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, status);
            return (List<BookExemplar>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
