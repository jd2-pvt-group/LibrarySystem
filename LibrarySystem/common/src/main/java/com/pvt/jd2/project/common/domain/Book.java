package com.pvt.jd2.project.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 19:14
 */
@Entity
@Table(name="BOOK")
public class Book implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;

    @Column(name="ISBN")
    private String isbn;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="BOOK_AUTHOR",
            joinColumns={@JoinColumn(name="BOOK_ID")},
            inverseJoinColumns={@JoinColumn(name="AUTHOR_ID")})
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name="BOOK_SERIAL_ID")
    private BookSerial bookSerial;

    @ManyToOne
    @JoinColumn(name="PUBLISHER_ID")
    private Publisher publisher;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="BOOK_GENRE",
            joinColumns={@JoinColumn(name="BOOK_ID")},
            inverseJoinColumns={@JoinColumn(name="GENRE_ID")})
    private List<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BookSerial getBookSerial() {
        return bookSerial;
    }

    public void setBookSerial(BookSerial bookSerial) {
        this.bookSerial = bookSerial;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
