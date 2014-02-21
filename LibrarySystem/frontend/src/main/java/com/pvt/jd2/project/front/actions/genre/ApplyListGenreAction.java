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
 * Date: 08.02.14
 * Time: 12:40
 */
public class ApplyListGenreAction extends AbstractGenreAction {

    public ApplyListGenreAction(GenreService genreService) {
        super(genreService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] ids) {
        Book viewedBookType = getViewedBookType(session);
        if (ids != null){
            List<Genre> genres = getGenresFrom(viewedBookType);
            return performFor(genres, model, ids);
        }else{
            List<Genre> allGenres = null;
            if (viewedBookType != null){
                allGenres = genreService.listWithout(viewedBookType.getGenres());
            }else{
                allGenres = genreService.list();
            }
            model.addAttribute(Attributes.VIEWED_GENRES, allGenres);
        }
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
    }

    private String performFor(List<Genre> genres, Model model, String[] ids){
        try{
            for(String genreId : ids){
                Genre tmpGenre = genreService.findById(Long.valueOf(genreId));
                if (!genres.contains(tmpGenre)){
                    genres.add(tmpGenre);
                }
            }
            List<Genre> allGenres = genreService.listWithout(genres);
            model.addAttribute(Attributes.VIEWED_GENRES, allGenres);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

}
