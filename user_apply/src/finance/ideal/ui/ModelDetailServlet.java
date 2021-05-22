package finance.ideal.ui;

import finance.ideal.daoImpl.MemberImpl;
import finance.ideal.daoImpl.ModelImpl;
import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.domain.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 模型细节查询
 */
public class ModelDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modelname = request.getParameter("modelname");
        ModelImpl model = new ModelImpl();
        Model model1 = model.SendP2PModelSelectData(modelname);
        request.setAttribute("model",model1 );
        MemberImpl member = new MemberImpl();
        List<String> memberNames = member.SendP2PMemberNameData();
        request.setAttribute("memberNames",memberNames);
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/modeldetail.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
