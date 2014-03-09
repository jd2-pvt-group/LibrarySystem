<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<li>
    <a href="${pageContext.request.contextPath}/management/personalListAssigned">
        <i class="icon-chevron-right"></i> <s:message code="pages.personManagement.listAssigned"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/personalFindAssigned">
        <i class="icon-chevron-right"></i> <s:message code="pages.personManagement.findAssigned"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/personalSettings">
        <i class="icon-chevron-right"></i> <s:message code="pages.personManagement.settings"/>
    </a>
</li>
<li>
    <a href="javascript:void(0);" onclick="submitForm('#userInfo');">
        <i class="icon-chevron-right"></i> <s:message code="pages.personManagement.infoUser"/>
    </a>
</li>
<form id="userInfo" action="${pageContext.request.contextPath}/management/infoUser" method="POST">
    <input type="hidden" name="user_id" value="${sessionScope['loggedUser'].id}"/>
</form>