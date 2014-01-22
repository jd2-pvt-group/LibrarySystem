package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookSerial;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:19
 */
public class BookSerialImpl implements Serializable, BookSerial {

    private Integer id;
    private String name;
    private List<Book> books;

    private BookSerialImpl(){
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setName(String s) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
