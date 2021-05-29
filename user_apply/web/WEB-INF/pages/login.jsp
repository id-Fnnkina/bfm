<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员登录界面</title>
    <link href="files/首页/get.css" type="text/css" rel="stylesheet"/>
    <script src="files/管理者登录界面/login.js"></script>
    <script type="text/javascript">

        function KeyDown()
        {
            if (event.keyCode == 13)
            {
                event.returnValue=false;
                event.cancel = true;
                login();
                Form1.btnsubmit.click();
            }
        }


        window.onload=function(){
            login();
        }


    </script>
</head>
<body>
<div id="bg">

    <%--if (login!=1) {--%>
    <%--}%>--%>
    <%--<script type="text/javascript" language="javascript">--%>
        <%--alert("<%=23423%>");                                            // 弹出错误信息--%>
    <%--</script><%}%>--%>
    <div id="title" align="center">
        <p id="title_p" align="center">大数据金融风控系统管理员登录界面</p>
    </div>
    <form id="myform"  name="Form1" action="Control" method="post">
        <div id="title_1">
            <label for="username">
            <span class="text_p">管理者用户名：</span><input id="username" type="text" name="username" onkeydown=KeyDown()>
            </label>
        </div>
        <div id="title_2">
            <label for="password">
            <span title="title_2_p">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span><input id="password" type="password" name="password" onkeydown=KeyDown()>
            </label>
        </div>
        <div id="title_3">
            <button style="width: 100px;background: #4a53dc;height: 35px" type="button" id="login" >登录</button>

        </div>

    </form>
        <div id="title_5"><button style="width: 100px;background: #f6fdff;height: 36px">退出</button></div>
    <div id="title_4">
        <div id="title_4_image1"><img id="img1" src="images/首页/u7.png"></div>
        <div id="title_4_image2"><img id="img2" src="images/首页/logo2.png"></div>
        <div id="title_4_image3"><img id="img3" src="images/首页/u9.png"></div>
    </div>
</div>
</body>
</html>