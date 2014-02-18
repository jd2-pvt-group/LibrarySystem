package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.PublisherDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.domain.metamodel.Publisher_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 21:08
 */
@Repository
public class PublisherDaoImpl implements PublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Publisher publisher) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(publisher);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Publisher publisher) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(publisher);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(Publisher publisher) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(publisher);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(Publisher publisher) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (publisher.getId() != null){
                criteria.add(Restrictions.ne(Publisher_.ID, publisher.getId()));
            }
            criteria.add(Restrictions.eq(Publisher_.NAME, publisher.getName()));
            return criteria.uniqueResult() == null ? false : true;
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Publisher findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Publisher)session.get(Publisher.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Publisher findFor(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(Publisher_.BOOKS, Publisher_.BOOK);
            criteria.add(Restrictions.eq(Publisher_.BOOK_ID, book.getId()));
            List<Publisher> books = (List<Publisher>)criteria.list();
            return books.isEmpty() ? null : books.get(0);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Publisher.class);
    }

    @Override
    public List<Publisher> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Publisher>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Publisher> listLike(Publisher publisher) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            Disjunction or = Restrictions.disjunction();
            boolean hasOperation = false;
            if (!publisher.getName().isEmpty()){
                hasOperation = true;
                or.add(Restrictions.like(Publisher_.NAME, publisher.getName(), MatchMode.ANYWHERE));
            }
            if (!publisher.getAddress().isEmpty()){
                hasOperation = true;
                or.add(Restrictions.like(Publisher_.ADDRESS, publisher.getAddress(), MatchMode.ANYWHERE));
            }
            if (hasOperation){
                criteria.add(or);
                return (List<Publisher>)criteria.list();
            }else{
                return new ArrayList<Publisher>(0);
            }
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
