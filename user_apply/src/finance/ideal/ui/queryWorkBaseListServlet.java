package finance.ideal.ui;

import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.domain.Applicant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 金融业务页面信息
 */
public class queryWorkBaseListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("正在进行金融业务页面信息1展示");

        String username = (String)session.getAttribute("username");
        if (username==null ) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else {
        String ordernum = request.getParameter("ordernum");
        WorkBaseImpl workBase = new WorkBaseImpl();
        Applicant applicant = workBase.SendWorkBaseListData(ordernum);
        //将list数据打包
        request.setAttribute("applicant", applicant);
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/workbaselist.jsp").forward(request, response);
    }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
