package finance.ideal.ui;

import finance.ideal.daoImpl.ChainCodeImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 区块链页面信息查询
 */
public class queryChainCodeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ChainCodeImpl chainCode = new ChainCodeImpl();
        //建立了一个实体类,用来存放从区块链中拿到的数据
        HttpSession session = request.getSession();
        System.out.println("正在进行区块链拉取数据查询");
        String BusinessNumber = request.getParameter("BusinessNumber");
        if (BusinessNumber != null && BusinessNumber != "") {
            request.setAttribute("BusinessNumber",BusinessNumber);
            request.setAttribute("list", chainCode.SendSelectChainCodeData(BusinessNumber));
            //将list数据发送到.jap文件中

        }else {
            request.setAttribute("list", chainCode.SendChainCodeData());
        }
        request.getRequestDispatcher("/WEB-INF/pages/chaincode.jsp").forward(request, response);
    }

        public void doPost (HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);

    }
}