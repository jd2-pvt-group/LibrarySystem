package com.pvt.jd2.project.front.controllers.sections.library;

import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Sections;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.01.14
 * Time: 21:00
 */
@Controller
@RequestMapping(value = "/management")
public class LibraryManagementController extends CommonLogic {

    @RequestMapping(value = "/bookManagement", method = RequestMethod.GET)
    public String bookManagement(Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.LIBRARY_MANAGEMENT);
        return TilesDefinitions.LIBRARY_BOOK_MANAGEMENT;
    }

    @RequestMapping(value = "/bookOrderingManagement", method = RequestMethod.GET)
    public String bookOrderingManagement(Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.LIBRARY_MANAGEMENT);
        return TilesDefinitions.LIBRARY_BOOK_ORDERING_MANAGEMENT;
    }

    @RequestMapping(value = "/bookHistoryManagement", method = RequestMethod.GET)
    public String bookHistoryManagement(Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.LIBRARY_MANAGEMENT);
        return TilesDefinitions.LIBRARY_BOOK_HISTORY_MANAGEMENT;
    }

}
