<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title><s:message code="pages.standard.title"/></title>

        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/library.css" rel="stylesheet"/>


        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/library.js"></script>

    </head>
    <body>
        <div class="header">
            <div class="header_content">
                <tiles:insertAttribute name="header"/>
            </div>
        </div>
        <div class="tabbable top_menu">
            <ul class="nav nav-tabs">
                <tiles:insertAttribute name="top_menu"/>
            </ul>
        </div>
        <div class="left_menu">
            <ul class="nav nav-tabs nav-stacked left_menu_action">
                <tiles:insertAttribute name="left_menu"/>
            </ul>
        </div>
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <div class="footer">
            <div class="footer_content">
                <tiles:insertAttribute name="footer"/>
            </div>
        </div>
    </body>
</html>