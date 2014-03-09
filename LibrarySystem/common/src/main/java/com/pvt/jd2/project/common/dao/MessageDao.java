package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 22:32
 */
public interface MessageDao {

    void create(Message message) throws DatabaseException;

    void update(Message message) throws DatabaseException;

    boolean exists(String code) throws DatabaseException;

    Message findBy(String code, Language language) throws DatabaseException;

}
