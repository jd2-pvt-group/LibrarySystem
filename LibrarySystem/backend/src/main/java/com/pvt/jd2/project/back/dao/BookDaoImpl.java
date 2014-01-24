package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.metamodel.Book_;
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
 * Time: 19:48
 */
public class BookDaoImpl implements BookDao {

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
    public void create(Book book) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(book);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Book book) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(book);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void activate(Book book) throws DatabaseException {
        try{
            if (!book.isActive()){
                updateActiveStatus(book, true);
            }
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void deactivate(Book book) throws DatabaseException {
        try{
            if (book.isActive()){
                updateActiveStatus(book, false);
            }
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private void updateActiveStatus(Book book, boolean isActive) {
        book.setActive(false);
        Session session = sessionFactory.getCurrentSession();
        session.merge(book);
    }

    @Override
    public Book findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Book)session.get(Book.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Book findByIsbn(String isbn) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq(Book_.ISBN, isbn));
            List<Book> books = (List<Book>)criteria.list();
            return books.isEmpty() ? null : books.get(0);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> list(ActivationStatus status) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Book.class);
            updateCriteriaForStatus(criteria, status);
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> findByPartOfName(String partOfName, ActivationStatus status) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Book.class);
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.like(Book_.NAME, partOfName));
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> findByPartOfDescription(String partOfDescription, ActivationStatus status) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Book.class);
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.like(Book_.DESCRIPTION, partOfDescription));
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private void updateCriteriaForStatus(Criteria criteria, ActivationStatus status) {
        switch (status){
            case ACTIVE:
                criteria.add(Restrictions.eq(Book_.IS_ACTIVE, true));
                break;
            case INACTIVE:
                criteria.add(Restrictions.eq(Book_.IS_ACTIVE, false));
                break;
        }
    }

}
