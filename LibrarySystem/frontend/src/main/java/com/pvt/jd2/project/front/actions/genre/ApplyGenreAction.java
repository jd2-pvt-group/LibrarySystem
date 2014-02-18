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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 09.02.14
 * Time: 12:01
 */
public class ApplyGenreAction extends AbstractGenreAction {

    public ApplyGenreAction(GenreService genreService) {
        super(genreService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] ids) {
        try{
            Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            Genre genre = genreService.findById(Long.valueOf(ids[0]));
            if (viewedBookType != null){
                List<Genre> genres = getGenresFrom(viewedBookType);
                if (!genres.contains(genre)){
                    genres.add(genre);
                }
            }
            model.addAttribute(Attributes.VIEWED_GENRE, genre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

}
