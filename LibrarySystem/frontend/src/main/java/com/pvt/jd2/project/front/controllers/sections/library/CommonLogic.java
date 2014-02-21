package com.pvt.jd2.project.front.controllers.sections.library;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.BookActionType;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 2:02
 */
public class CommonLogic {

    protected void removeSessionAttributes(HttpSession session) {
        session.removeAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
        session.removeAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
    }

    protected String selectCommonTilesDefinition(BookActionType action, Model model) {
        switch(action){
            case SELECT_ISBN:
                model.addAttribute(Attributes.VIEWED_BOOK_TYPE, new Book());
                return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_FIND;
            case SELECT_PUBLISHER:
                model.addAttribute(Attributes.VIEWED_PUBLISHER, new Publisher());
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_FIND;
            case SELECT_AUTHORS:
                model.addAttribute(Attributes.VIEWED_AUTHOR, new Author());
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_FIND;
            case SELECT_BOOK_SERIAL:
                model.addAttribute(Attributes.VIEWED_BOOK_SERIAL, new BookSerial());
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_FIND;
            case SELECT_GENRES:
                model.addAttribute(Attributes.VIEWED_GENRE, new Genre());
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_FIND;
        }
        return null;
    }

    protected ActivationStatus[] getActivationStatusesArray(){
        return ActivationStatus.values();
    }


    protected String getBookAction(String bookAddAction, Model model){
        if ((bookAddAction == null) || bookAddAction.isEmpty()){
            return null;
        }
        BookActionType action = BookActionType.valueOf(bookAddAction);
        return selectCommonTilesDefinition(action, model);
    }
}
