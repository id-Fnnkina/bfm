package finance.ideal.ui;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 页面登录界面
 */

public class PrettyLoanRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//                 request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
