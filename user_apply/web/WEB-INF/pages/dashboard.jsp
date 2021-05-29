<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="static java.lang.Character.getType" %>
<%@ page import="finance.ideal.domain.Dashboard" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/11
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="fils" type="text/css" rel="stylesheet"/>
    <link href="files/title.css" type="text/css" rel="stylesheet"/>
    <link href="files/dashboard/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/dashboard/data.js"></script>
    <script src="files/dashboard/bmap.min.js"></script>
    <script src="files/dashboard/china.js"></script>
    <script src="files/dashboard/dataTool.min.js"></script>
    <script src="files/dashboard/echarts.min.js"></script>
    <script src="files/dashboard/echarts-gl.min.js"></script>
    <script src="files/dashboard/ecStat.min.js"></script>
    <script src="files/dashboard/simplex.js"></script>
    <script src="files/dashboard/type.js"></script>
    <script src="files/dashboard/world.js"></script>

    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <style type="text/css">
        #Dashboard{
            background: #26afd6;
        }
    </style>
</head>
</head>
<body>
<div id="base" class=""style="left: -5px;">
    <%
        ArrayList<Map<String, Integer>> list = (ArrayList<Map<String, Integer>>) request.getAttribute("mapArrayList");
        Map<String, Integer> companyCount = list.get(0);
        Map<String, Integer> modelCount = list.get(1);
        Map<String, Integer> memberSCCount = list.get(2);

        List<String> memberNames =(ArrayList)request.getAttribute("memberNames");
        List<String> modelNames =(ArrayList)request.getAttribute("modelNames");
        Map<String,List> timeAndModelCount =(Map)request.getAttribute("timeAndModelCount");
        List<String> times = timeAndModelCount.get("times");
        List<String> single_loan = timeAndModelCount.get("single_loan");
        List<String> single_operator = timeAndModelCount.get("single_operator");
        List<String> enterprise_risk = timeAndModelCount.get("enterprise_risk");
        List<String> p2p_risk = timeAndModelCount.get("p2p_risk");
    %>
    <!-- 背景 (组合) -->
    <div id="u428" class="ax_default" data-label="背景" data-left="" data-top="-7" data-width="1342" data-height="1279" >

        <!-- Unnamed (矩形) -->
        <div id="u429" class="ax_default shape">
            <div id="u429_div" class=""></div>
        </div>

        <!-- 列表 (组合) -->
        <div id="u430" class="ax_default" data-label="列表" data-left="-17" data-top="64" data-width="203" data-height="1208">

            <!-- Unnamed (矩形) -->
            <div id="u431" class="ax_default shape">
                <div id="u431_div" class="" style="width: 222px"></div>
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
            <div id="u456" class="ax_default shape">
                <div id="u456_div" class=""></div>
                <div id="u456_text" class="text ">
                    <p><span>管理主界面</span></p>
                </div>
            </div>
        </div>

        <!-- Unnamed (图像) -->
        <div id="u457" class="ax_default image">
            <img id="u457_img" class="img " src="images/moban/u165.png"/>
        </div>
    </div>

    <!-- Dashboard (组合) -->
    <div id="u458" class="ax_default" data-label="Dashboard" data-left="207" data-top="80" data-width="1113" data-height="1087">

        <!-- Unnamed (组合) -->
        <div id="u459" class="ax_default" data-left="207" data-top="80" data-width="1113" data-height="556">

            <!-- Unnamed (组合) -->
            <div id="u463" class="ax_default" data-left="207" data-top="135" data-width="278" data-height="123">

                <!-- Unnamed (矩形) -->
                <div id="u464" class="ax_default box_1">
                    <div id="u464_div" class=""></div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u465" class="ax_default" data-left="272" data-top="151" data-width="191" data-height="50">

                    <!-- Unnamed (矩形) -->
                    <div id="u466" class="ax_default heading_1">
                        <div id="u466_div" class=""></div>
                        <div id="u466_text" class="text ">
                            <p><span>企业经营风险评估量</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u467" class="ax_default heading_1">
                        <div id="u467_div" class=""></div>
                        <div id="u467_text" class="text ">
                            <p><span><%=(modelCount.get("enterprisecount")==null?0:modelCount.get("enterprisecount"))%></span></p>
                        </div>
                    </div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u472" class="ax_default" data-left="221" data-top="158" data-width="51" data-height="51">

                    <!-- Unnamed (椭圆) -->
                    <div id="u473" class="ax_default box_2">
                        <img id="u473_img" class="img " src="images/dashboard/u473.png"/>
                    </div>

                    <!-- Unnamed (形状) -->
                    <div id="u474" class="ax_default icon">
                        <img id="u474_img" class="img " src="images/dashboard/u474.png"/>
                    </div>
                </div>
            </div>
            <!-- Unnamed (组合) -->
            <div id="u544" class="ax_default" data-left="485" data-top="135" data-width="277" data-height="122">

                <!-- Unnamed (矩形) -->
                <div id="u545" class="ax_default box_1">
                    <div id="u545_div" class=""></div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u546" class="ax_default" data-left="550" data-top="151" data-width="191" data-height="50">

                    <!-- Unnamed (矩形) -->
                    <div id="u547" class="ax_default heading_1">
                        <div id="u547_div" class=""></div>
                        <div id="u547_text" class="text ">
                            <p><span>网贷平台风险评估量</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u548" class="ax_default heading_1">
                        <div id="u548_div" class=""></div>
                        <div id="u548_text" class="text ">
                            <p><span style="font-family:'Helvetica Neue Regular', 'Helvetica Neue';"><%=(modelCount.get("NetLoancount")==null?0:modelCount.get("NetLoancount"))%></span></p>
                        </div>
                    </div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u553" class="ax_default" data-left="499" data-top="158" data-width="51" data-height="51">

                    <!-- Unnamed (椭圆) -->
                    <div id="u554" class="ax_default box_2">
                        <img id="u554_img" class="img " src="images/dashboard/u554.png"/>
                    </div>

                    <!-- Unnamed (形状) -->
                    <div id="u555" class="ax_default icon">
                        <img id="u555_img" class="img " src="images/dashboard/u555.png"/>
                    </div>
                </div>

            </div>

            <!-- Unnamed (组合) -->
            <div id="u557" class="ax_default" data-left="762" data-top="133" data-width="277" data-height="124">

                <!-- Unnamed (矩形) -->
                <div id="u558" class="ax_default box_1">
                    <div id="u558_div" class=""></div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u559" class="ax_default" data-left="827" data-top="149" data-width="191" data-height="50">

                    <!-- Unnamed (矩形) -->
                    <div id="u560" class="ax_default heading_1">
                        <div id="u560_div" class=""></div>
                        <div id="u560_text" class="text ">
                            <p><span>个人贷款信用评估量</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u561" class="ax_default heading_1">
                        <div id="u561_div" class=""></div>
                        <div id="u561_text" class="text ">
                            <p><span><%=(modelCount.get("PersonalLoancount")==null?0:modelCount.get("PersonalLoancount"))%></span></p>
                        </div>
                    </div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u567" class="ax_default" data-left="777" data-top="158" data-width="51" data-height="51">

                    <!-- Unnamed (椭圆) -->
                    <div id="u568" class="ax_default box_2">
                        <img id="u568_img" class="img " src="images/dashboard/u568.png"/>
                    </div>

                    <!-- Unnamed (形状) -->
                    <div id="u569" class="ax_default icon">
                        <img id="u569_img" class="img " src="images/dashboard/u569.png"/>
                    </div>
                </div>
            </div>

            <!-- Unnamed (组合) -->
            <div id="u570" class="ax_default" data-left="1038" data-top="135" data-width="278" data-height="122">

                <!-- Unnamed (矩形) -->
                <div id="u571" class="ax_default box_1">
                    <div id="u571_div" class=""></div>
                </div>

                <!-- Unnamed (组合) -->
                <div id="u572" class="ax_default" data-left="1103" data-top="151" data-width="191" data-height="50">

                    <!-- Unnamed (矩形) -->
                    <div id="u573" class="ax_default heading_1">
                        <div id="u573_div" class=""></div>
                        <div id="u573_text" class="text ">
                            <p><span>个人运营商风险评估量</span></p>
                        </div>
                    </div>

                    <!-- Unnamed (矩形) -->
                    <div id="u574" class="ax_default heading_1">
                        <div id="u574_div" class=""></div>
                        <div id="u574_text" class="text ">
                            <p><span><%=(modelCount.get("PersonalOperatorcount")==null?0:modelCount.get("PersonalOperatorcount"))%></span></p>

                        </div>
                    </div>
                </div>

                <!-- Unnamed (组合) -->

                <!-- Unnamed (组合) -->
                <div id="u579" class="ax_default" data-left="1053" data-top="158" data-width="51" data-height="51">

                    <!-- Unnamed (椭圆) -->
                    <div id="u580" class="ax_default box_2">
                        <img id="u580_img" class="img " src="images/dashboard/u580.png"/>
                    </div>

                    <!-- Unnamed (形状) -->
                    <div id="u581" class="ax_default icon">
                        <img id="u581_img" class="img " src="images/dashboard/u581.png"/>
                    </div>
                </div>

            </div>


            <!-- Unnamed (组合) -->
            <div id="u613" class="ax_default" data-left="207" data-top="92" data-width="109" data-height="24">

                <!-- Unnamed (矩形) -->
                <div id="u614" class="ax_default heading_1">
                    <div id="u614_div" class=""></div>
                    <div id="u614_text" class="text ">
                        <p><span>系统记录</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Unnamed (组合) -->
<!-- 个人框 (组合) -->
<div id="u661" class="ax_default" data-label="个人框" data-left="1158" data-top="77" data-width="147" data-height="36">


    <div id="nav">
        <nav class="single">
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
    <div id="u662" class="ax_default image" data-label="logo">
        <img id="u662_img" class="img " src="images/警告数/logo_u338.png"/>
    </div>

    <!-- Unnamed (水滴) -->
    <div id="u664" class="ax_default marker" title="警告数">
        <img id="u664_img" class="img " src="images/警告数/u340.png"/>
        <div id="u664_text" class="text ">
            <p><span>10</span></p>
        </div>
    </div>
</div>


<div style="position: relative;top: 250px;">
    <!--//多柱柱形图显示-->
    <div style="position:absolute;left: 210px;height: 352px;width: 700px;background: #ffffff">
        <div id="container" style="height: 100%"></div>
    </div>
    <!--//饼图显示-->
    <div style="position:absolute;left: 950px;height: 352px;width: 350px;background: #ffffff">
        <div id="circle" style="height: 90%;top: 5%"></div>
    </div>
</div>
<!--有效碰撞数-->
<div style="position: relative;top: 650px;">
    <div style="position:absolute;left: 210px;height: 352px;width: 1030px;background: #ffffff">
        <div id="histogram" style="height: 90%;top: 5%"></div>
    </div>
</div>

<!--多柱直方图绘制-->
<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};

    //时间
    var time = new Array()
    // 个人风险评估
    var data_single_loan= new Array();
    // 个人运营商风险评估
    var data_single_operator= new Array();
    //  企业经营风险评估
    var data_enterprise_risk= new Array();
    //  网贷平台评估
    var data_p2p_risk= new Array();

    <%for(int i = times.size()-1; i >=0 ; i--) {%>
    time.push("<%=times.get(i)%>")
    <%
    }%>
    <%for(int i = single_loan.size()-1; i >=0 ; i--) {%>
    data_single_loan.push("<%=single_loan.get(i)%>")
    <%
    }%>

    <%for(int i = single_operator.size()-1; i >=0 ; i--) {%>
    data_single_operator.push("<%=single_operator.get(i)%>")
    <%
    }%>

    <%for(int i = enterprise_risk.size()-1; i >=0 ; i--) {%>
    data_enterprise_risk.push("<%=enterprise_risk.get(i)%>")
    <%
    }%>

    <%for(int i = p2p_risk.size()-1; i >=0 ; i--) {%>
    data_p2p_risk.push("<%=p2p_risk.get(i)%>")

    <%
    }%>

    option = null;
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];

    app.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: app.config.rotate,
                    align: app.config.align,
                    verticalAlign: app.config.verticalAlign,
                    position: app.config.position,
                    distance: app.config.distance
                }
            };
            myChart.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {
            show: true,
            position: app.config.position,
            distance: app.config.distance,
            align: app.config.align,
            verticalAlign: app.config.verticalAlign,
            rotate: app.config.rotate,
            formatter: '{c}  {name|{a}}',
            fontSize: 10,
            rich: {
                name: {
                    textBorderColor: '#fff'
                }
            }
        }
    };

    option = {
        color: ['#003366', '#006699', '#4cabce', '#7c7c7c'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['个人贷款信用评估', '个人运营商信用风险评估', '网贷平台风险评估','企业经营风险评估']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: time
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '个人贷款信用评估',
                type: 'bar',
                barGap: 0,
                label: labelOption,
                data: data_single_loan
            },
            {
                name: '个人运营商信用风险评估',
                type: 'bar',
                label: labelOption,
                data: data_single_operator
            },
            {
                name: '网贷平台风险评估',
                type: 'bar',
                label: labelOption,
                data: data_p2p_risk
            },
            {
                name: '企业经营风险评估',
                type: 'bar',
                label: labelOption,
                data: data_enterprise_risk
            }
        ]
    };;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

<!--饼图绘制-->
<script type="text/javascript">
    var dom_circle = document.getElementById("circle");
    var myChart = echarts.init(dom_circle);
    var app = {};
    // 成员名称
    var data_member= new Array();
    <%for(int i = 0; i <memberNames.size() ; i++) {%>
    data_member.push("<%=memberNames.get(i)%>")
    <%
    }%>
    option = null;
    option = {
        title : {
            text: '成员使用占比',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series : [
            {
                name: '使用占比',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:<%=companyCount.get("**理财")==null?0:companyCount.get("**理财")%>, name:'**理财'},
                    {value:<%=companyCount.get("Operator")==null?0:companyCount.get("Operator")%>, name:'中国电信'},
                    {value:<%=companyCount.get("bank")==null?0:companyCount.get("bank")%>, name:'**银行'},
                    {value:<%=companyCount.get("enterprise")==null?0:companyCount.get("enterprise")%>, name:'**金融机构'},
                    {value:<%=companyCount.get("**理财")==null?0:companyCount.get("**理财")%>, name:'**科技'},
                    {value:<%=companyCount.get("**理财")==null?0:companyCount.get("**理财")%>, name:'**保险'},

                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

<!--有效碰撞数-->
<script type="text/javascript">
    var dom_histogram = document.getElementById("histogram");
    var myChart = echarts.init(dom_histogram);
    var app = {};
    option = null;
    app.title = '有效数据碰撞';

    option = {
        color: ['#3398DB'],
        title : {
            text: '有效数据碰撞',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : data_member,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'有效碰撞数',
                type:'bar',
                barWidth: '50%',
                data:["<%=memberSCCount.get("PersonalOperatorcount")==null?0:memberSCCount.get("PersonalOperatorcount")%>",
                    "<%=memberSCCount.get("PersonalLoancount")==null?0:memberSCCount.get("PersonalLoancount")%>",
                    "<%=memberSCCount.get("NetLoancount")==null?0:memberSCCount.get("NetLoancount")%>",
                    "<%=memberSCCount.get("enterprisecount")==null?0:memberSCCount.get("enterprisecount")%>",
                    "<%=memberSCCount.get("*")==null?0:memberSCCount.get("*")%>",
                    "<%=memberSCCount.get("*")==null?0:memberSCCount.get("*")%>"]
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

</div>
</body>
</html>
