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
    <h3 class="well title"><s:message code="pages.libraryManagement.findAuthor.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/foundAuthors" method="POST" commandName="viewedAuthor">
        <form:errors cssClass="alert alert-error" path="*"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.findAuthor.partOfFirstName"/></td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findAuthor.partOfLastName"/></td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.findAuthor.actions.find" var="find"/>
        <button class="btn btn-primary" type="submit">${find}</button>
    </form:form>
    <jsp:include page="authorsSelected.jsp">
        <jsp:param name="onPage" value="FIND"/>
    </jsp:include>
</div>