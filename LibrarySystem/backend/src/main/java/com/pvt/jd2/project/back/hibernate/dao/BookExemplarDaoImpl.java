package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.BookExemplarDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.domain.metamodel.BookExemplar_;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookExemplar);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(bookExemplar);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (bookExemplar.getId() != null){
                criteria.add(Restrictions.ne(BookExemplar_.ID, bookExemplar.getId()));
            }
            criteria.add(Restrictions.eq(BookExemplar_.BOOK, bookExemplar.getBook()));
            criteria.add(Restrictions.eq(BookExemplar_.LIBRARY_CODE, bookExemplar.getLibraryCode()));
            return criteria.uniqueResult() == null ? false : true;
        }catch(HibernateException e){
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
        }catch(HibernateException e){
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookExemplar findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookExemplar)session.get(BookExemplar.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplar> listBy(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplar_.BOOK, book));
            return (List<BookExemplar>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookExemplar.class);
    }

    private void updateCriteria(Junction junction, ActivationStatus status){
        switch (status){
            case INACTIVE:
                junction.add(Restrictions.eq(BookExemplar_.IS_ACTIVE, false));
                break;
            case ACTIVE:
                junction.add(Restrictions.eq(BookExemplar_.IS_ACTIVE, true));
                break;
        }
    }

    @Override
    public List<BookExemplar> listBy(Book book, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            Conjunction and = Restrictions.conjunction();
            and.add(Restrictions.eq(BookExemplar_.BOOK, book));
            if (status != ActivationStatus.NONE){
                updateCriteria(and, status);
            }
            criteria.add(and);
            return (List<BookExemplar>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplar> list(ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            Conjunction and = Restrictions.conjunction();
            boolean hasOperation = false;
            if (status != ActivationStatus.NONE){
                hasOperation = true;
                updateCriteria(and, status);
            }
            if (hasOperation){
                criteria.add(and);
                return (List<BookExemplar>)criteria.list();
            }else{
                return new ArrayList<BookExemplar>(0);
            }
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplar> listLike(BookExemplar bookExemplar, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            Disjunction or = Restrictions.disjunction();
            boolean hasOperation = false;
            if (status != ActivationStatus.NONE){
                hasOperation = true;
                updateCriteria(or, status);
            }
            if (!bookExemplar.getLibraryCode().isEmpty()){
                hasOperation = true;
                or.add(Restrictions.like(BookExemplar_.LIBRARY_CODE, bookExemplar.getLibraryCode(), MatchMode.ANYWHERE));
            }
            if (hasOperation){
                criteria.add(or);
                return (List<BookExemplar>)criteria.list();
            }else{
                return new ArrayList<BookExemplar>(0);
            }
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
