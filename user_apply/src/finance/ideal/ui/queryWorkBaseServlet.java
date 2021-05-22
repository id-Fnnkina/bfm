package finance.ideal.ui;

import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.domain.workPlace;
import finance.ideal.util.PageUtil;
import finance.ideal.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 金融业务页面信息
 */
public class queryWorkBaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String time = request.getParameter("time");
        if (username==null ) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else if (time!=null&&time!=""){
            System.out.println("正在进行金融业务页面信息2展示");

            String[] selectTime = time.split(" - ");
            doSelectPage(request,response,username,selectTime);
        }else {
                doPage(request,response,username);
        }}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    public void doPage(HttpServletRequest request, HttpServletResponse response,String username)
            throws ServletException, IOException {
        WorkBaseImpl workBase = new WorkBaseImpl();
        Utils utils = new Utils();
        request.setAttribute("companyname",utils.SelectUserName(username));
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
        PageUtil<workPlace> page = new PageUtil<workPlace>();
        page.setPageIndex(index);
        page.setPageSize(size);
        page.setTotalCount(workBase.count());
//
        // 调用Service层进行分页查询
        workBase.RecordsBusinessList(page);



        // 将业务层处理后的分页对象存放至request作用域中
        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/pages/workplace.jsp").forward(request, response);
    }


    public void doSelectPage(HttpServletRequest request, HttpServletResponse response,String username,String[] selectTime)
            throws ServletException, IOException {
        WorkBaseImpl workBase = new WorkBaseImpl();
        Utils utils = new Utils();
        request.setAttribute("companyname",utils.SelectUserName(username));
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
        PageUtil<workPlace> page = new PageUtil<workPlace>();
        page.setPageIndex(index);
        page.setPageSize(size);
        page.setTotalCount(workBase.count());
//
        // 调用Service层进行分页查询
        workBase.SelectRecordsList(page,selectTime);



        // 将业务层处理后的分页对象存放至request作用域中
        request.setAttribute("selectTime", selectTime);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/pages/workplace.jsp").forward(request, response);
    }

}
