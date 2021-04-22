<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
    <p>我是index.jsp</p>
    <p><a href="some.do">发起一个some.do请求</a></p>

    <form action="show.do" method="post">
        <input type="submit" value="发起一个show.do的post请求">
    </form>

    <p><a href="other.do">发起一个other.do的get请求</a></p>

    <form action="other.do" method="post">
        <input type="submit" value="发起一个other.do的post请求">
    </form>
</body>
</html>
