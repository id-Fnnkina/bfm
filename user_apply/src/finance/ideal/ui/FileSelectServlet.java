package finance.ideal.ui;
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finance.ideal.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//上传文件
public class FileSelectServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    // 重写doPost方法，处理事件识别请求
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");
        HttpSession session = request.getSession();
        String modeltype = request.getParameter("modeltype");
        System.out.println(modeltype);
        String tableName="";
        switch (modeltype) {
            case "PersonalLoancount":
                tableName="PersonalLoancount";  // 个人贷款信用评估业务
                break;
            case "PersonalOperatorcount":
                tableName="PersonalOperatorcount";//个人运营商信用风险评估业务
                break;
            case "enterprisecount":
                tableName="enterprisecount";//企业经营风险评估业务
                break;
            case "NetLoancount":
                tableName="NetLoancount";//网贷平台风险评估业务
                break;
            case "prettyloan":
                tableName="prettyloancount";// 小额贷款业务
                break;
        }
        String userName = (String)session.getAttribute("username");
        LogUtils logUtils = new LogUtils();
        Utils utils = new Utils();
        logUtils.SaveLogData(userName, utils.turnBusinessType(modeltype)+"（批量）");
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件读写类工具

        Map<String, String> Businessvalue = new HashMap<>();
        Businessvalue.put("modeltype",modeltype);
        Businessvalue.put("tableName",tableName);
        Businessvalue.put("userName",userName);
        fwr.ReadNetFile(request, response,Businessvalue);//读取网页上的文件
//        process(request,response);
    }

}


