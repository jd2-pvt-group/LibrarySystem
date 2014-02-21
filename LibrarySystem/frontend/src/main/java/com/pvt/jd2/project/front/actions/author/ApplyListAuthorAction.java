package com.pvt.jd2.project.front.actions.author;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
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
public class ApplyListAuthorAction extends AbstractAuthorAction {

    public ApplyListAuthorAction(AuthorService authorService) {
        super(authorService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] authorIds) {
        Book viewedBookType = getViewedBookType(session);
        if (authorIds != null){
            List<Author> authors = getAuthorsFrom(viewedBookType);
            return performFor(authors, model, authorIds);
        }else{
            List<Author> allAuthors = null;
            if (viewedBookType != null){
                allAuthors = authorService.listWithout(viewedBookType.getAuthors());
            }else{
                allAuthors = authorService.list();
            }
            model.addAttribute(Attributes.VIEWED_AUTHORS, allAuthors);
        }
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
    }

    private String performFor(List<Author> authors, Model model, String[] authorIds){
        try{
            for(String authorId : authorIds){
                Author tmpAuthor = authorService.findById(Long.valueOf(authorId));
                if (!authors.contains(tmpAuthor)){
                    authors.add(tmpAuthor);
                }
            }
            List<Author> allAuthors = authorService.listWithout(authors);
            model.addAttribute(Attributes.VIEWED_AUTHORS, allAuthors);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

}
