package com.pvt.jd2.project.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:05
 */
public interface Author extends User {

    void setBooks(List<Book> books);

    List<Book> getBooks();

}
