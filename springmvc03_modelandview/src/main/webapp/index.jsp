<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
    <script src="http://lib.sinaapp.com/js/jquery/1.4.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                //alert("click");
                $.ajax({
                    //url:"some2.do",
                    url:"some3.do",
                    data:{
                        name:"ibbie",
                        age:"18"
                    },
                    type:"post",
                    dataType:"json",
                    success:function (response) {
                        alert(response.name+"   "+response.age);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>index.jsp</p>
    <form action="some.do" method="post">
        姓名：<input name="name" type="text"><br>
        年龄：<input name="age" type="text"><br>
        <input type="submit">
    </form>

    <p>发起一个ajax请求</p>
    <button id="btn">发起Ajax请求</button>

</body>
</html>
