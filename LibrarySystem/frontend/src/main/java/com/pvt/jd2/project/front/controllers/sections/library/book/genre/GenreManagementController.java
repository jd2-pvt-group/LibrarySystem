package com.pvt.jd2.project.front.controllers.sections.library.book.genre;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.GenreService;
import com.pvt.jd2.project.front.actions.Action;
import com.pvt.jd2.project.front.actions.ActionFactory;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.ActionType;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.NavigateOnPage;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.GenreValidator;
import com.pvt.jd2.project.front.validators.find.FindGenreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 04.02.14
 * Time: 10:54
 */
@Controller
@RequestMapping(value = "/management")
public class GenreManagementController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreValidator genreValidator;

    @Autowired
    private FindGenreValidator findGenreFormBeanValidator;

    @RequestMapping(value = "/addGenre", method = RequestMethod.GET)
    public String addGenre(@ModelAttribute(value = Attributes.VIEWED_GENRE) Genre genre) {
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewGenre", method = RequestMethod.POST)
    public String addNewGenre(@ModelAttribute(value = Attributes.VIEWED_GENRE) Genre genre,
                               BindingResult result) {
        try{
            ValidationUtils.invokeValidator(genreValidator, genre, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ADD;
            }
            genreService.create(genre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listGenres", method = RequestMethod.GET)
    public String listOfAuthors(HttpSession session,
                                Model model){
        List<Genre> genres = genreService.list();
        Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        if ((viewedBookType != null) && (viewedBookType.getGenres() != null)){
            genres.removeAll(viewedBookType.getGenres());
        }
        model.addAttribute(Attributes.VIEWED_GENRES, genres);
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/addGenreToBookType", method = RequestMethod.POST)
    public String addToBookType(HttpSession session,
                                @RequestParam(value = Parameters.APPLY_GENRE_ID, required = false) String[] applyGenreId,
                                @RequestParam(value = Parameters.DELETE_GENRE_ID, required = false) String[] deleteGenreId,
                                @RequestParam(value = Parameters.INFO_GENRE_ID, required = false) String[] infoGenreId,
                                @RequestParam(value = Parameters.ACTION) String genreAction,
                                Model model) {
        Action action = ActionFactory.getGenreAction(genreAction, genreService);
        ActionType genreActionType = ActionFactory.getActionType(genreAction);
        switch(genreActionType){
            case APPLY_LIST:
                return action.perform(session, model, applyGenreId);
            case APPLY:
                return action.perform(session, model, applyGenreId);
            case DELETE:
                return action.perform(session, model, deleteGenreId);
            default:
                return action.perform(session, model, infoGenreId);
        }
    }

    @RequestMapping(value = "/deleteGenre", method = RequestMethod.POST)
    public String deleteAuthor(@RequestParam(value = Parameters.GENRE_ID) String genreId,
                               Model model){
        try{
            Genre genre = genreService.findById(Long.valueOf(genreId));
            genreService.delete(genre);
            List<Genre> genres = genreService.list();
            model.addAttribute(Attributes.VIEWED_GENRES, genres);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/findGenre", method = RequestMethod.GET)
    private String findAuthor(@ModelAttribute(value = Attributes.VIEWED_GENRE) Genre formBean){
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundGenres", method = RequestMethod.POST)
    private String findAuthor(HttpSession session,
                              @ModelAttribute(value = Attributes.VIEWED_GENRE) Genre formBean,
                              BindingResult result,
                              Model model) {
        try{
            ValidationUtils.invokeValidator(findGenreFormBeanValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_FIND;
            }
            return findGenre(session, formBean, model);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    private String findGenre(HttpSession session, Genre formBean, Model model){
        List<Genre> genres = genreService.listLike(formBean);
        Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        if ((viewedBookType != null) && (viewedBookType.getAuthors() != null)){
            genres.removeAll(viewedBookType.getGenres());
        }
        model.addAttribute(Attributes.VIEWED_GENRES, genres);
        return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/infoGenre", method = RequestMethod.POST)
    public String infoAuthor(@RequestParam(value = Parameters.GENRE_ID) String genreId,
                             Model model) {
        try{
            Genre genre = genreService.findById(Long.valueOf(genreId));
            model.addAttribute(Attributes.VIEWED_GENRE, genre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updateGenre", method = RequestMethod.POST)
    public String updateAuthor(@RequestParam(value = Parameters.GENRE_ID) String genreId, Model model){
        try{
            Genre genre = genreService.findById(Long.valueOf(genreId));
            model.addAttribute(Attributes.VIEWED_GENRE, genre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeGenre", method = RequestMethod.POST)
    public String changeAuthor(HttpSession session,
                               @ModelAttribute(value = Attributes.VIEWED_GENRE) Genre genre,
                               BindingResult result) {
        try{
            ValidationUtils.invokeValidator(genreValidator, genre, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_UPDATE;
            }
            Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            updateGenresOfViewedBookTypeFlow(viewedBookType, genre);
            genreService.update(genre);
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me later
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    private void updateGenresOfViewedBookTypeFlow(Book viewedBookType, Genre genre) {
        if (viewedBookType != null){
            List<Genre> genres = viewedBookType.getGenres();
            if (genres != null){
                if (genres.contains(genre)){
                    genres.remove(genre);
                    genres.add(genre);
                }
            }
        }
    }

    @RequestMapping(value = "/removeSelectedGenre", method = RequestMethod.POST)
    public String removeFromSelected(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                     @ModelAttribute(value = Attributes.VIEWED_GENRE) Genre formBean,
                                     @RequestParam(value = Parameters.INFO_GENRE_ID, required = false) String infoGenreId,
                                     @RequestParam(value = Parameters.GENRE_ID) String genreId,
                                     @RequestParam(value = Parameters.ON_PAGE) String onPage,
                                     Model model) {
        try{
            List<Genre> genres = viewedBookType.getGenres();
            if (genres != null){
                Genre tmpGenre = genreService.findById(Long.valueOf(genreId));
                genres.remove(tmpGenre);
            }
            if (infoGenreId != null){
                Genre genre = genreService.findById(Long.valueOf(infoGenreId));
                model.addAttribute(Attributes.VIEWED_GENRE, genre);
            }
            return gotTo(onPage);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

    private String gotTo(String onPage) {
        NavigateOnPage page = NavigateOnPage.valueOf(onPage);
        switch(page){
            case INFO:
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_INFO;
            case LIST:
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_LIST;
            case ADD:
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ADD;
            case FIND:
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_FIND;
            default:
                return TilesDefinitions.LIBRARY_GENRE_MANAGEMENT_ERROR;
        }
    }

}
