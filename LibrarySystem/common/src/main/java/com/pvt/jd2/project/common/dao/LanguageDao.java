package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 0:06
 */
public interface LanguageDao {

    List<Language> getLanguages() throws DatabaseException;

    Language findByShortName(String shortName) throws DatabaseException;

}
