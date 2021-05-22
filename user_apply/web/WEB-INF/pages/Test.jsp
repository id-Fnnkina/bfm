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
    <%String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <title>1、联盟成员列表</title>
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
    <link href="files/1、联盟成员列表/styles.css" type="text/css" rel="stylesheet"/>
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
        a:link,a:visited{
            text-decoration:none;  /*超链接无下划线*/
        }
        a:hover{
            text-decoration:underline;  /*鼠标放上去有下划线*/
        }
    </style>
</head>
</head>
<body>
<div id="base" class="">

    <!-- 背景 (组合) -->
    <div id="u1917" class="ax_default" data-label="背景" data-left="0" data-top="-8" data-width="1342" data-height="754">

        <!-- Unnamed (矩形) -->
        <div id="u1918" class="ax_default shape">
            <div id="u1918_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u1919" class="ax_default" data-label="列表" data-left="0" data-top="63" data-width="203" data-height="683">

            <!-- Unnamed (矩形) -->
            <div id="u1920" class="ax_default shape">
                <div id="u1920_div" class=""></div>
            </div>
            <div style="position:relative;top: 408px">
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
            <!-- 小额贷款-->
            <div id="g360" class="ax_defaul" data-left="0" data-top="298" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="g361" class="ax_defaul shape">
                    <div id="g361_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="g362" class="ax_defaul shape">
                    <div id="g362_div" class=""></div>
                    <div id="g362_text" class="text ">
                        <a href="./prettyloan">小额贷款风险评估</a>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="g363" class="ax_defaul shape">
                    <img id="g363_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- P2P企业-->
            <div id="g364" class="ax_defaul" data-left="0" data-top="298" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="g365" class="ax_defaul shape">
                    <div id="g365_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="g366" class="ax_defaul shape">
                    <div id="g366_div" class=""></div>
                    <div id="g366_text" class="text ">
                        <a href="./p2ploan">P2P企业风险评估</a>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="g367" class="ax_default shape">
                    <img id="g367_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1921" class="ax_default" data-left="0" data-top="154" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1922" class="ax_default shape">
                    <div id="u1922_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1923" class="ax_default shape">
                    <div id="u1923_div" class=""></div>
                    <div id="u1923_text" class="text ">
                        <p><span>金融风险防控任务管理</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1924" class="ax_default shape">
                    <img id="u1924_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1925" class="ax_default" data-left="0" data-top="191" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1926" class="ax_default shape">
                    <div id="u1926_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1927" class="ax_default shape">
                    <div id="u1927_div" class=""></div>
                    <div id="u1927_text" class="text ">
                        <p><span><a href="./chaincode">区块链查询管理</a></span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1928" class="ax_default shape">
                    <img id="u1928_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1929" class="ax_default" data-left="0" data-top="228" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1930" class="ax_default shape">
                    <div id="u1930_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1931" class="ax_default shape">
                    <div id="u1931_div" class=""></div>
                    <div id="u1931_text" class="text ">
                        <p><span>评估模型管理</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1932" class="ax_default shape">
                    <img id="u1932_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1933" class="ax_default" data-left="0" data-top="263" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1934" class="ax_default shape">
                    <div id="u1934_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1935" class="ax_default shape">
                    <div id="u1935_div" class=""></div>
                    <div id="u1935_text" class="text ">
                        <p><span>综合报表</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1936" class="ax_default shape">
                    <img id="u1936_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1937" class="ax_default" data-left="0" data-top="298" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1938" class="ax_default shape">
                    <div id="u1938_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1939" class="ax_default shape">
                    <div id="u1939_div" class=""></div>
                    <div id="u1939_text" class="text ">
                        <p><span>系统日志</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1940" class="ax_default shape">
                    <img id="u1940_img" class="img " src="images/moban/u143.png"/>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u1941" class="ax_default" data-left="0" data-top="118" data-width="203" data-height="36">

                <!-- Unnamed (矩形) -->
                <div id="u1942" class="ax_default shape">
                    <div id="u1942_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1943" class="ax_default shape">
                    <div id="u1943_div" class=""></div>
                    <div id="u1943_text" class="text ">
                        <p><span>联盟成员管理</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1944" class="ax_default shape">
                    <img id="u1944_img" class="img " src="images/moban/u143_mouseOver.png"/>
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

            <!-- 添加成员栏 (组合) -->
            <div id="u1949" class="ax_default" data-label="添加成员栏" data-left="294" data-top="547" data-width="250" data-height="88">

                <!-- Unnamed (矩形) -->
                <div id="u1950" class="ax_default shape">
                    <div id="u1950_div" class=""></div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1951" class="ax_default box_1">
                    <div id="u1951_div" class=""></div>
                    <div id="u1951_text" class="text ">
                        <p><span>添加联盟成员</span></p>
                    </div>
                </div>

                <!-- Unnamed (图像) -->
                <div id="u1952" class="ax_default _图片">
                    <img id="u1952_img" class="img " src="images/1、联盟成员列表/u1952.png"/>
                </div>
            </div>
            <%
                Utils utils = new Utils();
            %>
            <!-- 快牛金科 (组合) -->
            <div id="u1953" class="ax_default" data-label="快牛金科" data-left="262" data-top="77" data-width="1043" data-height="432">

                <!-- Unnamed (矩形) -->
                <div id="u1954" class="ax_default shape">
                    <div id="u1954_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u1955" class="ax_default shape">
                    <img id="u1955_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1956" class="ax_default label1">
                    <div id="u1956_div" class=""></div>
                    <div id="u1956_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u1957" class="ax_default line">
                    <img id="u1957_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1958" class="ax_default heading_1">
                    <div id="u1958_div" class=""></div>
                    <div id="u1958_text" class="text ">
                        <p><span><%=utils.turnMember("XX金融机构")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u1959" class="ax_default image" data-label="logo">
                    <img id="u1959_img" class="img " src="images/金融风险防控管理列表/logo_u1384.jpg"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u1960" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u1961" class="ax_default shape">
                        <div id="u1961_div" class=""></div>
                        <div id="u1961_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1962" class="ax_default box_2">
                        <img id="u1962_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1962_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1963" class="ax_default box_2">
                        <img id="u1963_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1963_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1964" class="ax_default box_2">
                        <img id="u1964_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1964_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u1965" class="ax_default" data-label="名称" data-left="329" data-top="400" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u1966" class="ax_default paragraph">
                        <div id="u1966_div" class=""></div>
                        <div id="u1966_text" class="text ">
                            <p><span>XX金融机构</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u1967" class="ax_default image1">
                        <img id="u1967_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u1968" class="ax_default image1">
                        <img id="u1968_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u1969" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u1969_div" class=""></div>
                    <div id="u1969_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>

                <!-- 个人框 (组合) -->
                <div id="u1970" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">

                    <!-- logo (图像) -->
                    <div id="u1971" class="ax_default image" data-label="logo">
                        <img id="u1971_img" class="img " src="images/警告数/logo_u338.png"/>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u1972" class="ax_default box_2">
                        <div id="u1972_div" class=""></div>
                        <div id="u1972_text" class="text ">
                            <p><span>个人中心</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (水滴) -->
                    <div id="u1973" class="ax_default marker" title="警告数">
                        <img id="u1973_img" class="img " src="images/警告数/u340.png"/>
                        <div id="u1973_text" class="text ">
                            <p><span>10</span></p>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 快牛金科 (组合) -->
            <div id="u1974" class="ax_default" data-label="快牛金科" data-left="615" data-top="394" data-width="326" data-height="115">

                <!-- Unnamed (矩形) -->
                <div id="u1975" class="ax_default shape">
                    <div id="u1975_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u1976" class="ax_default shape">
                    <img id="u1976_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1977" class="ax_default label1">
                    <div id="u1977_div" class=""></div>
                    <div id="u1977_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u1978" class="ax_default line">
                    <img id="u1978_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1979" class="ax_default heading_1">
                    <div id="u1979_div" class=""></div>
                    <div id="u1979_text" class="text ">
                        <p><span><%=utils.turnMember("XX科技（互联网企业）")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u1980" class="ax_default image" data-label="logo">
                    <img id="u1980_img" class="img " src="images/1、联盟成员列表/logo_u1980.jpg"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u1981" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u1982" class="ax_default shape">
                        <div id="u1982_div" class=""></div>
                        <div id="u1982_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1983" class="ax_default box_2">
                        <img id="u1983_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1983_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1984" class="ax_default box_2">
                        <img id="u1984_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1984_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u1985" class="ax_default box_2">
                        <img id="u1985_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u1985_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u1986" class="ax_default" data-label="名称" data-left="682" data-top="400" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u1987" class="ax_default paragraph">
                        <div id="u1987_div" class=""></div>
                        <div id="u1987_text" class="text ">
                            <p><span>XX科技（互联网企业）</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u1988" class="ax_default image1">
                        <img id="u1988_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u1989" class="ax_default image1">
                        <img id="u1989_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u1990" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u1990_div" class=""></div>
                    <div id="u1990_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>
            </div>

            <!-- 快牛金科 (组合) -->
            <div id="u1991" class="ax_default" data-label="快牛金科" data-left="972" data-top="394" data-width="326" data-height="115">

                <!-- Unnamed (矩形) -->
                <div id="u1992" class="ax_default shape">
                    <div id="u1992_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u1993" class="ax_default shape">
                    <img id="u1993_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1994" class="ax_default label1">
                    <div id="u1994_div" class=""></div>
                    <div id="u1994_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u1995" class="ax_default line">
                    <img id="u1995_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u1996" class="ax_default heading_1">
                    <div id="u1996_div" class=""></div>
                    <div id="u1996_text" class="text ">
                        <p><span><%=utils.turnMember("XX理财")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u1997" class="ax_default image" data-label="logo">
                    <img id="u1997_img" class="img " src="images/1、联盟成员列表/logo_u1997.jpg"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u1998" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u1999" class="ax_default shape">
                        <div id="u1999_div" class=""></div>
                        <div id="u1999_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2000" class="ax_default box_2">
                        <img id="u2000_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2000_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2001" class="ax_default box_2">
                        <img id="u2001_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2001_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2002" class="ax_default box_2">
                        <img id="u2002_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2002_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u2003" class="ax_default" data-label="名称" data-left="1039" data-top="400" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u2004" class="ax_default paragraph">
                        <div id="u2004_div" class=""></div>
                        <div id="u2004_text" class="text ">
                            <p><span>XX理财</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2005" class="ax_default image1">
                        <img id="u2005_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2006" class="ax_default image1">
                        <img id="u2006_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u2007" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u2007_div" class=""></div>
                    <div id="u2007_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>
            </div>

            <!-- 快牛金科 (组合) -->
            <div id="u2008" class="ax_default" data-label="快牛金科" data-left="973" data-top="240" data-width="326" data-height="115">

                <!-- Unnamed (矩形) -->
                <div id="u2009" class="ax_default shape">
                    <div id="u2009_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u2010" class="ax_default shape">
                    <img id="u2010_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2011" class="ax_default label1">
                    <div id="u2011_div" class=""></div>
                    <div id="u2011_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u2012" class="ax_default line">
                    <img id="u2012_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2013" class="ax_default heading_1">
                    <div id="u2013_div" class=""></div>
                    <div id="u2013_text" class="text ">
                        <p><span><%=utils.turnMember("***保险")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u2014" class="ax_default image" data-label="logo">
                    <img id="u2014_img" class="img " src="images/金融风险防控管理列表/logo_u1384.jpg"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u2015" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u2016" class="ax_default shape">
                        <div id="u2016_div" class=""></div>
                        <div id="u2016_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2017" class="ax_default box_2">
                        <img id="u2017_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2017_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2018" class="ax_default box_2">
                        <img id="u2018_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2018_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2019" class="ax_default box_2">
                        <img id="u2019_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2019_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u2020" class="ax_default" data-label="名称" data-left="1040" data-top="246" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u2021" class="ax_default paragraph">
                        <div id="u2021_div" class=""></div>
                        <div id="u2021_text" class="text ">
                            <p><span>***保险</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2022" class="ax_default image1">
                        <img id="u2022_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2023" class="ax_default image1">
                        <img id="u2023_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u2024" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u2024_div" class=""></div>
                    <div id="u2024_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>
            </div>

            <!-- 快牛金科 (组合) -->
            <div id="u2025" class="ax_default" data-label="快牛金科" data-left="616" data-top="240" data-width="326" data-height="115">

                <!-- Unnamed (矩形) -->
                <div id="u2026" class="ax_default shape">
                    <div id="u2026_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u2027" class="ax_default shape">
                    <img id="u2027_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2028" class="ax_default label1">
                    <div id="u2028_div" class=""></div>
                    <div id="u2028_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u2029" class="ax_default line">
                    <img id="u2029_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2030" class="ax_default heading_1">
                    <div id="u2030_div" class=""></div>
                    <div id="u2030_text" class="text ">
                        <p><span><%=utils.turnMember("**银行")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u2031" class="ax_default image" data-label="logo">
                    <img id="u2031_img" class="img " src="images/1、联盟成员列表/logo_u1997.jpg"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u2032" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u2033" class="ax_default shape">
                        <div id="u2033_div" class=""></div>
                        <div id="u2033_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2034" class="ax_default box_2">
                        <img id="u2034_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2034_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2035" class="ax_default box_2">
                        <img id="u2035_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2035_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2036" class="ax_default box_2">
                        <img id="u2036_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2036_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u2037" class="ax_default" data-label="名称" data-left="683" data-top="246" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u2038" class="ax_default paragraph">
                        <div id="u2038_div" class=""></div>
                        <div id="u2038_text" class="text ">
                            <p><span>**银行</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2039" class="ax_default image1">
                        <img id="u2039_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2040" class="ax_default image1">
                        <img id="u2040_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u2041" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u2041_div" class=""></div>
                    <div id="u2041_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>
            </div>

            <!-- 快牛金科 (组合) -->
            <div id="u2042" class="ax_default" data-label="快牛金科" data-left="263" data-top="240" data-width="326" data-height="115">

                <!-- Unnamed (矩形) -->
                <div id="u2043" class="ax_default shape">
                    <div id="u2043_div" class=""></div>
                </div>

                <!-- Unnamed (形状) -->
                <div id="u2044" class="ax_default shape">
                    <img id="u2044_img" class="img " src="images/1、联盟成员列表/u1955.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2045" class="ax_default label1">
                    <div id="u2045_div" class=""></div>
                    <div id="u2045_text" class="text ">
                        <p style="font-size:12px;"><span style="font-family:'Helvetica';font-size:14px;color:#00FF00;">●</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#00FF00;"> 已加入</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#666666;"> </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';color:#CCCCCC;">2018-10-30</span></p>
                    </div>
                </div>

                <!-- Unnamed (横线) -->
                <div id="u2046" class="ax_default line">
                    <img id="u2046_img" class="img " src="images/1、联盟成员列表/u1957.png"/>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2047" class="ax_default heading_1">
                    <div id="u2047_div" class=""></div>
                    <div id="u2047_text" class="text ">
                        <p><span><%=utils.turnMember("中国电信")%></span></p>
                    </div>
                </div>

                <!-- logo (图像) -->
                <div id="u2048" class="ax_default image" data-label="logo">
                    <img id="u2048_img" class="img " src="images/首页/u0.png"/>
                </div>

                <!-- 快牛金科按钮管理按钮 (组合) -->
                <div id="u2049" class="ax_default ax_default_hidden" data-label="快牛金科按钮管理按钮" style="display:none; visibility: hidden" data-left="0" data-top="0" data-width="0" data-height="0">

                    <!-- Unnamed (矩形) -->
                    <div id="u2050" class="ax_default shape">
                        <div id="u2050_div" class=""></div>
                        <div id="u2050_text" class="text ">
                            <p></p><p></p><p></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2051" class="ax_default box_2">
                        <img id="u2051_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2051_text" class="text ">
                            <p><span>详情</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2052" class="ax_default box_2">
                        <img id="u2052_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2052_text" class="text ">
                            <p><span>职责</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (斜角矩形) -->
                    <div id="u2053" class="ax_default box_2">
                        <img id="u2053_img" class="img " src="images/1、联盟成员列表/u1962.png"/>
                        <div id="u2053_text" class="text ">
                            <p><span>关闭</span></p>
                        </div>
                    </div>
                </div>

                <!-- 名称 (组合) -->
                <div id="u2054" class="ax_default" data-label="名称" data-left="330" data-top="246" data-width="241" data-height="96">

                    <!-- Unnamed (矩形) -->
                    <div id="u2055" class="ax_default paragraph">
                        <div id="u2055_div" class=""></div>
                        <div id="u2055_text" class="text ">
                            <p><span>中国电信</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2056" class="ax_default image1">
                        <img id="u2056_img" class="img " src="images/评估模型管理/u910.png"/>
                    </div>

                    <!-- Unnamed (图像) -->
                    <div id="u2057" class="ax_default image1">
                        <img id="u2057_img" class="img " src="images/评估模型管理/u911.png"/>
                    </div>
                </div>

                <!-- 填写配置 (矩形) -->
                <div id="u2058" class="ax_default box_1 ax_default_hidden" data-label="填写配置" style="display:none; visibility: hidden">
                    <div id="u2058_div" class=""></div>
                    <div id="u2058_text" class="text ">
                        <p><span>填写配置</span></p>
                    </div>
                </div>
            </div>
        </div>


        <!-- 搜索栏 (组合) -->
        <div id="u2062" class="ax_default" data-label="搜索栏" data-left="1088" data-top="159" data-width="234" data-height="28">

            <!-- Unnamed (组合) -->
            <div id="u2063" class="ax_default" data-left="1088" data-top="159" data-width="234" data-height="28">

                <!-- Unnamed (矩形) -->
                <div id="u2064" class="ax_default shape">
                    <div id="u2064_div" class=""></div>
                    <div id="u2064_text" class="text ">
                        <p><span>请输入关键词</span></p>
                    </div>
                </div>

                <!-- Unnamed (矩形) -->
                <div id="u2065" class="ax_default shape">
                    <div id="u2065_div" class=""></div>
                    <div id="u2065_text" class="text ">
                        <p><span>搜 索</span></p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u2066" class="ax_default _标题_1">
            <div id="u2066_div" class=""></div>
            <div id="u2066_text" class="text ">
                <p><span>联盟成员列表</span></p>
            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u2067" class="ax_default primary_button">
            <div id="u2067_div" class=""></div>
            <div id="u2067_text" class="text ">
                <p><span>返回</span></p>
            </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u2068" class="ax_default primary_button">
            <div id="u2068_div" class=""></div>
            <div id="u2068_text" class="text ">
                <p><span>退出</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
