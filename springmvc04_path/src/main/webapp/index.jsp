<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>index.jsp</title>
    <%--写死的base标签--%>
    <%--<base href="http://localhost:8080/springmvc04/">--%>
    <%--动态配置base--%>
    <base href="<%=basePath%>">
</head>
<body>

    关于jsp页面的相对路径问题<br><br>
    1.不带斜杠的路径，如href="some.do"<br>
    &nbsp;&nbsp;参考路径是当前jsp的路径：http://localhost:8080/springmvc04/<br>
    &nbsp;&nbsp;完整的路径是：http://localhost:8080/springmvc04/ + some.do<br>
    <a href="some.do">some.do</a><br>
    <br>
    2.带斜杠的路径，如href="/some.do"<br>
    &nbsp;&nbsp;参考路径是服务器地址：http://localhost:8080/<br>
    &nbsp;&nbsp;完整的路径是：http://localhost:8080/ + some.do<br>
    &nbsp;&nbsp;要想路径正确，需要改为href="/springmvc04/some.do"（不建议使用，不够灵活）<br>
    &nbsp;&nbsp;另一种修改方式，使用EL表达式从pageContext.request.contextPath获取项目路径（推荐）<br>
    修改前：<a href="/some.do">/some.do</a><br>
    修改后：<a href="/springmvc04/some.do">/springmvc04/some.do</a><br>
    修改后：<a href="${pageContext.request.contextPath}/some.do">使用EL表达式/some.do</a><br>
    <br>
    3.不带斜杠，此时没有配置视图解析器，从index.jsp访问index.jsp<br>
    &nbsp;&nbsp;第一次访问user/some2.do：http://localhost:8080/springmvc04/user/some2.do<br>
    &nbsp;&nbsp;第二次访问user/some2.do：http://localhost:8080/springmvc04/user/user/some2.do<br>
    &nbsp;&nbsp;第一次访问后，链接的参考路径变为了http://localhost:8080/springmvc04/user/，导致第二次访问失败<br>
    &nbsp;&nbsp;解决方案：<br>
    &nbsp;&nbsp;&nbsp;&nbsp;1.使用EL表达式<br>
    &nbsp;&nbsp;&nbsp;&nbsp;2.在head标签中使用base标签配置参考路径（基地址），配置后所有不带斜杠的地址都以基地址为参考地址<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果写死base标签，路径也不够灵活，可以使用request动态拼接地址然后在base标签中引用（详见jsp开头）<br>
    <a href="user/some2.do">访问user/some2.do</a>

</body>
</html>
