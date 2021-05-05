<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h1>hello</h1>
    <%--这两个参数在第一次请求的request域中，而第二次请求的request域中并没有这两个参数--%>
    <%--<h4>姓名：${name}</h4>--%>
    <%--<h4>性别：${age}</h4>--%>

    <%--框架将添加的参数放到了第二次的请求参数中，可以从请求参数中取值--%>
    <h4>姓名：${param.name}</h4>
    <h4>年龄：${param.age}</h4>
</body>
</html>
