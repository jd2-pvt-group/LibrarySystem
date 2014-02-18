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
<s:message code="pages.libraryManagement.listGenres.actions.apply" var="apply"/>
<s:message code="pages.libraryManagement.listGenres.actions.delete" var="delete"/>
<s:message code="pages.libraryManagement.listGenres.actions.info" var="info"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.listGenres.title"/></h3>
    <form action="${pageContext.request.contextPath}/management/addGenreToBookType" method="POST">
        <input type="hidden" id="action" name="action"/>
        <input type="hidden" id="infoGenre_id" name="infoGenre_id">
        <table class="table">
            <c:choose>
                <c:when test="${not empty viewedGenres}">
                    <thead>
                        <tr>
                            <th><s:message code="pages.libraryManagement.addGenre.name"/></th>
                            <th><s:message code="pages.libraryManagement.addGenre.description"/></th>
                            <th>${info}</th>
                            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                                <th>${apply}</th>
                            </c:if>
                            <th>${delete}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="genre" items="${viewedGenres}">
                            <tr>
                                <td>${genre.name}</td>
                                <td>${genre.description}</td>
                                <td>
                                    <button class="btn btn-primary" type="submit"  onclick="beforeSubmitAndSetValue('#action','INFO','#infoGenre_id',${genre.id});">${info}</button>
                                </td>
                                <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                                    <td>
                                        <input type="checkbox" class="checkbox" name="applyGenre_id" value="${genre.id}">
                                    </td>
                                </c:if>
                                <td>
                                    <input type="checkbox" class="checkbox" name="deleteGenre_id" value="${genre.id}">
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                            <tr>
                                <td>
                                    <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#action','APPLY_LIST');">${apply}</button>
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#action','DELETE');">${delete}</button>
                            </td>
                        </tr>
                    </tbody>
                </c:when>
                <c:otherwise>
                    <s:message code="pages.libraryManagement.listGenres.notFound"/></td>
                </c:otherwise>
            </c:choose>
        </table>
    </form>
    <jsp:include page="genresSelected.jsp">
        <jsp:param name="onPage" value="LIST"/>
    </jsp:include>
</div>