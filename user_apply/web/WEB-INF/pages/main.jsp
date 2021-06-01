<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/10
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <%@page import="finance.ideal.util.Utils "%>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ page import="finance.ideal.domain.P2PCompany" %>
    <%@ page import="finance.ideal.domain.Member" %>
    <%String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <title>联盟成员列表</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="files/loan.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <%--<link href="files/title.css" type="text/css" rel="stylesheet"/>--%>
    <link href="files/1、联盟成员列表/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/1、联盟成员列表/ubdatestyles.css" type="text/css" rel="stylesheet"/>

    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/1、联盟成员列表/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
    </style>
</head>
</head>
<body>
<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u1917" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="754"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   >

        <!-- Unnamed (矩形) -->
        <div id="u1918" class="ax_default shape">
            <div id="u1918_div"STYLE="height: 1000px" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u1919" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="683">

            <!-- Unnamed (矩形) -->
            <div id="u1920" class="ax_default shape">
                <div id="u1920_div" STYLE="height: 1000px;width: 222px" class=""></div>
            </div>

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
            <!-- Unnamed (矩形) -->
            <div id="u1945" class="ax_default shape">
                <div id="u1945_div" class=""></div>
                <div id="u1945_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u1946" class="ax_default image">
            <img id="u1946_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>


    <!-- 联盟成员 (组合) -->
    <div id="u1947" class="ax_default" data-label="联盟成员" data-left="262" data-top="77" data-width="1060" data-height="633">

        <!-- 整体 (组合) -->
        <div id="u1948" class="ax_default" data-label="整体" data-left="262" data-top="77" data-width="1043" data-height="558">
            <%
                Utils utils = new Utils();
                ArrayList<Object> list=(ArrayList) request.getAttribute("list");
            %>
            <!-- 快牛金科 (组合) -->
            <!-- 个人框 (组合) -->
            <div id="u1970" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

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
                <div id="u1971" class="ax_default image" data-label="logo">
                    <img id="u1971_img" class="img " src="images/警告数/logo_u338.png"/>
                </div>

                <!-- Unnamed (水滴) -->
                <div id="u1973" class="ax_default marker" title="警告数">
                    <img id="u1973_img" class="img " src="images/警告数/u340.png"/>
                    <div id="u1973_text" class="text ">
                        <p><span>10</span></p>
                    </div>
                </div>
            </div>
            <div>
                <div style="position: absolute; top: 220px;">
                    <div class="business" style="position: absolute;top: 0px;left: 240px;">
                        <div class="business_img" ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title" ><a href="./member">联盟成员管理</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</div><br>

                    </div>
                    <div class="business" style="position: absolute;top: 0px;left: 590px;">
                        <div  class="business_img" ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title" ><a href="./workplace">金融风险防控任务管理</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp管理金融风险防控，查看业务详情.....................................................................</div><br>

                    </div>
                    <div class="business"style="position: absolute;top: 0px;left: 930px;">
                        <div class="business_img"  ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title" style=""><a href="./chaincode">区块链查询管理</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp管理区块链业务，查看区块链内容详情.....................................................................</div><br>

                    </div>
                </div>

                <div style="position: absolute; top: 420px;">
                    <div class="business" style="position: absolute;top: 0px;left: 240px;">
                        <div class="business_img" ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title" ><a href="./model">评估模型管理</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp管理评估模型的配置，添加模型以及查看模型详情.....................................................................</div><br>

                    </div>
                    <div class="business" style="position: absolute;top: 0px;left: 590px;">
                        <div class="business_img" ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title" ><a href="./Dashboard">综合报表</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查看业务的走势，以及业务使用详情.....................................................................</div><br>

                    </div>
                    <div class="business" style="position: absolute;top: 0px;left: 930px;">
                        <div class="business_img"  ><img src="images/1、联盟成员列表/u1957.png"></div>
                        <div class="business_Title"><a href="./log">系统日志</a></div>
                        <div class="business_describe" >描述： <br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查看历史操作，以及人员登陆状态.....................................................................</div><br>

                    </div>
                </div>
            </div>


        </div>

        <!-- Unnamed (矩形) -->
        <div id="u2066" class="ax_default _标题_1">
            <div id="u2066_text" class="text ">
                <p><span style="font-family: '黑体 Bold', '黑体'">欢迎进入管理员管理界面</span></p>
            </div>
        </div>

    </div>
</div>
</body>
</html>
