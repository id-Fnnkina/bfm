package finance.ideal.ui;

import finance.ideal.daoImpl.MemberImpl;
import finance.ideal.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 联盟成员显示主页
 */
public class MemberServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberImpl member = new MemberImpl();
        List<Member> list = member.SendP2PMemberData();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("正在进行联盟成员页面展示");
        if (username==null ) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else {
            request.setAttribute("list",list);
            //将list数据发送到.jap文件中
            request.getRequestDispatcher("/WEB-INF/pages/member.jsp").forward(request, response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
