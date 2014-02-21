<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<s:message code="pages.libraryManagement.addBook.noISBN" var="noISBN"/>
<s:message code="pages.libraryManagement.addBook.noBookName" var="noBookName"/>
<s:message code="pages.libraryManagement.addBook.noBookDescription" var="noBookDescription"/>
<s:message code="pages.libraryManagement.addBook.noBookSerial" var="noBookSerial"/>
<s:message code="pages.libraryManagement.addBook.noPublisher" var="noPublisher"/>
<s:message code="pages.libraryManagement.addBook.addISBN" var="selectISBN"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.addBook.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/addNewBookExemplar" method="POST" commandName="viewedBookExemplarFlow">
        <input type="hidden" id="actionId" name="bookAddAction"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.isbn"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.isbn}">
                                <form:input cssClass="input-block-level" readonly="true" path="book.isbn"/>
                            </c:when>
                            <c:otherwise>
                                <input class="input-block-level" readonly="true" value="${noISBN}" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#actionId','SELECT_ISBN');">${selectISBN}</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="book.isbn"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookExemplar.libraryCode"/></td>
                    <td><form:input class="input-block-level" path="libraryCode"/></td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="libraryCode"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.name"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.name}">
                                <c:out value="${sessionScope['viewedBookExemplarFlow'].book.name}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noBookName}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="book.name"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.description"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.description}">
                                <c:out value="${sessionScope['viewedBookExemplarFlow'].book.description}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noBookDescription}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.bookSerial"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.bookSerial}">
                                <c:out value="${sessionScope['viewedBookExemplarFlow'].book.bookSerial.name}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noBookSerial}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.publisher"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.publisher}">
                                <c:out value="${sessionScope['viewedBookExemplarFlow'].book.publisher.name}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noPublisher}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="book.publisher"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.authors"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.authors}">
                                <c:forEach var="author" items="${sessionScope['viewedBookExemplarFlow'].book.authors}">
                                    <c:out value="${author.firstName} ${author.lastName}"/><br/>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noAuthors"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="book.authors"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.genres"/>:</td>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${not empty sessionScope['viewedBookExemplarFlow'].book.genres}">
                                <c:forEach var="genre" items="${sessionScope['viewedBookExemplarFlow'].book.genres}">
                                    <c:out value="${genre.name}"/><br/>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noGenres"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="book.genres"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookExemplar.isActive"/>:</td>
                    <td colspan="2"><form:checkbox cssClass="checkbox" path="active"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.addBook.save" var="saveBookExemplar"/>
        <button class="btn btn-primary" type="submit">${saveBookExemplar}</button>
    </form:form>
</div>