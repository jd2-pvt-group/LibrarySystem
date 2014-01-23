package com.pvt.jd2.project.common.domain;

import com.pvt.jd2.project.common.domain.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 20.01.14
 * Time: 16:48
 */
public class Book implements Serializable {

    private Long id;
    private String isbn;
    private List<Genre> genres;
    private BookSerial bookSerial;
    private String name;
    private List<Author> authors;
    private Publisher publisher;

    public Book(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setSerial(BookSerial bookSerial) {
        this.bookSerial = bookSerial;
    }

    public BookSerial getSerial() {
        return bookSerial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
