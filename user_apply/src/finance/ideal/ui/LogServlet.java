package finance.ideal.ui;

import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.domain.Log;
import finance.ideal.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 日志系统
 */
public class LogServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPage(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WorkBaseImpl workBase = new WorkBaseImpl();
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
        PageUtil<Log> page = new PageUtil<Log>();
        page.setPageIndex(index);
        page.setPageSize(size);
        page.setTotalCount(workBase.logcount());
        System.out.println(page.getTotalCount());
//
        // 调用Service层进行分页查询
        workBase.RecordsLogList(page);
        request.setAttribute("page", page);
        //将list数据发送到.jap文件中
        request.getRequestDispatcher("/WEB-INF/pages/log.jsp").forward(request, response);
    }
}
