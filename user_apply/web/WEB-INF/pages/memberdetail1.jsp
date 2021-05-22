<%@ page import="finance.ideal.domain.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/10
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>联盟成员配置</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="files/loan.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/4、3联盟成员配置/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/4、3联盟成员配置/memberdetail.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/4、3联盟成员配置/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
        #member{
            background: #26afd6;
        }
    </style>
</head>
</head>
<body>
<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u2374" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="999">

        <!-- Unnamed (矩形) -->
        <div id="u2375" class="ax_default shape">
            <div id="u2375_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u2376" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="928">

            <!-- Unnamed (矩形) -->
            <div id="u2377" class="ax_default shape">
                <div id="u2377_div" class=""style="width: 222px"></div>
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
            <div id="u2402" class="ax_default shape">
                <div id="u2402_div" class=""></div>
                <div id="u2402_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u2403" class="ax_default image">
            <img id="u2403_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>
    <%  Member member = (Member)request.getAttribute("member");
        List<String> memberNames = (List<String>)request.getAttribute("memberNames");
        List<String> modelNames = (List<String>)request.getAttribute("modelNames");
        System.out.println("正在进行"+member.getCompanyname()+"详情");
        System.out.println(memberNames.get(1));
    %>
    <!-- 成员职责 (组合) -->
    <div id="background" >
        <div id="b_title">
            <h2 align="center">联盟成员详情</h2>
        </div>
        <div id="b_detail">

            <div id="b_detail_value2" style="">
                <p>
                    成员名称：<%=member.getCompanyname()%>
                </p>
            </div>
            <div id="b_detail_value3">
                <p>
                    成员类型：<%=member.getMembertype()%>
                </p>
            </div>
            <div id="b_detail_value4">
                <p>
                    成员角色：<%=member.getMemberrole()%>
                </p>
            </div>
        </div>
        <div id="b_role1">
            <div id="b_title_1">
                <div id="b_title_1_name">
                    <p id="b_title_1_name_p" align="right">数据提供方信息：</p>
                </div>
            </div>
            <div id="b_title_1_value1">
                <div id="b_title_1_value1_value1">
                    <p id="b_title_1_value1_value1_p" align="right">
                        数据访问接口地址 ：
                    </p>
                </div>
                <div id="b_title_1_value1_value2">
                    <p id="b_title_1_value1_value2_p">
                        <%=member.getMemberinterface()==null?"请填写接口地址":member.getMemberinterface()%>
                    </p>
                </div>
            </div>

            <div id="b_title_1_value2">
                <div id="b_title_1_value2_value1">
                    <p id="b_title_1_value2_value1_p" align="right">
                        可提供数据：
                    </p>
                </div>

                <div id="b_title_1_value2_value2">
                    <table>
                        <%String[] datastructure = member.getDatastructure().split(",");
                            System.out.println(datastructure.length);
                            if (0!=datastructure.length){
                                for (int i = 0; i <datastructure.length ; i=i+3) {
                                    int j=i;
                        %>
                        <tr>
                            <%if (j<datastructure.length){%>
                            <th><div id="b_title_1_table1"><p style="font-size: 8px"><%=datastructure[j]%></p></div></th>
                            <%}%>
                            <%j++;if (j<datastructure.length){%>
                            <th><div id="b_title_1_table2"><p style="font-size: 8px"><%=datastructure[j]%></p></div></th>
                            <%}%>
                            <%j++;if (j<datastructure.length){%>
                            <th><div id="b_title_1_table3"><p style="font-size: 8px"><%=datastructure[j]%></p></div></th>
                            <%}%>
                        </tr>
                        <%}}%>
                        <tr>

                        </tr>
                    </table>
                </div>
            </div>
            <div id="b_title_1_value3">
                <div id="b_title_1_value3_value1">
                    <p id="b_title_1_value3_value1_p" align="right">
                        可输出标签：
                    </p>
                </div>
                <div id="b_title_1_value3_value2">
                    <p id="b_title_1_value3_value2_p">
                        <%=member.getMemberlabel()!=null?member.getMemberlabel():"填写返回标签"%>
                    </p>
                </div>
            </div>
            <div id="b_title_1_button" style="top: 85%;  position:absolute;left:30%">
                <button style="width: 150px;height: 35px;background: #26bed6" type="button"><a  href="./member">返回</a></button>
            </div>
        </div>

    </div>
    <!-- 个人框 (组合) -->
    <div id="u2451" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

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
        <div id="u2452" class="ax_default image" data-label="logo">
            <img id="u2452_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u2454" class="ax_default marker" title="警告数">
            <img id="u2454_img" class="img " src="images/警告数/u340.png"/>
            <div id="u2454_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
