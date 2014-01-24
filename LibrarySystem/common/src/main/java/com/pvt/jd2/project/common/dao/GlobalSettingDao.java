package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.GlobalSetting;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;
import org.hibernate.id.enhanced.DatabaseStructure;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:36
 */
public interface GlobalSettingDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    GlobalSetting findByName(String name) throws DatabaseException;

    List<GlobalSetting> list() throws DatabaseException;

}
