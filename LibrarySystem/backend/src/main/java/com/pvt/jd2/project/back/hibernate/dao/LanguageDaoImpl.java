package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.LanguageDao;
import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.metamodel.Language_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 01.03.14
 * Time: 0:08
 */
@Repository
public class LanguageDaoImpl implements LanguageDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Language.class);
    }

    @Override
    public List<Language> getLanguages() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Language>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Language findByShortName(String shortName) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Language_.SHORT_NAME, shortName));
            return (Language)criteria.uniqueResult();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }
}
