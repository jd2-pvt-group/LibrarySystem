package com.pvt.jd2.project.front.actions;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 12:29
 */
public interface Action {

    public String perform(HttpSession session, Model model, String[] ids);

}
