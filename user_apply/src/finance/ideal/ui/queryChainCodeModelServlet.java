package finance.ideal.ui;

import finance.ideal.daoImpl.ChainCodeImpl;
import finance.ideal.daoImpl.ChainCodeModelImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 区块链页面信息查询
 */
public class queryChainCodeModelServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            ChainCodeModelImpl chainCodeModel = new ChainCodeModelImpl();
            System.out.println("正在进行区块链模型使用查询");
            //建立了一个实体类,用来存放从区块链中拿到的数据
            String BusinessNumber = request.getParameter("BusinessNumber");
            if (BusinessNumber != null && BusinessNumber != "") {
                request.setAttribute("BusinessNumber", BusinessNumber);
                request.setAttribute("list", chainCodeModel.SendChainCodeModelDataByBusinessnumber(BusinessNumber));
            }else {
                request.setAttribute("list", chainCodeModel.SendChainCodeModelData());
            }
            //将list数据发送到.jap文件中
            request.getRequestDispatcher("/WEB-INF/pages/chaincodemodel.jsp").forward(request, response);
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
//        public  static void main(String[] args) {
//
//        }
}
