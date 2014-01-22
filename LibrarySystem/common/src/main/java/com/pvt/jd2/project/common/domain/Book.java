package com.pvt.jd2.project.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 12:28
 */
public interface Book {

    void setId(Integer id);

    Integer getId();

    void setIsbn(String isbn);

    String getIsbn();

    void setGenres(List<Genre> genre);

    List<Genre> getGenres();

    void setSerial(BookSerial bookSerial);

    BookSerial getSerial();

    void setName(String name);

    String getName();

    void setAuthors(List<Author> authors);

    List<Author> getAuthors();

    void setPublisher(Publisher publisher);

    Publisher getPublisher();

}
