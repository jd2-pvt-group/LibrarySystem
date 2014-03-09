<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:message code="pages.header.welcome" arguments="${sessionScope['loggedUser'].login}"/>
<a href="${pageContext.request.contextPath}/logout"><s:message code="pages.header.logout"/></a>