package finance.ideal.ui;

import finance.ideal.daoImpl.ArithmeticImpl;
import finance.ideal.daoImpl.ModelImpl;
import finance.ideal.domain.Arithmetic;
import finance.ideal.domain.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 评估模型管理
 */
public class ModelServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelImpl model = new ModelImpl();
        List<Model> listModel = model.SendP2PModelData();
        ArithmeticImpl arithmetic = new ArithmeticImpl();
        List<Arithmetic> listArithmetics = arithmetic.SendArithmeticData();
        System.out.println("正在进行模型页面展示");
        request.setAttribute("listModel",listModel );
        request.setAttribute("listArithmetics",listArithmetics );

        //将list数据发送到.jsp文件中
        request.getRequestDispatcher("/WEB-INF/pages/modeltest.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
