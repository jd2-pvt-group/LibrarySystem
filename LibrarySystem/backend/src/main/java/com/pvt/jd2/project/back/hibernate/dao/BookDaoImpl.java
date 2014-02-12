package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.BookDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.metamodel.Book_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 19:48
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Book book) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(book);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Book book) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(book);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Book_.ISBN, book.getIsbn()));
            return criteria.uniqueResult() == null ? false : true;
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Book findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Book)session.get(Book.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Book findByIdFull(Long id) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Book_.ID, id));
            criteria.setFetchMode(Book_.PUBLISHER, FetchMode.DEFAULT);
            criteria.setFetchMode(Book_.BOOK_SERIAL, FetchMode.DEFAULT);
            return (Book)criteria.uniqueResult();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Book.class);
    }

    @Override
    public Book findByIsbn(String isbn) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Book_.ISBN, isbn));
            List<Book> books = (List<Book>)criteria.list();
            return books.isEmpty() ? null : books.get(0);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Book>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> listLike(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!book.getName().isEmpty()){
                criteria.add(Restrictions.like(Book_.NAME, book.getName(), MatchMode.ANYWHERE));
            }
            if (!book.getDescription().isEmpty()){
                criteria.add(Restrictions.like(Book_.DESCRIPTION, book.getDescription(), MatchMode.ANYWHERE));
            }
            if (!book.getIsbn().isEmpty()){
                criteria.add(Restrictions.like(Book_.ISBN, book.getIsbn(), MatchMode.ANYWHERE));
            }
            return (List<Book>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
