<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/2
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理主界面</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/管理主界面/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/loan.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/管理主界面/data.js"></script>
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
    <div id="u354" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="754">

        <!-- Unnamed (矩形) -->
        <div id="u355" class="ax_default shape">
            <div id="u355_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u358" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="683">

            <!-- 背景 (矩形) -->
            <div id="u359" class="ax_default shape">
                <div id="u359_div" class=""style="width: 222px"></div>
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
                        <p >一、金融风险评估业务</p>
                    </div>
                    <div id="title_1_content" >
                        <div id="netloan"class="loan"  style="">
                            <p class="text_p"><a href="./netloan?buinesstype=netloan">1.1 网贷平台风险评估</a></p>
                            <!--<img class="loan_img" src="images/moban/u143.png"/>-->
                        </div>

                        <div id="enterprise" class="loan" >
                            <p class="text_p" ><a href="./enterprise?buinesstype=enterprise">1.2 企业经营风险评估</a></p>
                            <!--<img class="loan_img" src="images/moban/u143.png"/>-->
                        </div>
                        <div id="personaloperator" class="loan">
                            <p class="text_p" ><a href="./personaloperator?buinesstype=personaloperator">1.3 个人运营商信用风险评估</a></p>
                            <!--<img  class="loan_img" src="images/moban/u143.png"/>-->
                        </div>
                        <div id="personalloan" class="loan">
                            <p class="text_p"style=""><a href="./personalloan?buinesstype=personalloan">1.4 个人贷款信用评估</a></p>
                            <!--<img class="loan_img" style=" "  src="images/moban/u143.png"/>-->
                        </div>
                    </div>
                </div>
                <div id="service_2" >
                    <div id="title_2" >
                        <p >二、系统管理</p>
                    </div>
                    <div id="title_2_content" >
                        <div id="member"class="loan" >
                            <p class="text_p"><a href="./member">2.1 联盟成员管理</a></p>
                            <!--<img class="loan_img" src="images/moban/u143.png"/>-->
                        </div>

                        <div id="workplace" class="loan" >
                            <p class="text_p" ><a href="./workplace">2.2 金融风险防控任务管理</a></p>
                            <!--<img class="loan_img" src="images/moban/u143.png"/>-->
                        </div>
                        <div id="chaincode" class="loan">
                            <p class="text_p" ><a href="./chaincode">2.3 区块链查询管理</a></p>
                            <!--<img  class="loan_img" src="images/moban/u143.png"/>-->
                        </div>
                        <div id="model" class="loan">
                            <p class="text_p"><a href="./model">2.4 评估模型管理</a></p>
                            <!--<img class="loan_img" style=" "  src="images/moban/u143.png"/>-->
                        </div>
                        <div id="Dashboard" class="loan">
                            <p class="text_p"><a href="./Dashboard">2.5 综合报表</a></p>
                            <!--<img class="loan_img" style=" "  src="images/moban/u143.png"/>-->
                        </div>

                        <div id="log" class="loan">
                            <p class="text_p"><a href="./log">2.6 系统日志</a></p>
                            <!--<img class="loan_img" style=" "  src="images/moban/u143.png"/>-->
                        </div>
                    </div>
                </div>

            </div>
        </div>

            <!-- Unnamed (矩形) -->
            <div id="u384" class="ax_default shape">
                <div id="u384_div" class=""></div>
                <div id="u384_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u385" class="ax_default image">
            <img id="u385_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- 管理 (组合) -->
    <div id="u386" class="ax_default" data-label="管理" data-left="224" data-top="96" data-width="1085" data-height="425">

        <!-- 成员 (组合) -->
        <div id="u387" class="ax_default" data-label="成员" data-left="224" data-top="239" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u388" class="ax_default shape">
                <div id="u388_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u389" class="ax_default line">
                <img id="u389_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u390" class="ax_default paragraph" title="点击查看">
                <div id="u390_div" class=""></div>
                <div id="u390_text" class="text ">
                    <p><span>联盟成员管理</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u391" class="ax_default paragraph" title="点击查看">
                <div id="u391_div" class=""></div>
                <div id="u391_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u392" class="ax_default paragraph" title="点击查看">
                <div id="u392_div" class=""></div>
                <div id="u392_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u393" class="ax_default _标题_1">
            <div id="u393_div" class=""></div>
            <div id="u393_text" class="text ">
                <p><span>欢迎进入管理员管理界面</span></p>
            </div>
        </div>

        <!-- 风险防控 (组合) -->
        <div id="u394" class="ax_default" data-label="风险防控" data-left="596" data-top="239" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u395" class="ax_default shape">
                <div id="u395_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u396" class="ax_default line">
                <img id="u396_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u397" class="ax_default paragraph" title="点击查看">
                <div id="u397_div" class=""></div>
                <div id="u397_text" class="text ">
                    <p><span>金融风险防控任务管理</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u398" class="ax_default paragraph" title="点击查看">
                <div id="u398_div" class=""></div>
                <div id="u398_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u399" class="ax_default paragraph" title="点击查看">
                <div id="u399_div" class=""></div>
                <div id="u399_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>

        <!-- 区块链查询 (组合) -->
        <div id="u400" class="ax_default" data-label="区块链查询" data-left="965" data-top="239" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u401" class="ax_default shape">
                <div id="u401_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u402" class="ax_default line">
                <img id="u402_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u403" class="ax_default paragraph" title="点击查看">
                <div id="u403_div" class=""></div>
                <div id="u403_text" class="text ">
                    <p><span>区块链查询管理</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u404" class="ax_default paragraph" title="点击查看">
                <div id="u404_div" class=""></div>
                <div id="u404_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u405" class="ax_default paragraph" title="点击查看">
                <div id="u405_div" class=""></div>
                <div id="u405_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>

        <!-- 评估模型查询 (组合) -->
        <div id="u406" class="ax_default" data-label="评估模型查询" data-left="224" data-top="400" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u407" class="ax_default shape">
                <div id="u407_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u408" class="ax_default line">
                <img id="u408_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u409" class="ax_default paragraph" title="点击查看">
                <div id="u409_div" class=""></div>
                <div id="u409_text" class="text ">
                    <p><span>评估模型管理</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u410" class="ax_default paragraph" title="点击查看">
                <div id="u410_div" class=""></div>
                <div id="u410_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u411" class="ax_default paragraph" title="点击查看">
                <div id="u411_div" class=""></div>
                <div id="u411_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>

        <!-- Dashboard (组合) -->
        <div id="u412" class="ax_default" data-label="Dashboard" data-left="597" data-top="400" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u413" class="ax_default shape">
                <div id="u413_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u414" class="ax_default line">
                <img id="u414_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u415" class="ax_default paragraph" title="点击查看">
                <div id="u415_div" class=""></div>
                <div id="u415_text" class="text ">
                    <p><span>Dashboard</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u416" class="ax_default paragraph" title="点击查看">
                <div id="u416_div" class=""></div>
                <div id="u416_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u417" class="ax_default paragraph" title="点击查看">
                <div id="u417_div" class=""></div>
                <div id="u417_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>

        <!-- 系统日志 (组合) -->
        <div id="u418" class="ax_default" data-label="系统日志" data-left="965" data-top="400" data-width="344" data-height="121">

            <!-- Unnamed (矩形) -->
            <div id="u419" class="ax_default shape">
                <div id="u419_div" class=""></div>
            </div>

            <!-- Unnamed (横线) -->
            <div id="u420" class="ax_default line">
                <img id="u420_img" class="img " src="images/moban/u169.png"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u421" class="ax_default paragraph" title="点击查看">
                <div id="u421_div" class=""></div>
                <div id="u421_text" class="text ">
                    <p><span>系统日志</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u422" class="ax_default paragraph" title="点击查看">
                <div id="u422_div" class=""></div>
                <div id="u422_text" class="text ">
                    <p><span>描述：</span></p>
                </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u423" class="ax_default paragraph" title="点击查看">
                <div id="u423_div" class=""></div>
                <div id="u423_text" class="text ">
                    <p><span>管理联盟成员的配置，添加成员以及查看成员详情.....................................................................</span></p>
                </div>
            </div>
        </div>
    </div>

    <!-- 个人框 (组合) -->
    <div id="u424" class="ax_default" data-label="个人框" data-left="1180" data-top="77" data-width="147" data-height="36">

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
        <div id="u425" class="ax_default image" data-label="logo">
            <img id="u425_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u427" class="ax_default marker" title="警告数">
            <img id="u427_img" class="img " src="images/警告数/u340.png"/>
            <div id="u427_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>