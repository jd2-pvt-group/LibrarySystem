package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookUserHistoryDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookUserHistory;
import com.pvt.jd2.project.common.domain.ComparisonStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.BookUserHistory_;
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
public class BookUserHistoryDaoImpl implements BookUserHistoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BookUserHistory bookUserHistory) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(bookUserHistory);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(BookUserHistory bookUserHistory) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(bookUserHistory);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public BookUserHistory findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (BookUserHistory)session.get(BookUserHistory.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(BookUserHistory.class);
    }

    @Override
    public List<BookUserHistory> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByBook(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.BOOK, book));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByUser(User user) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.USER, user));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByInTime(boolean isInTime) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.IS_IN_TIME, isInTime));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByInTime(User user, boolean isInTime) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.USER, user));
            criteria.add(Restrictions.eq(BookUserHistory_.IS_IN_TIME, isInTime));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByContinued(boolean isContinued) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.IS_CONTINUED, isContinued));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByContinued(User user, boolean isContinued) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(BookUserHistory_.USER, user));
            criteria.add(Restrictions.eq(BookUserHistory_.IS_CONTINUED, isContinued));
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByStartDate(Date startDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookUserHistory_.START_DATE, startDate, status);
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByEndDate(Date endDate, ComparisonStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookUserHistory_.END_DATE, endDate, status);
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByStartDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookUserHistory_.START_DATE, startDate, endDate);
            return (List<BookUserHistory>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<BookUserHistory> listByEndDateBetween(Date startDate, Date endDate) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteria(criteria, BookUserHistory_.END_DATE, startDate, endDate);
            return (List<BookUserHistory>)criteria.list();
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
