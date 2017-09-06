<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/6
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <tiles:insertAttribute name="hrefBasepath"></tiles:insertAttribute>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title><tiles:getAsString name="title"/></title>

    <!-- css -->
    <tiles:insertAttribute name="commonCss"></tiles:insertAttribute>

    <!-- Javascripts -->
    <tiles:insertAttribute name="commonJs"></tiles:insertAttribute>
</head>
<body>
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
    <tiles:insertAttribute name="menu"></tiles:insertAttribute>
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>
</body>
</html>
