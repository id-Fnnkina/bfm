<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/11
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ page import="finance.ideal.domain.Log "%>
    <%@ page import="finance.ideal.domain.State "%>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ page import="finance.ideal.domain.Log" %>
    <%@ page import="finance.ideal.domain.State" %>
    <%@ page import="finance.ideal.util.PageUtil" %>
    <%String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <title>系统日志</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="files/loan1.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/系统日志/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/系统日志/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
        #log{
            background: #26afd6;
        }

    </style>
</head>
</head>
<body>
<div id="base" class="" style="left: -5px;">

    <!-- 背景 (组合) -->
    <div id="u665" class="ax_default" data-label="背景" data-left="-17" data-top="-7" data-width="1342" data-height="1078">

        <!-- Unnamed (矩形) -->
        <div id="u666" class="ax_default shape">
            <div id="u666_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u667" class="ax_default" data-label="列表" data-left="-17" data-top="64" data-width="203" data-height="942">

            <!-- Unnamed (矩形) -->
            <div id="u668" class="ax_defaul shape">
                <div id="u668_div" class=""style="width: 222px"></div>
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
            <div id="u693" class="ax_default shape">
                <div id="u693_div" class=""></div>
                <div id="u693_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u694" class="ax_default image">
            <img id="u694_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- 日志 (组合) -->
    <div id="u695" class="ax_default" data-label="日志" data-left="238" data-top="87" data-width="1017" data-height="984">

        <!-- Unnamed (表格) -->
        <div id="u696" style="left: 300px" class="ax_default">
            <%
                PageUtil page1 = (PageUtil)request.getAttribute("page");
                ArrayList list = (ArrayList) page1.getDataList();
            %>
            <table align = "center" frame="void" rules="all" style="width:100%;border: 1px solid #090607; ">
                <tr style="height:45px ;background:#949e9f" ;frame=void border-bottom: 1px solid red;>
                    <th>业务流水号</th>
                    <th>用户名</th>
                    <th>操作</th>
                    <th>业务时间</th>
                    <th width="70px">备注</th>
                </tr>
                <!-- 继续使用jsp语句 循环放入存放于list中的Book实体类中的数据 -->
                <%
                    for(int i = 0;i<list.size();i++){
                        Log log=(Log)list.get(i);

                %>
                <tr style="height:35px;background: #e7f7ff">
                    <th><%=log.getId()%></th>
                    <th><%=log.getLeader()%></th>
                    <th><%=log.getServicetype()%></th>
                    <th><%=log.getVerifydate()%></th>
                    <th style="color:#38a8ff"></th></tr>
                        <%}%>
                <tr><td class="altbg2" colspan="5" rowspan="2" align="right">
                    <a href="log?action=list&pageIndex=1">首页</a> &#160;&#160;
                    <a href="log?action=list&pageIndex=<%=page1.getPageIndex()-1<1?1:page1.getPageIndex()-1%>">上一页</a>&#160;&#160;
                    &#160;&#160;&#160;第<%=page1.getPageIndex()%>页/共<%=page1.getTotalPageCount()%>页 &#160;&#160;&#160;
                    <a href="log?action=list&pageIndex=<%=page1.getPageIndex()+1>page1.getTotalPageCount()?page1.getPageIndex():page1.getPageIndex()+1%>">下一页</a>&#160;&#160;
                    <a href="log?action=list&pageIndex=<%=page1.getTotalPageCount()%>">末页</a> &#160;&#160;&#160;
                    <div style="float: right; ">
                        共<%=page1.getTotalCount()%>条. 每页显示<%=page1.getPageSize()%>条&#160;&#160;&#160;&#160;
                    </div>
                </td></tr>

            </table>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u752" class="ax_default _标题_1">
            <div id="u752_div" class=""></div>
            <div id="u752_text" class="text ">
                <p><span>系统日志</span></p>
            </div>
        </div>


    </div>

    <!-- 报表 (动态面板) -->
    <div id="u851" class="ax_default ax_default_hidden" data-label="报表" style="display:none; visibility: hidden">
        <div id="u851_state0" class="panel_state" data-label="状态1" style="">
            <div id="u851_state0_content" class="panel_state_content">
                <!-- Unnamed (矩形) -->
                <div id="u852" class="ax_default button">
                    <div id="u852_div" class=""></div>
                    <div id="u852_text" class="text ">
                        <p><span>关闭</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u853" class="ax_default box_1">
                    <div id="u853_div" class=""></div>
                    <div id="u853_text" class="text ">
                        <p><span>报表已导出</span></p>
                    </div>
                </div>
            </div>
        </div>
        <div id="u851_state1" class="panel_state" data-label="状态2" style="visibility: hidden;">
            <div id="u851_state1_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u854" class="ax_default button">
        <div id="u854_div" class=""></div>
        <div id="u854_text" class="text ">
            <p><span><a href="UploadDownloadServlet?method=downloadlog&pageIndex=<%=page1.getPageIndex()%>&pageSize=<%=page1.getPageSize()%>">导出报表</a></span></p>
        </div>
    </div>
    <!-- 个人框 (组合) -->
    <div id="u859" class="ax_default" data-label="个人框" data-left="1160" data-top="78" data-width="147" data-height="36">

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
        <div id="u860" class="ax_default image" data-label="logo">
            <img id="u860_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u862" class="ax_default marker" title="警告数">
            <img id="u862_img" class="img " src="images/警告数/u340.png"/>
            <div id="u862_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>

    </div>
</div>
</body>
</html>
