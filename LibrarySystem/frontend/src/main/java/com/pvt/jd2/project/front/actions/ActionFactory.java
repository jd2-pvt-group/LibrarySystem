package com.pvt.jd2.project.front.actions;

import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.common.service.GenreService;
import com.pvt.jd2.project.front.actions.author.ApplyAuthorAction;
import com.pvt.jd2.project.front.actions.author.ApplyListAuthorAction;
import com.pvt.jd2.project.front.actions.author.DeleteAuthorAction;
import com.pvt.jd2.project.front.actions.author.InfoAuthorAction;
import com.pvt.jd2.project.front.actions.genre.ApplyGenreAction;
import com.pvt.jd2.project.front.actions.genre.ApplyListGenreAction;
import com.pvt.jd2.project.front.actions.genre.DeleteGenreAction;
import com.pvt.jd2.project.front.actions.genre.InfoGenreAction;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.ActionType;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 12:42
 */
public final class ActionFactory {

    private ActionFactory(){
    }

    public static ActionType getActionType(String action){
        return ActionType.valueOf(action);
    }

    public static Action getGenreAction(String action, GenreService genreService) {
        ActionType actionType = getActionType(action);
        switch (actionType){
            case APPLY_LIST:
                return new ApplyListGenreAction(genreService);
            case DELETE:
                return new DeleteGenreAction(genreService);
            case APPLY:
                return new ApplyGenreAction(genreService);
            default:
                return new InfoGenreAction(genreService);
        }
    }

    public static Action getAuthorAction(String action, AuthorService authorService) {
        ActionType actionType = getActionType(action);
        switch (actionType){
            case APPLY_LIST:
                return new ApplyListAuthorAction(authorService);
            case DELETE:
                return new DeleteAuthorAction(authorService);
            case APPLY:
                return new ApplyAuthorAction(authorService);
            default:
                return new InfoAuthorAction(authorService);
        }
    }

}
