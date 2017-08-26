<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/8/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>用户信息查询</h4>
<hr>

ID:${student.id}<br/>
姓名:${student.name}<br/>
修真类型:${student.type}<br/>
入学时间:${student.time}<br/>
毕业院校:${student.school}<br/>
线上学号:${student.number}<br/>
日报链接:${student.link}<br/>
立愿:${student.hope}<br/>
辅导师兄:${student.referrer}<br/>
从何处了解到:${student.from_where}<br/>
创建时间:${student.create_at}<br/>
更新时间:${student.update_at}<br/>

<hr>
</body>
</html>
