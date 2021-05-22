package finance.ideal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.Enterprise;
import finance.ideal.domain.SingleLoan;
import finance.ideal.service.IApplicantService;
import finance.ideal.serviceImpl.ApplicantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by AIR on 2018/11/29.
 */
//模拟节点碰撞数据
public class EnterpriseSimulationCollisionUtil extends HttpServlet{

    private static List<Enterprise>  list = null;

    static{
        getList();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("in method : EnterpriseSimulationCollisionUtil-init()........");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jsonStr = JsonReader.receivePost(request);
        System.out.println("jsonStr:"+jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);

        // TODO: 2018/12/3 需要判断业务逻辑，若反欺诈评估模型都通不过，则放弃后续的评估，直接失败
        try {
            parseResult(jsonObject,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //回调函数
    public static void parseResult(JSONObject result,HttpServletRequest request,HttpServletResponse response) throws Exception {

        System.out.println("in method : EnterpriseSimulationCollisionUtil-parseResult()........");


        String name = result.getString("name");
        System.out.println("name:"+name);

        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题

        String data = "";
        for (Enterprise en : list){
            if(en.getEnterprisename().equals(name)){
                data ="{\n" +
                        "        \"投资人股权变更\":"+en.getInvestorshareschange()+",\n" +
                        "        \"公司名称变更\":"+en.getEnterprisenamechange()+",\n" +
                        "        \"法定代表人变更\":"+en.getLegalpersonchange()+",\n" +
                        "        \"注册时间\":"+en.getRegtime()+",\n" +
                        "        \"企业年报数量\":"+en.getEnterprisereportyearcount()+",\n" +
                        "        \"分支机构数量\":"+en.getSubenterprisecount()+",\n" +
                        "        \"招聘信息中销售岗占比\":"+en.getRecruitsaleproportion()+",\n" +
                        "        \"异地经营岗位数量\":"+en.getDifferentplacesworker()+",\n" +
                        "        \"企业相关负面舆情数量\":"+en.getEnterprisesentimentcount()+",\n" +
                        "        \"行政处罚\":"+en.getEnterprisesanctioncount()+",\n" +
                        "        \"失信被执行人数量\":"+en.getBreakfaithcount()+",\n" +
                        "        \"总负面舆情数\":"+en.getSentimentsum()+"\n" +
                        "}";
            }
        }

        String params ="{\n" +
                "        \"module\":\"企业经营风险评估\",\n" +
                "        \"data\":"+data+",\n" +
                "        \"model_type\":\"lr\"\n" +
                "}";

        PrintWriter out =null ;
        out =response.getWriter() ;
        out.write(params);
        out.close();

    }

    public static void getList(){
        IApplicantService service = new ApplicantServiceImpl();
        list = service.queryEnterprise();
    }

}
