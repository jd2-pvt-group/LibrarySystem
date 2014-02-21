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
 * Time: 12:32
 */
public class DeleteAuthorAction extends AbstractAuthorAction {


    public DeleteAuthorAction(AuthorService authorService) {
        super(authorService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] authorIds) {
        try{
            if (authorIds != null){
                for(String authorId : authorIds){
                    Author tmpAuthor = authorService.findById(Long.valueOf(authorId));
                    authorService.delete(tmpAuthor);
                }
            }
            Book bookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            List<Author> authors = null;
            if (bookType != null){
                 authors = authorService.listWithout(bookType.getAuthors());
            }else{
                authors = authorService.list();
            }
            model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }
}
