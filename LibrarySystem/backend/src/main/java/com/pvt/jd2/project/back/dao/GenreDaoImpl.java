package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.domain.metamodel.Genre_;
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
 * Time: 22:24
 */
@Repository
public class GenreDaoImpl implements GenreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Genre genre) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(genre);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Genre genre) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(genre);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Genre findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Genre)session.get(Genre.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Genre.class);
    }

    @Override
    public List<Genre> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Genre>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Genre> listByPartOfName(String partOfName) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(Genre_.NAME, partOfName));
            return (List<Genre>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Genre> listByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(Genre_.DESCRIPTION, partOfDescription));
            return (List<Genre>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
