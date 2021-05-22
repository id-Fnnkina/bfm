package finance.ideal.ui;

import finance.ideal.daoImpl.ChainCodeImpl;
import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 区块链详情查询
 */
public class queryChainCodeDetailServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            System.out.println("正在进行区块链拉取数据详情查询");
            String username = (String)session.getAttribute("username");
            if (username==null ) {
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }else {
            String recordId = request.getParameter("recordid");
            System.out.println(recordId);
            ChainCodeImpl chainCode = new ChainCodeImpl();

                Utils utils = new Utils();

                //建立了一个实体类,用来存放从区块链中拿到的数据
            request.setAttribute("companyname",utils.SelectUserName(username));
            request.setAttribute("recordid",chainCode.SendChainCodeDataDetail(recordId));
            //将list数据发送到.jap文件中
            request.getRequestDispatcher("/WEB-INF/pages/chaincodedetail.jsp").forward(request, response);
        }
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
//        public  static void main(String[] args) {
//
//        }
}
