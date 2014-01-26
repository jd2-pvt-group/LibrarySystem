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
    public Book findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Book)session.get(Book.class, id);
        }catch(Exception e){
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
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> listByPartOfName(String partOfName) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(Book_.NAME, partOfName));
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Book> listByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();;
            criteria.add(Restrictions.like(Book_.DESCRIPTION, partOfDescription));
            return (List<Book>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
