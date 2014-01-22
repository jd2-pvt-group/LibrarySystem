package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserImpl: Oleg
 * Date: 20.01.14
 * Time: 16:48
 */
public class BookImpl implements Serializable, Book {

    private Integer id;
    private String isbn;
    private List<Genre> genres;
    private BookSerial bookSerial;
    private String name;
    private List<Author> authors;
    private Publisher publisher;

    public BookImpl(){
    }

    @Override
    public void setId(Integer integer) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public void setSerial(BookSerial bookSerial) {
        this.bookSerial = bookSerial;
    }

    @Override
    public BookSerial getSerial() {
        return bookSerial;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}
