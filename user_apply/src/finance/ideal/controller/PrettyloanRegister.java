package finance.ideal.controller;
import finance.ideal.domain.Applicant;
import finance.ideal.formbean.RegisterFormBean;
import finance.ideal.util.AssessmentRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AIR on 2018/10/30.
 */
public class PrettyloanRegister extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");
        System.out.println("******************************1111111111111111111&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        try {
            RegisterFormBean bean = AssessmentRequestUtil.formValidate(request);
            if(null==bean){
                request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
                return;
            }

            Applicant applicant = AssessmentRequestUtil.structureFormBean(bean);
            AssessmentRequestUtil.getRequest(applicant,"个人贷款信用评估");

            request.getRequestDispatcher("/WEB-INF/pages/wait.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
        }
    }
}
