package finance.ideal.ui;

import finance.ideal.daoImpl.P2PCompanyImpl;
import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.domain.Log;
import finance.ideal.domain.State;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 系统日志详情
 */
public class LogDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("state")){
            doState(request,response);
        }else {
            doOperate(request,response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    /**
     * 系统操作日志详情
     * @param request
     * @param response
     */
    public void doOperate(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        //建立了一个实体类,用来存放拿到的数据
        WorkBaseImpl workBase = new WorkBaseImpl();
        Log log = workBase.SendLogOperateDetailData(id);
        request.setAttribute("log",log );
        //将数据发送到.jap文件中
        try {
            request.getRequestDispatcher("/WEB-INF/pages/logoperatedetail.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 系统安全日志
     * @param request
     * @param response
     */
    public void doState(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        //建立了一个实体类,用来存放拿到的数据
        WorkBaseImpl workBase = new WorkBaseImpl();
        State state = workBase.SendLogStateDetailData(id);
        request.setAttribute("state",state );
        //将数据发送到.jap文件中
        try {
            request.getRequestDispatcher("/WEB-INF/pages/logstatedetail.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
