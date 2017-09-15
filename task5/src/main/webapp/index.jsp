<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <SCRIPT LANGUAGE="JavaScript">
        function gettime(){
            var d = new Date();
            document.getElementById("t").innerHTML =d;
            window.setTimeout("gettime()",1000);
        }
        window.onload = gettime;
    </SCRIPT>
</head>
<body>
<div id="t"></div>
<a href="${pageContext.request.contextPath}/home">首页</a>
</body>
</html>
