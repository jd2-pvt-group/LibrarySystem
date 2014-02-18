package com.pvt.jd2.project.front.controllers.sections.library.book;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.front.controllers.sections.library.CommonLogic;
import com.pvt.jd2.project.front.formbeans.FindBookExemplar;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Sections;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 8:41
 */
@Controller
@RequestMapping(value = "/management")
public class BookController extends CommonLogic {

    @RequestMapping(value = "/bookTypeManagement", method = RequestMethod.GET)
    public String bookManagement(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE) Book formBean,
                                 HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_FIND;
    }

    @ModelAttribute(value = Attributes.ACTIVATION_STATUSES)
    private ActivationStatus[]  getActivationStatuses(){
        return getActivationStatusesArray();
    }

    @RequestMapping(value = "/bookExemplarManagement", method = RequestMethod.GET)
    public String bookExemplarManagement(@ModelAttribute(value = Attributes.ACTIVATION_STATUSES) ActivationStatus[] statuses,
                                         @ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR) FindBookExemplar formBean,
                                         HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/bookSerialManagement", method = RequestMethod.GET)
    public String bookSerialManagement(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial formBean,
                                       HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/authorManagement", method = RequestMethod.GET)
    public String authorManagement(@ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author formBean,
                                   HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/genreManagement", method = RequestMethod.GET)
    public String genreManagement(@ModelAttribute(value = Attributes.VIEWED_GENRE) Genre formBean,
                                  HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/publisherManagement", method = RequestMethod.GET)
    public String publisherManagement(@ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher formBean,
                                      HttpSession session){
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_FIND;
    }

}
