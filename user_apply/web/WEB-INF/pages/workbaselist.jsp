<%@ page import="finance.ideal.domain.Applicant" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/3
  Time: 10:06
  To change this template use File | Settings | File Templates.
  金融业务单条信息详情
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>金融风控单条业务信息查询详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="files/区块链查询详情/loan.css" type="text/css" rel="stylesheet"/>
    <link href="files/区块链查询详情/workbaselistlook.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/区块链查询详情/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/区块链查询详情/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
        #workplace{
            background: #26afd6;
        }
        .ax_defaul1{
            background: #26afd6;
        }
        .ax_default1:hover{
            background: #26afd6;
        }
    </style>
</head>
<body>
<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u1237" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="982">

        <!-- Unnamed (矩形) -->
        <div id="u1238" class="ax_default shape">
            <div id="u1238_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u1239" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="911">

            <!-- Unnamed (矩形) -->
            <div id="u1240" class="ax_default shape">
                <div id="u1240_div" class=""style="width: 222px"></div>
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
            <div id="u1265" class="ax_default shape">
                <div id="u1265_div" class=""></div>
                <div id="u1265_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u1266" class="ax_default image">
            <img id="u1266_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- 区块链详情 (组合) -->
    <div id="u1267" class="ax_default" data-label="区块链详情" data-left="386" data-top="80" data-width="591" data-height="863">
        <% Applicant applicant =(Applicant)request.getAttribute("applicant");
        System.out.println(applicant.getDwname());%>
        <div id="companylook">
            <!-- ID: -->
            <div id="c_id">
                <div id="c_id_key">
                    <p id="c_id_key_text" align="right">ID:</p>
                </div>
                <div id="c_id_value">
                    <p id="c_id_value_text" align="center"><%=applicant.getId()%></p>
                </div>
            </div>
            <!-- 平台名称: -->
            <div id="c_company">
                <div id="c_company_key">
                    <p id="c_company_text" align="right">用户姓名:</p>
                </div>
                <div id="c_company_value">
                    <p id="c_company_value_text" align="center">
                        <%=applicant.getUname()%></p>
                </div>
            </div>

            <div id="c_time">
                <div id="c_time_key">
                    <p id="c_time_key_text" align="right">用户手机号:</p>
                </div>
                <div id="c_time_value">
                    <p id="c_time_value_text" align="center">
                        <%=applicant.getUphone()%>
                    </p>
                </div>
            </div>

            <div id="c_place">
                <div id="c_place_key">
                    <p id="c_place_key_text" align="right">身份证号:</p>
                </div>
                <div id="c_place_value">
                    <p id="c_place_value_text" align="center">
                        <%=applicant.getIdnumber()%>
                    </p>
                </div>
            </div>

            <div id="c_term">
                <div id="c_term_key">
                    <p id="c_term_key_text" align="right">居住地址:</p>
                </div>
                <div id="c_term_value">
                    <p id="c_term_value_text" align="center">
                        <%=applicant.getAddress()%>
                    </p>
                </div>
            </div>

            <div id="c_average">
                <div id="c_average_key">
                    <p id="c_average_key_text" align="right">联系人:</p>
                </div>
                <div id="c_average_value">
                    <p id="c_average_value_text" align="center">
                        <%=applicant.getPeople()%>
                    </p>
                </div>
            </div>

            <div id="c_score">
                <div id="c_score_key">
                    <p id="c_score_key_text" align="right">工作公司:</p>
                </div>
                <div id="c_score_value">
                    <p id="c_score_value_text" align="center">
                        <%=applicant.getDwname()%>
                    </p>
                </div>
            </div>

            <div id="c_money">
                <div id="c_money_key">
                    <p id="c_money_key_text" align="right">公司电话:</p>
                </div>
                <div id="c_money_value">
                    <p id="c_money_value_text" align="center">
                        <%=applicant.getDwphone()%>
                    </p>
                </div>
            </div>
            <!-- 股权上市-->
            <div id="c_equity">
                <div id="c_equity_key">
                    <p id="c_equity_key_text" align="right">工作行业:</p>
                </div>
                <div id="c_equity_value">
                    <p id="c_equity_value_text" align="center">
                        <%=applicant.getWork()%>
                    </p>
                </div>
            </div>
            <!-- 银行存管-->
            <div id="c_bank">
                <div id="c_bank_key">
                    <p id="c_bank_key_text" align="right">教育学历:</p>
                </div>
                <div id="c_bank_value">
                    <p id="c_bank_value_text" align="center">
                        <%=applicant.getXueli()%>
                    </p>
                </div>
            </div>
            <!-- 融资记录-->
            <div id="c_finance">
                <div id="c_finance_key">
                    <p id="c_finance_key_text" align="right">婚姻状况:</p>
                </div>
                <div id="c_finance_value">
                    <p id="c_finance_value_text" align="center">
                        <%=applicant.getIsdog()%>
                    </p>
                </div>
            </div>
            <!-- 监管协会-->
            <div id="c_regulatory">
                <div id="c_regulatory_key">
                    <p id="c_regulatory_key_text" align="right">借钱用途:</p>
                </div>
                <div id="c_regulatory_value">
                    <p id="c_regulatory_value_text"  align="center">
                        <%=applicant.getYt()%>
                    </p>
                </div>
            </div>
            <!-- ICP号-->
            <div id="c_icp">
                <div id="c_icp_key">
                    <p id="c_icp_key_text" align="right">还款来源:</p>
                </div>
                <div id="c_icp_value">
                    <p id="c_icp_value_text" align="center">
                        <%=applicant.getLy()%>
                    </p>
                </div>
            </div>
            <!-- 自动投标-->
            <div id="c_bidding">
                <div id="c_bidding_key">
                    <p id="c_bidding_key_text" align="right">业务流水号:</p>
                </div>
                <div id="c_bidding_value">
                    <p id="c_bidding_value_text" align="center">
                        <%=applicant.getOrdernum()%>
                    </p>
                </div>
            </div>
            <!-- 自动投标-->
            <div id="c_servicetype">
                <div id="c_servicetype_key">
                    <p id="c_servicetype_key_text" align="right">业务类型:</p>
                </div>
                <div id="c_servicetype_value">
                    <p id="c_servicetype_value_text" align="center">
                        <%=applicant.getServietype()%>
                    </p>
                </div>
            </div>
            <div id="c_button">
                <button style="width: 150px;height: 35px;background: #26bed6" type="button"><a  href="./workplace">返回</a></button>
            </div>
        </div>
        <!-- Unnamed (矩形) -->
        <div id="u1329" class="ax_default _标题_1">
            <div id="u1329_div" class=""></div>
            <div id="u1329_text" class="text ">
                <p><span>金融风控单条业务信息查询详情</span></p>
            </div>
        </div>
    </div>

    <!-- 个人框 (组合) -->
    <div id="u1332" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

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
        <div id="u1333" class="ax_default image" data-label="logo">
            <img id="u1333_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u1335" class="ax_default marker" title="警告数">
            <img id="u1335_img" class="img " src="images/警告数/u340.png"/>
            <div id="u1335_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
