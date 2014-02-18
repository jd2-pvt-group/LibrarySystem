package com.pvt.jd2.project.front.actions.genre;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.common.service.GenreService;
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
public abstract class AbstractGenreAction extends AbstractAction {

    protected GenreService genreService;

    public AbstractGenreAction(GenreService genreService){
        this.genreService = genreService;
    }

    public List<Genre> getGenresFrom(Book book){
        if (book.getGenres() == null){
            book.setGenres(new ArrayList<Genre>());
        }
        return book.getGenres();
    }

}
