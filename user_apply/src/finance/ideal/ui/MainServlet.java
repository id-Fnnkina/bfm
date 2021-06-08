package finance.ideal.ui;

import finance.ideal.daoImpl.WorkBaseImpl;
import finance.ideal.service.IAdminService;
import finance.ideal.serviceImpl.AdminServiceImpl;
import finance.ideal.util.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆页面
 */
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取客户端请求的参数，并进行判断。
        //如果用户存在，返回一个长度为2的字符串，如果用户不存在返回一个长度为1的字符串。
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String username=request.getParameter("username");//取得用户名参数
        String password=request.getParameter("password");//取得用户密码参数
        AdminServiceImpl sc=new AdminServiceImpl();
        sc.setUsername(username);//为JavaBean设置username属性
        sc.setPassword(password);// 为JavaBean设置password属性
        System.out.println(username+password);
        try{
            if(sc.check()){  //如果用户存在
                out.print("success");  //返回"success"的一个字符串
                session.setAttribute("username", username);//将username的值存放在一个名字为"username"的变量中
                LogUtils logUtils = new LogUtils();
                logUtils.SaveLogData(username,"登录");
            }else{
                out.print("fail");  //返回"fail"的一个字符串
            }
        }catch(Exception e){
            out.print(e.toString());
        }
        out.flush();
        out.close();


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet( request,response);


    }
}
