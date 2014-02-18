package com.pvt.jd2.project.front.actions.genre;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.common.service.GenreService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 13:10
 */
public class InfoGenreAction extends AbstractGenreAction {

    public InfoGenreAction(GenreService genreService) {
        super(genreService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] ids) {
        try{
            Genre tmpGenre = genreService.findById(Long.valueOf(ids[0]));
            model.addAttribute(Attributes.VIEWED_GENRE, tmpGenre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

}

