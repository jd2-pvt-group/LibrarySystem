<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 28.01.14
  Time: 0:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <title><s:message code="pages.login.title"/></title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/library.css" rel="stylesheet"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body class="login">
    <div class="container">
        <tiles:insertAttribute name="login_form"/>
    </div>
</body>
</html>