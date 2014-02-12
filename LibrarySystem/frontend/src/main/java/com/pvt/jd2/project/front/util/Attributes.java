package com.pvt.jd2.project.front.util;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.01.14
 * Time: 22:30
 */
public interface Attributes {

    // session attributes
    String SECTION = "section";
    String LOGGED_USER = "loggedUser";
    String LOGGED_PERMISSIONS = "loggedPermissions";

    // request attributes
    String VIEWED_USER = "viewedUser";
    String VIEWED_ROLE = "viewedRole";
    String VIEWED_BOOK_TYPE = "viewedBookType";
    String VIEWED_BOOK_SERIAL = "viewedBookSerial";
    String VIEWED_PUBLISHER = "viewedPublisher";
    String VIEWED_AUTHOR = "viewedAuthor";
    String VIEWED_GENRE = "viewedGenre";
    String VIEWED_BOOK_EXEMPLAR_FORM_BEAN = "viewedBookExemplarFormBean";

    String VIEWED_USERS = "listViewedUser";
    String VIEWED_ROLES = "viewedRoles";
    String VIEWED_PERMISSIONS = "viewedPermissions";
    String VIEWED_BOOK_SERIALS = "viewedBookSerials";
    String VIEWED_PUBLISHERS = "viewedPublishers";
    String VIEWED_AUTHORS = "viewedAuthors";
    String VIEWED_GENRES = "viewedGenres";
    String VIEWED_BOOK_TYPES = "viewedBookTypes";
    String VIEWED_BOOK_EXEMPLAR_FORM_BEANS = "viewedBookExemplarFormBeans";

    String INFO_STATUS = "infoStatus";

    //mixed-scope attributes (session & request - flow scope/managed by application)
    String VIEWED_BOOK_EXEMPLAR_FORM_BEAN_FLOW = "viewedBookExemplarFormBeanFlow";
    String VIEWED_BOOK_TYPE_FLOW = "viewedBookTypeFlow";

}
