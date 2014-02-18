package com.pvt.jd2.project.front.util;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 28.01.14
 * Time: 16:07
 */
public interface Messages {

    String LOGIN_PAGE_LOGIN_IS_WRONG = "pages.login.errors.loginIsWrong";
    String LOGIN_PAGE_LOGIN_IS_EMPTY = "pages.login.errors.loginIsEmpty";
    String LOGIN_PAGE_PASSWORD_IS_EMPTY = "pages.login.errors.passwordIsEmpty";

    String USER_INFO_PASS_NUMBER_IS_EMPTY = "pages.userManagement.updateUser.errors.passportNumber";
    String USER_INFO_LOGIN_EXISTS = "pages.userManagement.updateUser.errors.loginExists";
    String USER_INFO_PASS_NUMBER_EXISTS = "pages.userManagement.updateUser.errors.passNumberExists";

    String USER_FIND_ALL_FIELDS_EMPTY = "pages.userManagement.findUser.allPagesAreEmpty";

    String ROLE_INFO_NAME_IS_EMPTY = "pages.roleManagement.infoRole.errors.nameEmpty";
    String ROLE_INFO_NAME_EXISTS = "pages.roleManagement.infoRole.errors.nameExists";
    String ROLE_FIND_FIELDS_ARE_EMPTY = "pages.roleManagement.findRole.errors.emptyFields";

    String BOOK_ADD_BOOK_NAME_IS_EMPTY = "pages.libraryManagement.addBook.error.bookNameIsEmpty";
    String BOOK_ADD_LIBRARY_CODE_IS_EMPTY = "pages.libraryManagement.addBook.error.libraryCodeIsEmpty";
    String BOOK_ADD_ISBN_WITH_SUCH_LIBRARY_CODE_EXISTS = "pages.libraryManagement.addBook.error.isbnWithSuchLibraryCodeExists";
    String BOOK_ADD_NO_BOOK_TYPE = "pages.libraryManagement.addBook.error.noBookISBN";
    String BOOK_ADD_NO_PUBLISHER = "pages.libraryManagement.addBook.error.noPublisher";
    String BOOK_ADD_NO_AUTHORS = "pages.libraryManagement.addBook.error.noAuthors";
    String BOOK_ADD_NO_GENRES = "pages.libraryManagement.addBook.error.noGenres";

    String BOOK_TYPE_ADD_ISBN_IS_EMPTY = "pages.libraryManagement.addBook.error.isbnIsEmpty";
    String BOOK_TYPE_ADD_ISBN_EXISTS = "pages.libraryManagement.addBook.error.isbnExists";
    String BOOK_TYPE_FIELDS_ARE_EMPTY = "pages.libraryManagement.findBookType.errors.emptyFields";

    String BOOK_SERIAL_NAME_IS_EMPTY = "pages.libraryManagement.addBookSerial.bookSerialNameIsEmpty";
    String BOOK_SERIAL_NAME_EXISTS = "pages.libraryManagement.addBookSerial.bookSerialNameExists";

    String BOOK_SERIAL_FIELDS_ARE_EMPTY = "pages.libraryManagement.findBookSerial.errors.emptyFields";

    String PUBLISHER_NAME_IS_EMPTY = "pages.libraryManagement.addPublisher.error.nameIsEmpty";
    String PUBLISHER_NAME_EXISTS = "pages.libraryManagement.addPublisher.error.nameExists";
    String PUBLISHER_FIELDS_ARE_EMPTY = "pages.libraryManagement.findPublisher.error.emptyFields";

    String AUTHOR_FIRST_NAME_IS_EMPTY = "pages.libraryManagement.addAuthor.errors.firstNameEmpty";
    String AUTHOR_LAST_NAME_IS_EMPTY = "pages.libraryManagement.addAuthor.errors.lastNameEmpty";
    String AUTHOR_EXISTS = "pages.libraryManagement.addAuthor.errors.authorExists";
    String AUTHOR_FIELDS_ARE_EMPTY = "pages.libraryManagement.addAuthor.errors.emptyList";

    String GENRE_NAME_IS_EMPTY = "pages.libraryManagement.addGenre.error.nameIsEmpty";
    String GENRE_NAME_EXISTS = "pages.libraryManagement.addGenre.error.nameExists";
    String GENRE_FIELDS_ARE_EMPTY = "pages.libraryManagement.findGenre.error.emptyFields";

    String BOOK_EXEMPLAR_FIELDS_ARE_EMPTY = "pages.libraryManagement.findBookExemplar.errors.emptyFields";
    String BOOK_EXEMPLAR_LIBRARY_CODE_INCORRECT_FORMAT = "pages.libraryManagement.findBookExemplar.errors.libraryCodeIncorrectFormat";

}
