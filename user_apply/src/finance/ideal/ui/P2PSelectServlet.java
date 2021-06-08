package finance.ideal.ui;

import finance.ideal.daoImpl.P2PCompanyImpl;
import finance.ideal.domain.P2PCompany;
import finance.ideal.util.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 查找某公司        "未用到"
 */
public class P2PSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if (username==null ) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else {
            LogUtils logUtils = new LogUtils();
            System.out.println("正在进行公司信息查询");
            logUtils.SaveLogData(username,"P2P企业风险评估");
            String company = request.getParameter("company");
            P2PCompanyImpl p2PCompany = new P2PCompanyImpl();
            List<P2PCompany> list = p2PCompany.SendP2PCompanyDataSelect(company);
            //建立了一个实体类,用来存放拿到的数据
            request.setAttribute("list", list);
            //将数据发送到.jap文件中
            try {
                request.getRequestDispatcher("/WEB-INF/pages/p2ploan.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
    public void doSelect(HttpServletRequest request, HttpServletResponse response){

    }
    public void doLook(HttpServletRequest request, HttpServletResponse response){

    }
}
