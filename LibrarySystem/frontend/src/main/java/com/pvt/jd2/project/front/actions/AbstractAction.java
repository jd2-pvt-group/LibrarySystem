package com.pvt.jd2.project.front.actions;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.front.util.Attributes;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 09.02.14
 * Time: 23:25
 */
public abstract class AbstractAction implements Action {

    protected Book getViewedBookType(HttpSession session) {
        return (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
    }

}
