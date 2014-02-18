package com.pvt.jd2.project.front.actions.genre;

import com.pvt.jd2.project.common.domain.Author;
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
 * Time: 12:32
 */
public class DeleteGenreAction extends AbstractGenreAction {


    public DeleteGenreAction(GenreService genreService) {
        super(genreService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] ids) {
        try{
            if (ids != null){
                for(String genreId : ids){
                    Genre tmpGenre = genreService.findById(Long.valueOf(genreId));
                    genreService.delete(tmpGenre);
                }
            }
            List<Genre> genres = genreService.list();
            model.addAttribute(Attributes.VIEWED_GENRES, genres);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }
}
