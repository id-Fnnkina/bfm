<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/3
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@page import="finance.ideal.domain.workPlace "%>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ page import="finance.ideal.util.PageUtil" %>
    <%String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <title>金融风险防控详情列表</title>
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
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/金融风险防控详情列表/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/金融风险防控详情列表/data.js"></script>
    <script src="files/金融风险防控详情列表/laydate/laydate.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
        laydate.render({
            elem: '#test1'
            ,range: true
            ,theme: '#393d49'
        });
    </script>


    <style type="text/css">
        #workplace{
            background: #26afd6;
        }
        #jz{
            margin:0 auto;
            width:100%;
            height:100px;
            border: 1px;
            text-align:center;
            font-size: 30px;
            font-family: '华文行楷 Bold', '华文行楷 Regular', '华文行楷';
        }
    </style>
</head>
<body>

<%
    String[] selectTime = (String[])request.getAttribute("selectTime");
    String startTime="";
    String endTime="";
    if (selectTime!=null){
        startTime=selectTime[0];
        endTime=selectTime[1];
    }

    PageUtil page1 = (PageUtil)request.getAttribute("page");
    ArrayList list = (ArrayList) page1.getDataList();
    System.out.println(list);

%>
<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u1514" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="831">

        <!-- Unnamed (矩形) -->
        <div id="u1515" class="ax_default shape">
            <div id="u1515_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u1516" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="760">

            <!-- Unnamed (矩形) -->
            <div id="u1517" class="ax_default shape">
                <div id="u1517_div" class=""style="width: 222px"></div>
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
            <div id="u1542" class="ax_default shape">
                <div id="u1542_div" class=""></div>
                <div id="u1542_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u1543" class="ax_default image">
            <img id="u1543_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- 金融防控 (组合) -->
    <div id="u1544" class="ax_default" data-label="金融防控" data-left="237" data-top="80" data-width="1094" data-height="721">

        <!-- Unnamed (矩形) -->
        <div id="u1545" class="ax_default box_2">
            <div id="u1545_div" class=""></div>
        </div>
        <!-- Unnamed (矩形) -->
        <div id="u1550" class="ax_default _标题_1">
            <div id="u1550_div" class=""></div>
            <div id="u1550_text" class="text ">
                <p><span>金融风险防控管理列表</span></p>
            </div>
        </div>


        <!-- Unnamed (矩形) -->
        <div id="u1583" class="ax_default button" style="left: 1050px">
            <div id="u1583_div" class=""></div>
            <div id="u1583_text" class="text ">
                <p><span><a href="UploadDownloadServlet?method=downloadworkbase&startTime=<%=startTime%>&endTime=<%=endTime%>">导出报表</a></span></p>
            </div>
        </div>
    </div>

    <!-- 管理 (组合) -->
    <div id="u1584" class="ax_default" data-label="管理" data-left="233" data-top="211" data-width="1078" data-height="326">

        <!-- Unnamed (表格) -->
        <div id="u1585" class="ax_default">

            <%
                if (list.size()==0){%>
            <div id="jz">
                <span>暂无业务。。。</span>
                <br><br><br>
                <button style="width: 150px;height: 35px;background: #26bed6" type="button"><a  href="./workplace">返回</a></button>
            </div>
            <%}else {%>
            <table align = "center" frame="void" rules="all" style="width:85%;border: 1px solid #090607; ">
                <tr style="height:50px ;background:#949e9f" ;frame=void border-bottom: 1px solid red;>
                    <th width="200px">业务流水号</th>
                    <th>业务时间</th>
                    <th>业务类型</th>
                    <th>业务发起方</th>
                    <th width="80px">业务表单记录</th>
                </tr>
                <!-- 继续使用jsp语句 循环放入存放于list中的Book实体类中的数据 -->
                <%if(0!=list.size()&&list.size()<=10){
                    for(int i = 0;i<list.size();i++){
                        workPlace place =(workPlace) list.get(i);
                %>
                <tr style="height:35px">
                    <th><%=place.getId()%></th>
                    <th><%=place.getBusinessTime()%></th>
                    <th><%=place.getBusinessType()%></th>
                    <th><%=place.getBusinessLeader()%></th>
                    <%--<th style="color:#38a8ff"><a href="./businesslist?id=<%=place.getId()%>&leader=<%=place.getBusinessLeader()%>">点击查看</a></th>--%>
                    <th style="color:#38a8ff"><a href="./workplaceList?ordernum=<%=place.getId()%>">点击查看</a></th>
                        <%} }%>
                </tr>
                <tr><td class="altbg2" colspan="5" rowspan="5" align="right">
                    <a href="workplace?action=list&pageIndex=1">首页</a> &#160;&#160;
                    <a href="workplace?action=list&pageIndex=<%=page1.getPageIndex()-1<1?1:page1.getPageIndex()-1%>">上一页</a>&#160;&#160;
                    &#160;&#160;&#160;第<%=page1.getPageIndex()%>页/共<%=page1.getTotalPageCount()%>页 &#160;&#160;&#160;
                    <a href="workplace?action=list&pageIndex=<%=page1.getPageIndex()+1>1?1:page1.getPageIndex()+1%>">下一页</a>&#160;&#160;
                    <a href="workplace?action=list&pageIndex=<%=page1.getTotalPageCount()%>">末页</a> &#160;&#160;&#160;
                    <div style="float: right; ">
                        共<%=page1.getTotalCount()%>条. 每页显示<%=page1.getPageSize()%>条&#160;&#160;&#160;&#160;
                    </div>
                </td></tr>
            </table>
            <br><br><br>
            <%}%>


        </div>
        <form action="${pageContext.request.contextPath}/workplace">
        <div style="position: relative;top: 150px;left: 650px;width: 400px;height: 50px;">
                选择日期时间:<input STYLE="height: 30px" type="text" name="time" id="test1">
            <input style="width: 50px;background: #20bed6;height: 25px" type="submit" value="搜索">
        </div>
        </form>
    <!-- 报表 (动态面板) -->
    <div id="u1684" class="ax_default ax_default_hidden" data-label="报表" style="display:none; visibility: hidden">
        <div id="u1684_state0" class="panel_state" data-label="状态1" style="">
            <div id="u1684_state0_content" class="panel_state_content">

                <!-- Unnamed (矩形) -->
                <div id="u1685" class="ax_default button">
                    <div id="u1685_div" class=""></div>
                    <div id="u1685_text" class="text ">
                        <p><span>关闭</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1686" class="ax_default box_1">
                    <div id="u1686_div" class=""></div>
                    <div id="u1686_text" class="text ">
                        <p><span>报表已导出</span></p>
                    </div>
                </div>
            </div>
        </div>
        <div id="u1684_state1" class="panel_state" data-label="状态2" style="visibility: hidden;">
            <div id="u1684_state1_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 个人框 (组合) -->
    <div id="u1687" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

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
        <div id="u1688" class="ax_default image" data-label="logo">
            <img id="u1688_img" class="img " src="images/警告数/logo_u338.png"/>
        </div>

        <!-- Unnamed (水滴) -->
        <div id="u1690" class="ax_default marker" title="警告数">
            <img id="u1690_img" class="img " src="images/警告数/u340.png"/>
            <div id="u1690_text" class="text ">
                <p><span>10</span></p>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
