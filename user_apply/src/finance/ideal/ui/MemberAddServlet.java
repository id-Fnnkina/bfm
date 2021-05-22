package finance.ideal.ui;

import finance.ideal.dao.IMember;
import finance.ideal.daoImpl.MemberImpl;
import finance.ideal.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 添加联盟成员
 */
public class MemberAddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");
        String method = request.getParameter("method");
        if ("add".equals(method)){
            request.getRequestDispatcher("WEB-INF/pages/memberadd.jsp").forward(request, response);
        }else {
            doSendData(request,response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    public void doSendData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = new Member();
        System.out.println("进行添加联盟成员");
        member.setCompanyname(request.getParameter("companyname"));//公司名称
        member.setMemberrole(request.getParameter("memberrole"));//成员角色
        member.setIntroduce(request.getParameter("introduce"));//功能介绍
        member.setMemberlabel(request.getParameter("memberlabel"));//碰撞之后返回的标签
        member.setBusinesstype(request.getParameter("businesstype"));//业务类型
        //将list数据发送到.jap文件中
        IMember iMember = new MemberImpl();
        iMember.SendChaincodeMemberData(member);
        request.getRequestDispatcher("WEB-INF/pages/memberapplyover.jsp").forward(request, response);
    }
}
