<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
    <p>参数名一致</p>
    <form action="getReqParam.do" method="post">
        姓名：<input type="text" name="name" ><br>
        年龄<input type="text" name="age" ><br>
        <input type="submit" value="提交">
    </form>

    <p>参数名不一致</p>
    <form action="getReqParam2.do" method="get">
        姓名：<input type="text" name="myname" ><br>
        年龄<input type="text" name="myage" ><br>
        <input type="submit" value="提交">
    </form>

    <p>控制器使用对象接收参数</p>
    <form action="user.do" method="port">
        姓名：<input type="text" name="name" ><br>
        年龄<input type="text" name="age" ><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
