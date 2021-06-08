package finance.ideal.ui;

import finance.ideal.daoImpl.P2PCompanyImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * P2P页面信息      "未用到"
 */

public class P2PServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        P2PCompanyImpl p2PCompany = new P2PCompanyImpl();
        System.out.println("正在尽心P2P公司信息展示");
        //建立了一个实体类,用来存放从区块链中拿到的数据
        request.setAttribute("list", p2PCompany.SendP2PCompanyData());
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/p2ploan.jsp").forward(request, response);
        String userName = request.getParameter("company");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
