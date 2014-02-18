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
<s:message code="pages.libraryManagement.bookType.actions.info" var="info"/>
<s:message code="pages.libraryManagement.bookType.actions.delete" var="delete"/>
<s:message code="pages.libraryManagement.bookType.actions.apply" var="apply"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.listBookType.title"/></h3>
    <table class="table">
        <c:choose>
            <c:when test="${not empty viewedBookTypes}">
                <thead>
                    <tr>
                        <th><s:message code="pages.libraryManagement.bookType.isbn"/></th>
                        <th><s:message code="pages.libraryManagement.bookType.name"/></th>
                        <th>${info}</th>
                        <th>${delete}</th>
                        <c:if test="${not empty sessionScope['viewedBookExemplarFlow']}">
                            <th>${apply}</th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bookType" items="${viewedBookTypes}">
                        <tr>
                            <td>${bookType.isbn}</td>
                            <td>${bookType.name}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/infoBookType" method="POST">
                                    <input type="hidden" name="bookType_id" value="${bookType.id}"/>
                                    <button class="btn btn-primary" type="submit">${info}</button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/deleteBookType" method="POST">
                                    <input type="hidden" name="bookType_id" value="${bookType.id}"/>
                                    <button class="btn btn-primary" type="submit">${delete}</button>
                                </form>
                            </td>
                            <c:if test="${not empty sessionScope['viewedBookExemplarFlow']}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/management/addBookTypeToBookExemplar" method="POST">
                                        <input type="hidden" name="bookType_id" value="${bookType.id}"/>
                                        <button class="btn btn-primary" type="submit">${apply}</button>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <s:message code="pages.libraryManagement.listBookType.notFound"/>
            </c:otherwise>
        </c:choose>
    </table>
</div>