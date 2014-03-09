package com.pvt.jd2.project.install;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Message;
import com.pvt.jd2.project.common.service.LanguageService;
import com.pvt.jd2.project.common.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.UrlResource;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 02.03.14
 * Time: 0:15
 */
public class Main {

    private static LanguageService languageService;
    private static MessageService messageService;

    public static void main(String... args) throws IOException{
        if (args.length != 1){
            System.err.println("Folder should be specified.");
            System.exit(1);
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        languageService = context.getBean("languageService", LanguageService.class);
        messageService = context.getBean("messageService", MessageService.class);
        parseFolder(new File(args[0]));
        System.out.println("Finish.");
    }

    private static void parseFolder(File folder) throws IOException {
        File[] files = folder.listFiles();
        for(File file : files){
            parseFile(file);
        }
    }

    private static void parseFile(File file) throws IOException {
        Language language = getLanguage(file);
        if (language == null){
            return;
        }
        Properties prop = new Properties();
        prop.load(new UrlResource(file.toURI()).getInputStream());
        Enumeration codes = prop.propertyNames();
        while(codes.hasMoreElements()){
            String code = (String)codes.nextElement();
            String message = prop.getProperty(code);
            parseLine(language, code, message);
        }
    }

    private static Language getLanguage(File file){
        String name = file.getName();
        int index = name.indexOf('_');
        if (index == -1){
            return null;
        }
        int indexLast = name.indexOf('.');
        String shortName = name.substring(index+1, indexLast);
        return languageService.findByShortName(shortName);
    }

    private static void parseLine(Language language, String code, String message){
        Message msg = messageService.findBy(code, language);
        if (msg == null){
            Message newMsg = new Message();
            newMsg.setCode(code);
            newMsg.setMessage(message);
            newMsg.setLanguage(language);
            messageService.create(newMsg);
        } else{
            msg.setMessage(message);
            messageService.update(msg);
        }
    }

}
