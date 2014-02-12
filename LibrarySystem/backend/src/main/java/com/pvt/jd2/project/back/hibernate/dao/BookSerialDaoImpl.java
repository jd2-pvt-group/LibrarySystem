package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.BookSerialDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.domain.metamodel.BookSerial_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookSerial bookSerial) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookSerial);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(BookSerial bookSerial) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(bookSerial);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(BookSerial bookSerial) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookSerial_.NAME, bookSerial.getName()));
            return criteria.uniqueResult() == null ? false : true;
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookSerial findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookSerial)session.get(BookSerial.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookSerial findFor(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(BookSerial_.BOOKS, BookSerial_.BOOK);
            criteria.add(Restrictions.eq(BookSerial_.BOOK_ID, book.getId()));
            List<BookSerial> bookSerials = (List<BookSerial>)criteria.list();
            return bookSerials.isEmpty() ? null : bookSerials.get(0);
        }catch(HibernateException e){
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookSerial> listLike(BookSerial bookSerial) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!bookSerial.getName().isEmpty()){
                criteria.add(Restrictions.like(BookSerial_.NAME, bookSerial.getName(), MatchMode.ANYWHERE));
            }
            if (!bookSerial.getDescription().isEmpty()){
                criteria.add(Restrictions.like(BookSerial_.DESCRIPTION, bookSerial.getDescription(), MatchMode.ANYWHERE));
            }
            return (List<BookSerial>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
