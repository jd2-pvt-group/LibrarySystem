package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 01.03.14
 * Time: 0:07
*/
public interface LanguageService {

    List<Language> getLanguages() throws BusinessLogicException;

    Language findByShortName(String shortName) throws BusinessLogicException;

}
