package finance.ideal.ui;

import finance.ideal.daoImpl.P2PCompanyImpl;
import finance.ideal.domain.P2PCompany;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询公司详细信息
 */
public class P2PCompanySelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("查询公司详细信息");
        String companyName = request.getParameter("company");
        P2PCompanyImpl p2PCompany = new P2PCompanyImpl();
        P2PCompany p2PCompany1 = p2PCompany.SendP2PCompanyDataView(companyName);
        //建立了一个实体类,用来存放拿到的数据
        request.setAttribute("p2PCompany",p2PCompany1 );
        //将数据发送到.jap文件中
         request.getRequestDispatcher("/WEB-INF/pages/p2pcompany.jsp").forward(request, response);



    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
