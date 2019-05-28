<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>User用户页面</title>
    <style type="text/css">
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

<div align="center">
    <h3>user贵族</h3>
    &nbsp;&nbsp;<br>
    <a href="${path}/user/logout">安全退出</a>
    <br><br>
    <a href="${path}/user/back">返回选择界面</a>
</div>

<div align="center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>User信息</small>
                </h1>
            </div>
        </div>
    </div>
    <hr>

    <form action="${path}/user/selByLikeU" method="post">
        搜索：<input type="input" id="search" name="search" placeholder="输入姓名" />
        <input type="submit" id="submit" name="submit" value="查询" />
    </form>

    <div class="row clearfix">
        <div class="col-md-12 column">

            <table class="table table-hover table-striped">
        <caption style="text-align: center">登录用户信息（<a href="${path}/user/toaddUser">新增</a>）</caption>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${uList }" var="u" varStatus="i">
            <tr class="row${i.index % 2 + 1 }">
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.type}</td>
                <td>
                    <a href="${path}/user/delUser?id=${u.id }" onclick="return confirm('您是否确认删除${u.username }的信息?')">删除</a>
                    <a href="${path}/user/toUpdUser?id=${u.id }" onclick="return confirm('您是否确认修改${u.username }的信息?')">修改</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    </div>
    </div>

    <div class="page">
        <div class="page-information">
            <b>共${page.recordsNum}</b>条,当前第<span>${page.pageNum}</span>页
            <a href="${path}/user/toforUser?pageNum=1" class='first'>首页</a>
            <a href="${path}/user/toforUser?pageNum=${page.pageNum>1?page.pageNum-1:1}" class='pre'>上一页</a>
            <c:forEach begin="1" end="${page.pageTitle}" var="i">
                <a href="${path}/user/toforUser?pageNum=${i}" style="text-decoration: none;">${i}</a>
            </c:forEach>
            <a href="${path}/user/toforUser?pageNum=${page.pageNum<page.pageTitle?page.pageNum+1:page.pageTitle}" class='next'>下一页</a>
            <a href="${path}/user/toforUser?pageNum=${page.pageTitle}" class='last'>末页</a>
        </div>
    </div>

</div>
</div>
</body>
</html>
