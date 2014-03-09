package com.pvt.jd2.project.front.support;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.service.LanguageService;
import com.pvt.jd2.project.common.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 22:12
 */
public class DatabaseResourceBundle extends AbstractMessageSource {

    @Autowired
    private LanguageService languageService;

    @Autowired
    private MessageService messageService;

    private final Map<Locale, Map<String, String>> CACHE = new HashMap<Locale, Map<String, String>>();

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        if (!messageService.exists(code)){
            return null;
        }
        String message = null;
        if (existsInCache(code, locale)){
            message = getMessageFromCache(code, locale);
        }else{
            message = getMessageFromDatabase(code, locale);
        }
        return  createMessageFormat(message, locale);
    }

    private boolean existsInCache(String code, Locale locale){
        if (CACHE.containsKey(locale)){
            Map<String, String> cacheLocal = CACHE.get(locale);
            if (cacheLocal.containsKey(code)){
                return true;
            }
        }
        return false;
    }

    private String getMessageFromCache(String code, Locale locale){
        return CACHE.get(locale).get(code);
    }

    private String getMessageFromDatabase(String code, Locale locale){
        Language language = languageService.findByShortName(locale.getLanguage());
        Message message = messageService.findBy(code, language);
        String result = message == null ? null : message.getMessage();
        putToCache(code, result, locale);
        return result;
    }

    private void putToCache(String code, String message, Locale locale){
        if (!CACHE.containsKey(locale)){
            CACHE.put(locale, new HashMap<String, String>());
        }
        CACHE.get(locale).put(code, message);
    }

}
