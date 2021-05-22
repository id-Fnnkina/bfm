package finance.ideal.ui;

import finance.ideal.daoImpl.BusinessLIstImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 业务详情查询
 */
public class queryBusinessListDetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusinessLIstImpl list = new BusinessLIstImpl();
        String str_id=request.getParameter("id");
        //将list数据打包
        System.out.println("正在进行业务详情展示");
        request.setAttribute("BusinessList", list.SendBusinessListData(str_id));
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/businesslistdetail.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
