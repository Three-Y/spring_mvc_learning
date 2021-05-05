<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>index</h1>
    <a href="doForward.do">doForward.do请求</a><br>

    <p>重定向</p>
    <form action="doRedirect.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit">
    </form>
</body>
</html>
