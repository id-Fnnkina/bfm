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
        #member{
            background: #26afd6;
        }
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
                    <div id="title_1" style="">
                        <p >一、金融风险评估业务</p>
                    </div>
                    <div id="title_1_content" style="">
                        <div id="netloan"class="loan"  style="">
                            <p class="text_p"><a href="./netloan?buinesstype=netloan">1.1 网贷平台风险评估</a></p>
                            <!--<img class="loan_img" src="images/moban/u143.png"/>-->
                        </div>

                        <div id="enterprise" class="loan" >
                            <p class="text_p" ><a href="./enterprise?buinesstype=enterprise">1.2企业经营风险评估</a></p>
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
            <div id="tables">
                <table width="100%">
                    <%for(int i=0;i<list.size();i=i+3){
                        int j=i;
                    %>
                    <tr>
                        <%if(j<list.size()&&null!=list.get(j)){
                            Member member=(Member)list.get(j);
                        %>
                        <th>
                            <div id="d_company1">
                                <div id="d_cmpany1_img_background" ><img src="images/1、联盟成员列表/u1957.png"></div>
                                <div id="d_company1_img1"><img id="company1_img1" class="img " src="<%=member.getImages()%>"/></div>
                                <div id="d_company1_companyname"><span><%=member.getCompanyname()%></span></div><br>
                                <div id="d_company1_text"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><%=member.getIntroduce()%></a></div><br>
                                <div id="d_company1_text_time"><%=member.getTime()%></div><br>
                                <%--<div id="d_cmpany1_img_select1" ><a href="" title="配置"><img img id="company1_img_select1" src="images/评估模型管理/u911.png"></a></div>--%>
                                <div id="d_cmpany1_img_select2"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><img img id="company1_img_select2" src="images/评估模型管理/u910.png"></a></div><br>

                            </div>
                            <br>
                            <br>
                        </th>
                        <%if(j+1<list.size()&&null!=list.get(j+1)){
                            member=(Member)list.get(j+1);
                        %>
                        <th>
                            <div id="d_company2">
                                <div id="d_cmpany2_img_background" ><img src="images/1、联盟成员列表/u1957.png"></div>
                                <div id="d_company2_img1"><img id="company2_img1" class="img " src="<%=member.getImages()%>"/></div>
                                <div id="d_company2_companyname"><span><%=member.getCompanyname()%></span></div><br>
                                <div id="d_company2_text"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><%=member.getIntroduce()%></a></div><br>
                                <div id="d_company2_text_time"><%=member.getTime()%></div><br>
                                <%--<div id="d_cmpany2_img_select1" ><a title="配置"><img img id="company2_img_select1" src="images/评估模型管理/u911.png"></a></div>--%>
                                <div id="d_cmpany2_img_select2"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><img img id="company2_img_select2" src="images/评估模型管理/u910.png"></a></div><br>
                            </div>
                            <br>
                            <br>
                        </th>
                        <%if(j+2<list.size()&&null!=list.get(j+2)){
                            member=(Member)list.get(j+2);
                        %>
                        <th>
                            <div id="d_company3">
                                <div id="d_cmpany3_img_background" ><img src="images/1、联盟成员列表/u1957.png"></div>
                                <div id="d_company3_img1"><img id="company3_img1" class="img " src="<%=member.getImages()%>"/></div>
                                <div id="d_company3_companyname"><span><%=member.getCompanyname()%></span></div><br>
                                <div id="d_company3_text"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><%=member.getIntroduce()%></a></div><br>
                                <div id="d_company3_text_time"><%=member.getTime()%></div>

                                <div id="d_cmpany3_img_select2"><a href="./memberdetail?memberrolenum=<%=member.getMemberrolenum()%>&companyname=<%=member.getCompanyname()%>" title="详情"><img img id="company3_img_select2" src="images/评估模型管理/u910.png"></a></div><br>
                            </div>
                            <br>
                            <br>
                        </th>
                        <%}}}%>
                    </tr>
                    <%}%>
                    <tr> <th>
                        <div id="d_company4" style=" width:150px;
    height:120px;
    background-color: #fffcff;
    position:relative;/*相对定位*/
    top: 0px;
    left: 50px;
    text-align: left;
    border: 1px solid #9ca3ad;">
                           <a href="./memberadd?method=add"title="添加联盟成员"> <img id="company4_img1" style=" border-width:0px;position: absolute;top: 20px;left: 30px;width:80px;display: inline-block;vertical-align: middle;" class="img " src="images/1、联盟成员列表/u1952.png"/></a></div>
                        <br>
                        <br>
                    </th></tr>
                    <!-- 快牛金科 (组合) -->
                    <br>
                </table>
                <br>
                <br>
                <br>

            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u2066" class="ax_default _标题_1">
            <div id="u2066_text" class="text ">
                <p><span style="font-family: '黑体 Bold', '黑体'">联盟成员列表</span></p>
            </div>
        </div>

    </div>
</div>
</body>
</html>
