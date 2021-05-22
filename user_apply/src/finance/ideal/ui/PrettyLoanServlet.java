package finance.ideal.ui;

import finance.ideal.daoImpl.PrettyLoanImpl;
import finance.ideal.domain.PrettyLoan;
import finance.ideal.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 小额贷款页面信息
 */
public class PrettyLoanServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if (username==null ) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else {
        doPage(request,response);
    }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    public void doPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrettyLoanImpl pl = new PrettyLoanImpl();//小额贷款业务
        // 根据action决定作什么操作
        String action = request.getParameter("action");
        //分页查询
        // 获取当前页数参数
        String pageIndex = request.getParameter("pageIndex");
        // 获取页面大小参数（每页显示的数量）
        // String pageSize = request.getParameter("pageSize");
        int index = 1;// 设置首页为1
        int size = 10;// 设置页面大小为8条数据
        try {
            if (pageIndex == null) {
                index = 1;
            } else {
                index = Integer.parseInt(pageIndex);
            }

            // size=Integer.parseInt(pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将分页参数封装到分页对象中
        PageUtil<PrettyLoan> page = new PageUtil<PrettyLoan>();
        page.setPageIndex(index);
        page.setPageSize(size);
        page.setTotalCount(pl.count("prettyloancount"));
//
        // 调用Service层进行分页查询
        pl.RecordsList(page,"prettyloancount");

        // 尾页填充空白行(为了视觉美观)（效果图如下图中的空白行）
        List<PrettyLoan> recordsList = page.getDataList();
        if (recordsList.size() < page.getPageSize()) {
            for (int i = recordsList.size(); i < page.getPageSize(); i++)
                recordsList.add(null);
        }
        page.setDataList(recordsList);
        System.out.println("正在进行小额贷款页面展示");
        // 将业务层处理后的分页对象存放至request作用域中
        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/pages/prettyloan.jsp").forward(request, response);
    }

}
