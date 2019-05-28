<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>管理员选择页面</title>

    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<div align="center">
    <h3>管管单身贵族</h3>
    <br>
    <a href="${path}/user/logout">安全退出</a>
    <br><br><br>
</div>

<div align="center">
    <a href="${path}/user/toforUser">管理User用户</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${path}/user/touserAll">管理Boy和Lady用户</a>
</div>

</body>
</html>
