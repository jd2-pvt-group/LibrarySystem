package com.pvt.jd2.project.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:25
 */
public interface BookSerial {

    void setId(Long id);

    Long getId();

    void setName(String name);

    String getName();

    void setBooks(List<Book> books);

    List<Book> getBooks();
}
