package finance.ideal.ui;

import finance.ideal.daoImpl.MemberImpl;
import finance.ideal.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 联盟成员
 */
public class MemberDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String memberrolenum = request.getParameter("memberrolenum");
        String companyname = request.getParameter("companyname");
        if ("1".equals(memberrolenum)){
            System.out.println("正在进行"+companyname+"详情查询");
            doMemberGive(request,response,companyname);
        }else if ("2".equals(memberrolenum)){
            System.out.println("正在进行"+companyname+"详情查询");
            doMemberUse(request,response,companyname);
        }else if ("3".equals(memberrolenum)){
            System.out.println("正在进行"+companyname+"详情查询");
            doMemberGiveAndUse(request,response,companyname);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    public void doMemberGive(HttpServletRequest request, HttpServletResponse response,String companyname)
            throws ServletException, IOException {
        MemberImpl member = new MemberImpl();
        Member member1 = member.SendP2PMemberSelectData(companyname);
        List<String> memberNames = member.SendP2PMemberNameData();
        List<String> modelNames = member.SendP2PModelNameData();
        request.setAttribute("member",member1);//传送成员信息
        request.setAttribute("memberNames",memberNames);//传送所有的成员名称
        request.setAttribute("modelNames",modelNames);

        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/memberdetail1.jsp").forward(request, response);
    }
    public void doMemberUse(HttpServletRequest request, HttpServletResponse response,String companyname)
            throws ServletException, IOException {
        MemberImpl member = new MemberImpl();
        Member member1 = member.SendP2PMemberSelectData(companyname);
        List<String> memberNames = member.SendP2PMemberNameData();
        List<String> modelNames = member.SendP2PModelNameData();
        request.setAttribute("member",member1);//传送成员信息
        request.setAttribute("memberNames",memberNames);//传送所有的成员名称
        request.setAttribute("modelNames",modelNames);
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/memberdetail2.jsp").forward(request, response);
    }
    public void doMemberGiveAndUse(HttpServletRequest request, HttpServletResponse response,String companyname)
            throws ServletException, IOException {
        MemberImpl member = new MemberImpl();
        Member member1 = member.SendP2PMemberSelectData(companyname);
        List<String> memberNames = member.SendP2PMemberNameData();
        List<String> modelNames = member.SendP2PModelNameData();
        request.setAttribute("member",member1);//传送成员信息
        request.setAttribute("memberNames",memberNames);//传送所有的成员名称
        request.setAttribute("modelNames",modelNames);
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/memberdetail3.jsp").forward(request, response);
    }
}
