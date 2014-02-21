<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.infoBookType.title" arguments="${viewedBookType.name}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.isbn"/>:</td>
                <td>${viewedBookType.isbn}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.name"/>:</td>
                <td>${viewedBookType.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.description"/>:</td>
                <td>${viewedBookType.description}</td>
            </tr>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/management/updateBookType" method="POST">
        <input type="hidden" name="bookType_id" value="${viewedBookType.id}"/>
        <s:message code="pages.libraryManagement.infoBookType.actions.update" var="update"/>
        <button class="btn btn-primary" type="submit">${update}</button>
    </form>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/viewBookSerial" method="POST">
                    <s:message code="pages.libraryManagement.infoBookType.viewBookSerial" var="viewBookSerial"/>
                    <input type="hidden" name="bookType_id" value="${viewedBookType.id}"/>
                    <button class="btn btn-primary" type="submit">${viewBookSerial}</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/management/viewPublisher" method="POST">
                    <s:message code="pages.libraryManagement.infoBookType.viewPublisher" var="viewPublisher"/>
                    <input type="hidden" name="bookType_id" value="${viewedBookType.id}"/>
                    <button class="btn btn-primary" type="submit">${viewPublisher}</button>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/viewAuthors" method="POST">
                    <s:message code="pages.libraryManagement.infoBookType.viewAuthors" var="viewAuthors"/>
                    <input type="hidden" name="bookType_id" value="${viewedBookType.id}"/>
                    <button class="btn btn-primary" type="submit">${viewAuthors}</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/management/viewGenres" method="POST">
                    <s:message code="pages.libraryManagement.infoBookType.viewGenres" var="viewGenres"/>
                    <input type="hidden" name="bookType_id" value="${viewedBookType.id}"/>
                    <button class="btn btn-primary" type="submit">${viewGenres}</button>
                </form>
            </td>
        </tr>
    </table>
    <c:choose>
        <c:when test="${infoStatus eq 'BOOK_SERIAL'}">
            <hr/>
            <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoBookType.additionalInfo.bookSerial"/></h3>
            <table class="table">
                <tbody>
                    <c:choose>
                        <c:when test="${not empty viewedBookSerial}">
                        <tr>
                            <td><s:message code="pages.libraryManagement.addBookSerial.name"/>:</td>
                            <td>${viewedBookSerial.name}</td>
                        </tr>
                        <tr>
                            <td><s:message code="pages.libraryManagement.addBookSerial.description"/>:</td>
                            <td>${viewedBookSerial.description}</td>
                        </tr>
                        </c:when>
                        <c:otherwise>
                            <s:message code="pages.libraryManagement.infoBookType.additionalInfo.bookSerial.notFound"/></td>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </c:when>
        <c:when test="${infoStatus eq 'PUBLISHER'}">
            <hr/>
            <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoBookType.additionalInfo.publisher"/></h3>
            <table class="table">
                <tbody>
                    <tr>
                        <td><s:message code="pages.libraryManagement.addPublisher.name"/>:</td>
                        <td>${viewedPublisher.name}</td>
                    </tr>
                    <tr>
                        <td><s:message code="pages.libraryManagement.addPublisher.address"/>:</td>
                        <td>${viewedPublisher.address}</td>
                    </tr>
                </tbody>
            </table>
        </c:when>
        <c:when test="${infoStatus eq 'AUTHORS'}">
            <hr/>
            <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoBookType.additionalInfo.authors"/></h3>
            <table class="table">
                <thead>
                    <tr>
                        <th><s:message code="pages.libraryManagement.addAuthor.firstName"/></th>
                        <th><s:message code="pages.libraryManagement.addAuthor.lastName"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="author" items="${viewedAuthors}">
                        <tr>
                            <td>${author.firstName}</td>
                            <td>${author.lastName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:when test="${infoStatus eq 'GENRES'}">
            <hr/>
            <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoBookType.additionalInfo.genres"/></h3>
            <table class="table">
                <thead>
                    <tr>
                        <th><s:message code="pages.libraryManagement.addGenre.name"/></th>
                        <th><s:message code="pages.libraryManagement.addGenre.description"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="genre" items="${viewedGenres}">
                        <tr>
                            <td>${genre.name}</td>
                            <td>${genre.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
    </c:choose>
</div>