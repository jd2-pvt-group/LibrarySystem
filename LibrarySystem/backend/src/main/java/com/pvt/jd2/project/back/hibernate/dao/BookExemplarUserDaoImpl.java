package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.BookExemplarUserDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.domain.metamodel.BookExemplarUser_;
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
public class BookExemplarUserDaoImpl implements BookExemplarUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BookExemplarUser bookUser) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(bookUser);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(BookExemplarUser bookUser) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.merge(bookUser);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookExemplarUser bookUser) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookUser);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookExemplarUser findByBookExemplar(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookExemplarUser)session.get(BookExemplarUser.class, bookExemplar.getId());
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookExemplarUser.class);
    }


    @Override
    public List<BookExemplarUser> list() throws DatabaseException{
        try{
            Criteria criteria = createCriteria();
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByUser(User user) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUser_.USER, user));
            return (List<BookExemplarUser>)criteria.list();
        }catch (Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByDebt() throws DatabaseException {
        try{
            Date date = new Date();
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.lt(BookExemplarUser_.END_DATE, date));
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByDebtUser(User user) throws DatabaseException {
        try{
            Date date = new Date();
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUser_.USER, user));
            criteria.add(Restrictions.lt(BookExemplarUser_.END_DATE, date));
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByIsContinued() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUser_.IS_CONTINUED, true));
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByIsContinued(User user) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUser_.USER, user));
            criteria.add(Restrictions.eq(BookExemplarUser_.IS_CONTINUED, true));
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUser_.START_DATE, startDate, status);
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUser_.END_DATE, endDate, status);
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUser_.START_DATE, startDate, endDate);
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUser> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUser_.END_DATE, startDate, endDate);
            return (List<BookExemplarUser>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private void updateCriteria(Criteria criteria, String field, Date startDate, Date endDate){
        criteria.add(Restrictions.between(field, startDate, endDate));
    }

    private void updateCriteria(Criteria criteria, String field, Date date, ComparisonStatus status) {
        switch (status){
            case EQ:
                criteria.add(Restrictions.eq(field, date));
                break;
            case GE:
                criteria.add(Restrictions.ge(field, date));
                break;
            case GT:
                criteria.add(Restrictions.gt(field, date));
                break;
            case LE:
                criteria.add(Restrictions.le(field, date));
                break;
            case LT:
                criteria.add(Restrictions.lt(field, date));
                break;
        }
    }

}
