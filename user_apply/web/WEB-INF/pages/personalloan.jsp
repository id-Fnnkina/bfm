<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/3
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>

<%--个人贷款信用评估业务--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人贷款信用评估</title>
    <%@page import="finance.ideal.domain.PrettyLoan "%>
    <%@page import="finance.ideal.util.PageUtil "%>
    <%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="files/loan.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/区块链查询统计/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/区块链查询统计/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
        .th{width:100px;}
        #personalloan{
            background: #26afd6;
        }
        .ax_default1:hover{
            background: #26afd6;
        }
        button:hover{
            background: #0a6cd6;
        }
        div.file input{position:absolute;left:0px;top:0px;zoom:1;filter:alpha(opacity=0);opacity:0;font-size:20px;margin-left:-240px}
    </style>
</head>
<body>

<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u1065" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="962">

        <!-- Unnamed (矩形) -->
        <div id="u1066" class="ax_default shape">
            <div id="u1066_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u1067" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="891">

            <!-- Unnamed (矩形) -->
            <div id="u1068" class="ax_default shape">
                <div id="u1068_div" class=""style="width: 222px"></div>
            </div>
            <style>
                .loan:hover{
                    background: #26afd6;
                }
            </style>
            <!--标题-->
            <div style="position:relative;top: 118px;">
                <div id="service_1" >
                    <div id="title_1" >
                        <p class="title_p">金融风险评估业务</p>
                        <%--<img class="loan_img" src="images/moban/u143.png"/>--%>
                        <%--<p class="title_p">系统管理</p>--%>
                        <img class="title_img" style="top: 5px;" src="images/moban/title-1.png"/>
                    </div>
                    <div id="title_1_content" >
                        <div id="netloan"class="loan"  style="">
                            <p class="text_p"><a href="./netloan?buinesstype=netloan">网贷平台风险评估</a></p>
                            <img class="loan_img" src="images/moban/u143.png"/>
                        </div>

                        <div id="enterprise" class="loan" >
                            <p class="text_p" ><a href="./enterprise?buinesstype=enterprise">企业经营风险评估</a></p>
                            <img class="loan_img" src="images/moban/u143.png"/>
                        </div>
                        <div id="personaloperator" class="loan">
                            <p class="text_p" ><a href="./personaloperator?buinesstype=personaloperator">个人运营商信用风险评估</a></p>
                            <img  class="loan_img" src="images/moban/u143.png"/>
                        </div>
                        <div id="personalloan" class="loan">
                            <p class="text_p"style=""><a href="./personalloan?buinesstype=personalloan">个人贷款信用评估</a></p>
                            <img class="loan_img" style=" "  src="images/moban/u143.png"/>
                        </div>
                    </div>
                </div>
                <div id="service_2" >
                    <div id="title_2" >
                        <p class="title_p">系统管理</p>
                        <%--<img class="loan_img" src="images/moban/u143.png"/>--%>
                        <%--<p class="title_p">系统管理</p>--%>
                        <img class="title_img" src="images/moban/title-2.png"/>
                    </div>
                    <div id="title_2_content" >
                        <div id="member"class="loan" >
                            <p class="text_p"><a href="./member">联盟成员管理</a></p>
                            <img class="loan_img" src="images/moban/u143.png"/>
                        </div>

                        <div id="workplace" class="loan" >
                            <p class="text_p" ><a href="./workplace">金融风险防控任务管理</a></p>
                            <img class="loan_img" src="images/moban/u143.png"/>
                        </div>
                        <div id="chaincode" class="loan">
                            <p class="text_p" ><a href="./chaincode">区块链查询管理</a></p>
                            <img  class="loan_img" src="images/moban/u143.png"/>
                        </div>
                        <div id="model" class="loan">
                            <p class="text_p"><a href="./model">评估模型管理</a></p>
                            <img class="loan_img" style=" "  src="images/moban/u143.png"/>
                        </div>
                        <div id="Dashboard" class="loan">
                            <p class="text_p"><a href="./Dashboard">综合报表</a></p>
                            <img class="loan_img" style=" "  src="images/moban/u143.png"/>
                        </div>

                        <div id="log" class="loan">
                            <p class="text_p"><a href="./log">系统日志</a></p>
                            <img class="loan_img" style=" "  src="images/moban/u143.png"/>
                        </div>
                    </div>
                </div>

            </div>
        </div>
            <!-- Unnamed (矩形) -->
            <div id="u1093" class="ax_default1 shape">
                <div id="u1093_div" class=""></div>
                <div id="u1093_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u1094" class="ax_default image">
            <img id="u1094_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- 区块链查询 (组合) -->
    <div id="u1095" class="ax_default" data-label="区块链查询" data-left="213" data-top="74" data-width="1129" data-height="839">

        <!-- Unnamed (组合) -->
        <div id="u1096" class="ax_default" data-left="213" data-top="136" data-width="1129" data-height="74">

            <!-- Unnamed (组合) -->
            <div id="u1098" class="ax_default" data-left="278" data-top="158" data-width="345" data-height="52">

            </div>
            <div id="u1226" class="ax_default _标题_1" style=" position:relative;top: 100px;left: 600px">
                <div id="u1226_text" class="text ">
                    <p><span>  个人贷款信用评估</span></p>
                </div>
            </div>

        </div>

        <!-- Unnamed (组合) -->
        <div id="u1106" class="ax_default" data-left="326" data-top="220" data-width="116" data-height="26">

        <!-- Unnamed (矩形) -->

        <div id="g1137" style="top: 350px">
            <%
                PageUtil page1 = (PageUtil)request.getAttribute("page");
                ArrayList list = (ArrayList) page1.getDataList();
            %>
            <!-- 声明一个表格,这是表头 -->
            <table align = "center" frame="void" rules="all" style="width:80%;border: 1px solid #090607; ">
                <tr style="height:50px ;background:#949e9f" ;frame=void border-bottom: 1px solid red;>
                    <th width="150px">任务编码</th>
                    <th width="140px">评估时间</th>
                    <th >评估记录数</th>
                    <th >成功记录数</th>
                    <th >碰撞成功率</th>
                    <th width="140px">评估成功率</th>
                    <th width="100px">任务状态</th>
                    <th width="100px">结果输出</th>
                </tr>
                <!-- 继续使用jsp语句 循环放入存放于list中的Book实体类中的数据 -->
                <%
                    for(int i = 0;i<list.size();i++){
                        PrettyLoan prettyLoan = (PrettyLoan) list.get(i);
                if(prettyLoan!=null){%>
                <tr style="height:40px ;background:#f0fff6" ;>
                    <th><%=prettyLoan.getId()%></th>
                    <th><%=prettyLoan.getTime()%></th>
                    <th ><%=prettyLoan.getCount()%></th>
                    <th ><%=prettyLoan.getCountSucceis()%></th>
                    <th ><%=prettyLoan.getCollisionPercentage()==null?"历史记录不存在":prettyLoan.getCollisionPercentage()%></th>
                    <th ><%=prettyLoan.getBusinessNameSc()+":"+prettyLoan.getScGetCount()%></th>

                    <th ><%=prettyLoan.getStatus()%></th>
                    <th style="color:#38a8ff">
                        下载：<a href="UploadDownloadServlet?method=downloadfile&methodid=1&id=<%=prettyLoan.getId()%>">导出报表</a>

                    </th>
                </tr>
                <% }}
                %>
                <tr><td class="altbg2" colspan="8" rowspan="2" align="right">
                    <a href="personalloan?action=list&pageIndex=1">首页</a> &#160;&#160;
                    <a href="personalloan?action=list&pageIndex=<%=page1.getPageIndex()-1<1?1:page1.getPageIndex()-1%>">上一页</a>&#160;&#160;
                    &#160;&#160;&#160;第<%=page1.getPageIndex()%>页/共<%=page1.getTotalPageCount()%>页 &#160;&#160;&#160;
                    <a href="personalloan?action=list&pageIndex=<%=page1.getPageIndex()+1>page1.getTotalPageCount()?page1.getPageIndex():page1.getPageIndex()+1%>">下一页</a>&#160;&#160;
                    <a href="personalloan?action=list&pageIndex=<%=page1.getTotalPageCount()%>">末页</a> &#160;&#160;&#160;
                    <div style="float: right; ">
                        共<%=page1.getTotalCount()%>条. 每页显示<%=page1.getPageSize()%>条&#160;&#160;&#160;&#160;
                    </div>
                </td></tr>

            </table>
            <br>
            <br>
            <br>

        </div>
    </div>

    <!-- 个人框 (组合) -->
    <div id="u1233" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

        <div id="nav">
            <nav class="container">
                <ul>
                    <li>
                        <a>个人中心</a>
                        <ul>
                            <li><a href="./RegisterController">注销</a></li>
                            <li>个人中心</li>
                        </ul>
                </ul>
            </nav>
        </div>

        <!-- logo (图像) -->
        <div id="u1234" class="ax_default image" data-label="logo">
            <img id="u1234_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u1236" class="ax_default marker" title="警告数">
            <img id="u1236_img" class="img " src="images/警告数/u340.png"/>
            <div id="u1236_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>
    </div>
        <div style="position: relative;top: 200px;left: 325px;width: 880px;height: 120px;background: #e0e0e0">
            <div style="position: absolute;left: 20%;width: 60%" align="center"><h2>批量任务导入</h2>
            <p>
                功能介绍：请按模板格式导入个人贷款信用评估信息进行批量风险评估。
            </p></div>
            <div style="position:absolute;top:80px ;left: 10%;width: 20%;height: 35px; "align="center">
                <button><a href="UploadDownloadServlet?method=downpersonalloanmodel">下载模板</a></button><br>
            </div>
            <div style="position:absolute;top:80px ;left: 40%;width: 10%;height: 35px;"align="center">
                <%--<div class="file">选择数据文件<input type="file" name="myfiles" id="upload-file"/></div>--%>
                <input STYLE="color: #0a6cd6" type="file" placeholder="选择数据文件" id="upload-file">
            </div>
            <div style="position:absolute;top:80px ;left: 60%;width: 20%;height: 35px;"align="center">
                <button id="start-upload" onclick="uploadFile();">开始上传</button>
            </div>
        </div>
</div>
</div>
</body>
</html>

<script type="text/javascript">

    function uploadFile(){
        var fileObj = document.getElementById("upload-file").files[0]; // 获取文件对象
        var FileController = "FileSelectServlet?modeltype=PersonalLoancount"; // 接收上传文件的后台地址
        if(fileObj){
            alert("文件正在上传！");
            showdiv('表单数据提交中');
            // FormData 对象
            var form = new FormData();
            form.append("file", fileObj);// 文件对象
            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function () {
                alert("文件已上传完成！");
                window.document.location.href="personalloan";
                closediv();
            };
            xhr.send(form);
        }else{
            alert("未选择文件！");
        }
    }


    //关闭等待窗口
    function closediv()
    {
        //CloseDiv
        document.body.removeChild(document.getElementById("bgDiv"));
        document.getElementById("msgDiv").removeChild(document.getElementById("msgTitle"));
        document.body.removeChild(document.getElementById("msgDiv"));
    }
    //显示等待窗口
    function showdiv(str)
    {
        var msgw, msgh, bordercolor;
        msgw = 400; //提示窗口的宽度
        msgh = 100; //提示窗口的高度
        bordercolor = "#336699";//提示窗口的边框颜色
        titlecolor = "#99CCFF";//提示窗口的标题颜色

        var sWidth, sHeight;
        sWidth = window.screen.availWidth;
        sHeight = window.screen.availHeight;

        var bgObj = document.createElement("div");
        bgObj.setAttribute('id', 'bgDiv');
        bgObj.style.position = "absolute";
        bgObj.style.top = "0";
        bgObj.style.background = "#777";
        bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
        bgObj.style.opacity = "0.6";
        bgObj.style.left = "0";
        bgObj.style.width = sWidth + "px";
        bgObj.style.height = sHeight + "px";
        document.body.appendChild(bgObj);
        var msgObj = document.createElement("div")
        msgObj.setAttribute("id", "msgDiv");
        msgObj.setAttribute("align", "center");
        msgObj.style.position = "absolute";
        msgObj.style.background = "white";
        msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
        msgObj.style.border = "1px solid " + bordercolor;
        msgObj.style.width = msgw + "px";
        msgObj.style.height = msgh + "px";
        msgObj.style.top = (document.documentElement.scrollTop + (sHeight - msgh) / 2) + "px";
        msgObj.style.left = (sWidth - msgw) / 2 + "px";
        var title = document.createElement("h4");
        title.setAttribute("id", "msgTitle");
        title.setAttribute("align", "right");
        title.style.margin = "0";
        title.style.padding = "3px";
        title.style.background = bordercolor;
        title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20,startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
    title.style.opacity = "0.75";
    title.style.border = "1px solid " + bordercolor;
    title.style.height = "18px";
    title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
    title.style.color = "white";
    //title.style.cursor= "pointer";
    //title.innerHTML= "关闭";
    //title.onclick= closediv;
    document.body.appendChild(msgObj);
    document.getElementById("msgDiv").appendChild(title);
    var txt = document.createElement("p");
    txt.style.margin = "1em0";
    txt.setAttribute("id", "msgTxt");
    txt.innerHTML = str;
    document.getElementById("msgDiv").appendChild(txt);
    }
    //屏蔽F5
    document.onkeydown
        = mykeydown;
    function mykeydown()
    {
        if (event.keyCode == 116) //屏蔽F5刷新键
        {
            window.event.keyCode
                = 0;
            return false;
        }
    }




</script>
