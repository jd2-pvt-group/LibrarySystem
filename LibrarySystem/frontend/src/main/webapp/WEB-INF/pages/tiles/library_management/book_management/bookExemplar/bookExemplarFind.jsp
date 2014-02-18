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
    <h3 class="well title"><s:message code="pages.libraryManagement.findBookExemplar.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/foundBookExemplars" method="POST" commandName="viewedBookExemplar">
        <form:errors cssClass="alert alert-error" path="*"/><hr/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookExemplar.bookType.isbn"/>:</td>
                    <td>
                        <form:input cssClass="input-block-level" path="bookExemplar.book.isbn"/></td>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookExemplar.libraryCode"/>:</td>
                    <td><form:input cssClass="input-block-level" path="bookExemplar.libraryCode"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookExemplar.active"/></td>
                    <td>
                        <form:select cssClass="bootstrap-select" path="status" items="${activationStatuses}"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookExemplar.bookType.name"/>:</td>
                    <td><form:input cssClass="input-block-level" path="bookExemplar.book.name"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookExemplar.bookType.description"/>:</td>
                    <td><form:input cssClass="input-block-level" path="bookExemplar.book.description"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.findBookExemplar.actions.find" var="find"/>
        <button class="btn btn-primary" type="submit">${find}</button>
    </form:form>
</div>