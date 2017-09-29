<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/29
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
<form action="pic" method="post" enctype="multipart/form-data">
    注册之前先给自己传个图片吧：<input type="file" name="fileupload"/>
    <input type="submit" class="btn_zhuce" value="上传"/>
</form>
</body>
</html>
