
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
    <a href="${path}/boy/toforBoy">返回</a>
    <hr>
    <form action="${path}/boy/addBoy" method="post">
        名字：<input type="text" name="bname"><br>
        年龄：<input type="text" name="bage"><br>
        身高：<input type="text" name="bheight"><br>
        体重：
        <select name="bweight" id="bweight">
            <option value="强壮">强壮</option>
            <option value="一般">一般</option>
            <option value="蛮肉">蛮肉</option>
            <option value="瘦">瘦</option>
            <option value="标准">标准</option>
        </select>
        <br>

        喜好：
        <select name="bhobby" id="bhobby">
            <option value="学习">学习</option>
            <option value="游戏">游戏</option>
            <option value="吃喝">吃喝</option>
            <option value="恋爱">恋爱</option>
            <option value="赚钱">赚钱</option>
            <option value="生活">生活</option>
        </select>
        <br>

        爱色：
        <select name="bcolor" id="bcolor">
            <option value="红">红</option>
            <option value="橙">橙</option>
            <option value="黄">黄</option>
            <option value="绿">绿</option>
            <option value="金">金</option>
            <option value="粉">粉</option>
            <option value="蓝">蓝</option>
        </select>
        <br>
        <input type="submit" value="添加">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
