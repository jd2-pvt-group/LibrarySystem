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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.findGenre.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/foundGenres" method="POST" commandName="viewedGenre">
        <form:errors cssClass="alert alert-error" path="*"/><hr/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.findGenre.partOfName"/></td>
                    <td><form:input cssClass="input-block-level" path="name"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findAuthor.partOfDescription"/></td>
                    <td><form:input cssClass="input-block-level" path="description"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.findGenre.actions.find" var="find"/>
        <button class="btn btn-primary" type="submit">${find}</button>
    </form:form>
    <jsp:include page="genresSelected.jsp">
        <jsp:param name="onPage" value="FIND"/>
    </jsp:include>
</div>