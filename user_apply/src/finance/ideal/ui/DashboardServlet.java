package finance.ideal.ui;

import finance.ideal.daoImpl.BusinessLIstImpl;
import finance.ideal.daoImpl.DashboardImpl;
import finance.ideal.daoImpl.MemberImpl;
import finance.ideal.domain.Dashboard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 业务详情查询
 */
public class DashboardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DashboardImpl dashboard = new DashboardImpl();
        Map<String, Integer> companyCount = dashboard.SendCompanyCount(); // 使用方的统计结果
        Map<String, Integer> modelCount = dashboard.SendModelCount();// 模型使用统计结果
        Map<String, Integer> memberSCCount = dashboard.SendMemberSCCount();// 有效碰撞数据
        ArrayList<Map<String, Integer>> mapArrayList = new ArrayList<>();
        mapArrayList.add(companyCount);
        mapArrayList.add(modelCount);
        mapArrayList.add(memberSCCount);
        request.setAttribute("mapArrayList", mapArrayList);

        MemberImpl member = new MemberImpl();
        List<String> memberNames = member.SendP2PMemberNameData();// 成员的名称
        List<String> modelNames = member.SendP2PModelNameData();//模型名称
        Map<String, List> timeAndModelCount = dashboard.SendTimeAndModelCount();// 某个时间段模型使用统计结果
        request.setAttribute("memberNames",memberNames);//传送所有的成员名称
        request.setAttribute("modelNames",modelNames);
        request.setAttribute("timeAndModelCount",timeAndModelCount);
        System.out.println("正在进行综合报表信息展示");

        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
