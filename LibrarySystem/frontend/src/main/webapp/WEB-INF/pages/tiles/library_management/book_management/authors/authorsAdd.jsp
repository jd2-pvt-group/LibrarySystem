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
    <h3 class="well title"><s:message code="pages.libraryManagement.addAuthor.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/addNewAuthor" method="POST" commandName="viewedAuthor">
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.addAuthor.firstName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.addAuthor.lastName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="lastName"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.addAuthor.actions.create" var="createAuthor"/>
        <button class="btn btn-primary" type="submit">${createAuthor}</button>
    </form:form>
    <jsp:include page="authorsSelected.jsp">
        <jsp:param name="onPage" value="ADD"/>
    </jsp:include>
</div>