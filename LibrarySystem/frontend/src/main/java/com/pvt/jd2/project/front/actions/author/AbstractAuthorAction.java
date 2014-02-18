package com.pvt.jd2.project.front.actions.author;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.front.actions.AbstractAction;
import com.pvt.jd2.project.front.actions.Action;
import com.pvt.jd2.project.front.util.Attributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 12:55
 */
public abstract class AbstractAuthorAction extends AbstractAction {

    protected AuthorService authorService;

    public AbstractAuthorAction(AuthorService authorService){
        this.authorService = authorService;
    }

    public List<Author> getAuthorsFrom(Book book){
        if (book.getAuthors() == null){
            book.setAuthors(new ArrayList<Author>());
        }
        return book.getAuthors();
    }

}
