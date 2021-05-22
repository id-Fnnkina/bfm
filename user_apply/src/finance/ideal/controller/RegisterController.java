package finance.ideal.controller;

import finance.ideal.formbean.RegisterFormBean;
import finance.ideal.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AIR on 2018/10/30.
 */
public class RegisterController extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        return;
    }
}
