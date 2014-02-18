package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.BookExemplarUserHistoryDao;
import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.domain.metamodel.BookExemplarUserHistory_;
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
 * Date: 26.01.14
 * Time: 2:14
 */
@Repository
public class BookExemplarUserHistoryDaoImpl implements BookExemplarUserHistoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BookExemplarUserHistory bookUserHistory) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(bookUserHistory);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookExemplarUserHistory bookUserHistory) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookUserHistory);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookExemplarUserHistory findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookExemplarUserHistory)session.get(BookExemplarUserHistory.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookExemplarUserHistory.class);
    }

    @Override
    public List<BookExemplarUserHistory> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByBookExemplar(BookExemplar bookExemplar) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.BOOK_EXEMPLAR, bookExemplar));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByUser(User user) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.USER, user));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByInTime(boolean isInTime) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_IN_TIME, isInTime));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByInTime(User user, boolean isInTime) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.USER, user));
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_IN_TIME, isInTime));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByInTime(BookExemplar bookExemplar, boolean isInTime) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.BOOK_EXEMPLAR, bookExemplar));
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_IN_TIME, isInTime));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByContinued(boolean isContinued) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_CONTINUED, isContinued));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByContinued(User user, boolean isContinued) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.USER, user));
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_CONTINUED, isContinued));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByContinued(BookExemplar bookExemplar, boolean isContinued) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.BOOK_EXEMPLAR, bookExemplar));
            criteria.add(Restrictions.eq(BookExemplarUserHistory_.IS_CONTINUED, isContinued));
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUserHistory_.START_DATE, startDate, status);
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUserHistory_.END_DATE, endDate, status);
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUserHistory_.START_DATE, startDate, endDate);
            return (List<BookExemplarUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookExemplarUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookExemplarUserHistory_.END_DATE, startDate, endDate);
            return (List<BookExemplarUserHistory>)criteria.list();
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
