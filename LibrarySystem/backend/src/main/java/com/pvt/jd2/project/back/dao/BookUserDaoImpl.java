package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookUserDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUser;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.BookUser_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 1:07
  */
@Repository
public class BookUserDaoImpl implements BookUserDao {

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
    public BookUser findByBook(Book book) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookUser)session.get(BookUser.class, book.getId());
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> list() throws DatabaseException{
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            return (List<BookUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> findByUser(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            criteria.add(Restrictions.eq(BookUser_.USER_ID, user.getId()));
            return (List<BookUser>)criteria.list();
        }catch (Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> findByDebt() throws DatabaseException {
        try{
            Date date = new Date();
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            criteria.add(Restrictions.lt(BookUser_.END_DATE, date));
            return (List<BookUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> findByDebtUser(User user) throws DatabaseException {
        try{
            Date date = new Date();
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            criteria.add(Restrictions.eq(BookUser_.USER_ID, user.getId()));
            criteria.add(Restrictions.lt(BookUser_.END_DATE, date));
            return (List<BookUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> findByIsContinued() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            criteria.add(Restrictions.eq(BookUser_.IS_CONTINUED, true));
            return (List<BookUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUser> findByIsContinued(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(BookUser.class);
            criteria.add(Restrictions.eq(BookUser_.USER_ID, user.getId()));
            criteria.add(Restrictions.eq(BookUser_.IS_CONTINUED, true));
            return (List<BookUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
