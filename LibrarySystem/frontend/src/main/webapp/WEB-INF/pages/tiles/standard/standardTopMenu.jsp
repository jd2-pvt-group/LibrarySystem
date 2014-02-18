<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<li <c:if test="${sessionScope['section'] eq 'USER_MANAGEMENT'}">class="active"</c:if>>
    <a href="${pageContext.request.contextPath}/management/userManagement">
        <i class="icon-chevron-down"></i> <s:message code="pages.standard.top_menu.userManagement"/>
    </a>
</li>
<li <c:if test="${sessionScope['section'] eq 'ROLE_MANAGEMENT'}">class="active"</c:if>>
    <a href="${pageContext.request.contextPath}/management/roleManagement">
        <i class="icon-chevron-down"></i> <s:message code="pages.standard.top_menu.roleManagement"/>
    </a>
</li>
<li <c:if test="${sessionScope['section'] eq 'LIBRARY_MANAGEMENT'}">class="active"</c:if>>
    <a href="${pageContext.request.contextPath}/management/libraryManagement">
        <i class="icon-chevron-down"></i> <s:message code="pages.standard.top_menu.libraryManagement"/>
    </a>
</li>
<li <c:if test="${sessionScope['section'] eq 'PERSONAL_MANAGEMENT'}">class="active"</c:if>>
    <a href="${pageContext.request.contextPath}/management/personalManagement">
        <i class="icon-chevron-down"></i> <s:message code="pages.standard.top_menu.personalManagement"/>
    </a>
</li>
