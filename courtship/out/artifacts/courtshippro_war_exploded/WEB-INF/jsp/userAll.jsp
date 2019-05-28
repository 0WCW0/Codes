<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>管理使用用户</title>
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
    <a href="${path}/boy/toforBoy">男生信息</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${path}/lady/toforLady">女生信息</a>
</div>

</body>
</html>
