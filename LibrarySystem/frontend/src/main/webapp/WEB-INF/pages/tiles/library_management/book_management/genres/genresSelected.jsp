<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.02.14
  Time: 15:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:message code="pages.libraryManagement.listGenres.actions.delete" var="delete"/>
<c:if test="${not empty sessionScope['viewedBookTypeFlow'] and not empty sessionScope['viewedBookTypeFlow'].genres}">
    <div class="data_content">
        <hr/>
        <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoGenre.selectGenres"/></h3>
        <table class="table">
            <thead>
                <tr>
                    <th><s:message code="pages.libraryManagement.infoGenre.name"/></th>
                    <th><s:message code="pages.libraryManagement.infoGenre.description"/></th>
                    <th>${delete}</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="genre" items="${sessionScope['viewedBookTypeFlow'].genres}">
                    <tr>
                        <td>${genre.name}</td>
                        <td>${genre.description}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/management/removeSelectedGenre" method="POST">
                                <c:if test="${not empty param['infoGenre_id']}">
                                    <input type="hidden" name="infoGenre_id" value="${param['infoGenre_id']}"/>
                                </c:if>
                                <input type="hidden" name="genre_id" value="${genre.id}"/>
                                <input type="hidden" name="onPage" value="${param['onPage']}"/>
                                <button class="btn btn-primary" type="submit">${delete}</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

