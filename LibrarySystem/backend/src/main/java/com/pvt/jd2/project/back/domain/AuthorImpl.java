package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:16
 */
public class AuthorImpl extends UserImpl implements Serializable, Author {

    private List<Book> books;

    public AuthorImpl(){
    }

    @Override
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
