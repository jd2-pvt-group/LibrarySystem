<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<li>
    <a href="${pageContext.request.contextPath}/management/addRole?fragments=content">
        <s:message code="pages.roleManagement.addRole"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listRoles?fragments=content">
        <s:message code="pages.roleManagement.listRoles"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findRole">
        <s:message code="pages.roleManagement.findRole"/>
    </a>
</li>
