<%@ page language="java" contentType="text/html; charset=utf-8"  isErrorPage="true" pageEncoding="utf-8"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>错误提示</title>
</head>
<body>
<div id="wrapper">
    <a href="http://ow.blizzard.cn/home/"><img class="fade" src="${pageContext.request.contextPath}/static/images/444.png"></a>
    <div>
        <h1 class="fade">温馨提示：您访问的地址不存在！</h1>
        <p class="fade">你正在寻找的页面无法找到。
            <a style="opacity: 1;" class="link" href="/student/list" onclick="history.go(-1)">返回?</a></p>

    </div>
</div>
</body>
</html>

