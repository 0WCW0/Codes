
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>新增</title>
</head>
<body>
<div align="center">
    <h3>新增</h3>
    <a href="${path}/user/toforUser">返回</a>
    <hr>
    <form action="${path}/user/addUser" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        类型：
        <select name="type" id="type">
            <option value="1">1</option>
            <option value="0">0</option>
        </select>

        <input type="submit" value="添加">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
