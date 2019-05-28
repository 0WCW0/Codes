<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>女信息页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        h3 {
            width: 180px;
            height: 38px;
            margin: 70px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">

    <div align="center">
        <h3>女贵族</h3>
        &nbsp;&nbsp;<br>
        <a href="${path}/user/logout">安全退出</a>
        <br><br>
        <a href="${path}/lady/back">返回选择界面</a>
    </div>

    <div align="center">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>女生信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <hr>

        <form action="${path}/lady/toselByLikeL" method="post">
            搜索：<input type="input" id="search" name="search" placeholder="输入姓名" />
            <input type="submit" id="submit" name="submit" value="查询" />
        </form>

        <div class="row clearfix">
            <div class="col-md-12 column">

                <table class="table table-hover table-striped">
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>身高</th>
                        <th>体重</th>
                        <th>喜好</th>
                        <th>爱色</th>
                    </tr>
                    <c:forEach items="${lList }" var="l" varStatus="i">
                        <tr class="row${i.index % 2 + 1 }">
                            <td>${l.lid}</td>
                            <td>${l.lname}</td>
                            <td>${l.lage}</td>
                            <td>${l.lheight}</td>
                            <td>${l.lweight}</td>
                            <td>${l.lhobby}</td>
                            <td>${l.lcolor}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>

        <div class="page">
            <div class="page-information">
                <b>共${page.recordsNum}</b>条,当前第<span>${page.pageNum}</span>页
                <a href="${path}/lady/uforLady?pageNum=1" class='first'>首页</a>
                <a href="${path}/lady/uforLady?pageNum=${page.pageNum>1?page.pageNum-1:1}" class='pre'>上一页</a>
                <c:forEach begin="1" end="${page.pageTitle}" var="i">
                    <a href="${path}/lady/uforLady?pageNum=${i}" style="text-decoration: none;">${i}</a>
                </c:forEach>
                <a href="${path}/lady/uforLady?pageNum=${page.pageNum<page.pageTitle?page.pageNum+1:page.pageTitle}" class='next'>下一页</a>
                <a href="${path}/lady/uforLady?pageNum=${page.pageTitle}" class='last'>末页</a>
            </div>
        </div>

    </div>
</div>
</body>
</html>
