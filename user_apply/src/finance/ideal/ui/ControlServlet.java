package finance.ideal.ui;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AIR on 2018/10/30.
 */

public class ControlServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
                 doPost(request, response);

             }

             public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
//                 request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
                 request.getRequestDispatcher("/WEB-INF/pages/main.jsp").forward(request, response);
                 //request.getRequestDispatcher("index.jsp").forward(request, response);
             }
}
