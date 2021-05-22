<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/3
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>模型区块链查询统计</title>
    <%@page import="finance.ideal.domain.ChainCodeDomain "%>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ page import="finance.ideal.domain.ChainCodeModelDomain" %>
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
    <link href="data/styles.css" type="text/css" rel="stylesheet">
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
        #chaincode{
            background: #26afd6;
        }
        .th{width:100px;}

        #jz{
            margin:0 auto;
            width:100%;
            height:100px;
            border: 1px;
            text-align:center;
            font-size: 30px;
            font-family: '华文行楷 Bold', '华文行楷 Regular', '华文行楷';
        }
        #datachaincode:hover{
            background: #108EE9;
        }
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
            <div id="u1093" class="ax_default shape">
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
<% ArrayList list = (ArrayList) request.getAttribute("list");
    String businessNumber = (String) request.getAttribute("BusinessNumber");
%>
    <!-- 区块链查询 (组合) -->
    <div id="u1095" class="ax_default" data-label="区块链查询" data-left="213" data-top="74" data-width="1129" data-height="839">

        <!-- Unnamed (组合) -->
        <div id="u1096" class="ax_default" data-left="213" data-top="136" data-width="1129" data-height="74">

            <div id="u1226" class="ax_default _标题_1">
                <div id="u1226_div" class=""></div>
                <div id="u1226_text" class="text ">
                    <p><span>模型区块链查询管理列表</span></p>
                </div>
            </div>

        </div>
        <div style="position:relative;top: 170px;left: 250px;width: 500px;height: 60px">
            <div id="datachaincode" style="position: absolute;top: 10px;left: 10%;width: 35%;height: 35%;border: 1px solid #090607">
                <a href="chaincode" >标签碰撞区块链记录</a>
            </div>
            <div id="modelchaincode" style="position: absolute;top: 10px;left: 50%;width: 35%;height: 35%;background: #0a6cd6;border: 1px solid #090607">
                <a href="chaincodemodel">模型评估区块链记录</a>
            </div>

        </div>
        <form action="${pageContext.request.contextPath}/chaincodemodel">
            <div style="position: relative;top: 115px;left: 700px;width: 400px;height: 50px;">
                选择业务序列号:<input STYLE="height: 30px" type="text" name="BusinessNumber">
                <input style="width: 50px;background: #20bed6;height: 25px" type="submit" value="搜索">
            </div>
        </form>
        <div id="g1137" style="position:relative;/*相对定位*/
    top: 150px;
    left: 220px;">
            <%
                if (0==list.size()){
                   %>
            <div id="jz">
                <span>区块链上暂无无信息可查，敬请期待后续更新。。。</span>
                <br><br><br>
                <button style="width: 150px;height: 35px;background: #26bed6" type="button"><a  href="./管理主界面.html">返回</a></button>
            </div>
            <%
                } else {
            %>
            <!-- 声明一个表格,这是表头 -->
            <table  align = "center" frame="void" rules="all" style="width:90%;border: 1px solid #090607; ">
                <tr style="height:50px ;background:#949e9f" ;frame=void border-bottom: 1px solid red;>
                    <th width="100px">业务ID</th>
                    <th width="150px">业务流水号</th>
                    <th width="80px">业务类型</th>
                    <th width="130px">上链时间</th>
                    <th >模型id</th>
                    <th >模型类型</th>
                    <th >模型版本</th>
                    <th >身份证号</th>
                    <%--<th >业务号</th>--%>
                    <th width="40px">备注</th>
                </tr>
                <!-- 继续使用jsp语句 循环放入存放于list中的Book实体类中的数据 -->
                <%
                    for(int i = 0;i<list.size();i++){
                        ChainCodeModelDomain chainCode = (ChainCodeModelDomain) list.get(i);%>
                <tr style="height:40px ;background:#f0fff6" ;>
                    <th><%=chainCode.getRecordId()%></th>
                    <th><%=chainCode.getBusinessNumber()%></th>
                    <th><%=chainCode.getBusinessTypeId()%></th>
                    <th><%=chainCode.getEstimateDate()%></th>
                    <th><%=chainCode.getEstimateModelId()%></th>
                    <th><%=chainCode.getEstimateModelType()%></th>
                    <th><%=chainCode.getEstimateModelVersion()%></th>
                    <th><%=chainCode.getHashData()%></th>
                    <%--<th><%=chainCode.getRemark()%></th>--%>
                    <!-- 此处设置了一个修改<a>标签,做修改操作.并将上面拿到的数据传给update.jsp,当进入修改页面的时候,原来的数据会显示 -->
                    <th style="color:#38a8ff"><a href="./chaincodemodeldetail?recordid=<%=chainCode.getRecordId()%>">详情</a> 
                        <!-- 删除操作,只把name字段传给Delete_Servlet.java,用来做删除操作 -->
                    </th>
                </tr>
                        <% }}
  		 %>

            </table>

        </div>

        <!-- 报表 (动态面板) -->
        <div id="u1229" class="ax_default ax_default_hidden" data-label="报表" style="display:none; visibility: hidden">
            <div id="u1229_state0" class="panel_state" data-label="状态1" style="">
                <div id="u1229_state0_content" class="panel_state_content">

                    <!-- Unnamed (矩形) -->
                    <div id="u1230" class="ax_default box_2">
                        <div id="u1230_div" class=""></div>
                        <div id="u1230_text" class="text ">
                            <p><span><br></span></p><p><span>报表已导出！！！</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u1231" class="ax_default button">
                        <div id="u1231_div" class=""></div>
                        <div id="u1231_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u1232" class="ax_default button" style="top: 179px">
            <div id="u1232_div" class=""></div>
            <div id="u1232_text" class="text ">
                <p><span><a href="UploadDownloadServlet?method=downloadchaincodemodel">导出报表</a></span></p>

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

        </div>
    </div>
</body>
</html>
