
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
    <a href="${path}/lady/toforLady">返回</a>
    <hr>
    <form action="${path}/lady/addLady" method="post">
        名字：<input type="text" name="lname"><br>
        年龄：<input type="text" name="lage"><br>
        身高：<input type="text" name="lheight"><br>
        体重：
        <select name="lweight" id="lweight">
            <option value="靓丽">靓丽</option>
            <option value="一般">一般</option>
            <option value="蛮肉">蛮肉</option>
            <option value="瘦">瘦</option>
            <option value="标准">标准</option>
        </select>
        <br>

        喜好：
        <select name="lhobby" id="lhobby">
            <option value="努力">努力</option>
            <option value="游戏">游戏</option>
            <option value="消费">消费</option>
            <option value="恋爱">恋爱</option>
            <option value="赚钱">赚钱</option>
            <option value="生活">生活</option>
        </select>
        <br>

        爱色：
        <select name="lcolor" id="lcolor">
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
