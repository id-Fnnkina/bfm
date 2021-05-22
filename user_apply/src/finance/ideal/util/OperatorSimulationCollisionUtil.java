package finance.ideal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.SingleLoan;
import finance.ideal.domain.SingleOperator;
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
public class OperatorSimulationCollisionUtil extends HttpServlet{

    private static List<SingleOperator>  list = null;

    static{
        getList();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("in method : OperatorSimulationCollisionUtil-init()........");
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

        System.out.println("in method : OperatorSimulationCollisionUtil-parseResult()........");

        String uphone = result.getString("uphone");
        System.out.println("uphone: "+uphone);

        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题

        String data = "";
        for (SingleOperator so : list){
            if(so.getUphone().equals(uphone)){
                data ="{\n" +
                        "        \"是否为黑名单\":\""+so.getIsblack()+"\",\n" +
                        "        \"是否欠费\":\""+so.getIsarrears()+"\",\n" +
                        "        \"套餐金额\":"+so.getSetmeal()+",\n" +
                        "        \"月消费金额档次\":\""+so.getMonthlevel()+"\",\n" +
                        "        \"工作地GPS经纬度\":\""+so.getWorkgps()+"\",\n" +
                        "        \"居住地GPS经纬度\":\""+so.getHomegps()+"\",\n" +
                        "        \"娱乐地GPS经纬度\":\""+so.getPlaygps()+"\",\n" +
                        "        \"电商\":\""+so.getBuyapp()+"\",\n" +
                        "        \"游戏\":\""+so.getGameapp()+"\",\n" +
                        "        \"视频\":\""+so.getMovieapp()+"\",\n" +
                        "        \"财经\":\""+so.getFinanceapp()+"\"\n" +
                        "}";
            }
        }



        String params ="{\n" +
                "        \"module\":\"个人运营商信用风险评估\",\n" +
                "        \"data\":"+data+",\n" +
                "        \"model_type\":\"tree\"\n" +
                "}";

        PrintWriter out =null ;
        out =response.getWriter() ;
        out.write(params);
        out.close();

    }

    public static void getList(){
        IApplicantService service = new ApplicantServiceImpl();
        list = service.querySingleOperator();
    }

}
