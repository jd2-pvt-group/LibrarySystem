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
    <h3 class="well title"><s:message code="pages.libraryManagement.updateAuthor.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/changeAuthor" method="POST" commandName="viewedAuthor">
        <form:hidden path="id"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.infoAuthor.firstName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.infoAuthor.lastName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="lastName"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.updateAuthor.actions.update" var="updateAuthor"/>
        <button class="btn btn-primary" type="submit">${updateAuthor}</button>
    </form:form>
    <form action="${pageContext.request.contextPath}/management/infoAuthor" method="POST">
        <input type="hidden" name="author_id" value="${viewedAuthor.id}">
        <s:message code="pages.libraryManagement.updateAuthor.actions.back" var="back"/>
        <button class="btn btn-primary" type="submit">${back}</button>
    </form>
</div>