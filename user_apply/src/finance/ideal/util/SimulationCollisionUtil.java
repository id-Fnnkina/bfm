package finance.ideal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.SingleLoan;
import finance.ideal.service.IApplicantService;
import finance.ideal.serviceImpl.ApplicantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;


/**
 * Created by AIR on 2018/11/29.
 */
//模拟节点碰撞数据
public class SimulationCollisionUtil extends HttpServlet{

    private static List<SingleLoan>  list = null;

    static{
        getList();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("in method : SimulationCollision-init()........");
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

        System.out.println("in method : SimulationCollision-parseResult()........");

        String uphone = result.getString("uphone");
        String cardnum = result.getString("cardnum");
        String uname = result.getString("uname");

        System.out.println("uphone+ "+uphone+" +cardnum "+cardnum);


        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题



        String data = "";
        for (SingleLoan sl : list){
            if(sl.getCardnum().equals(cardnum)){
                data ="{\n" +
                        "        \"借款金额\":"+sl.getLimit()+",\n" +
                        "        \"借款期限\":"+sl.getTerm()+",\n" +
                        "        \"借款利率\":"+sl.getInterest_rate()+",\n" +
                        "        \"初始评级\":"+sl.getLevel()+",\n" +
                        "        \"借款类型\":"+sl.getType()+",\n" +
                        "        \"是否首标\":"+sl.getIsfrist()+",\n" +
                        "        \"年龄\":"+sl.getAge()+",\n" +
                        "        \"性别\":"+sl.getSex()+",\n" +
                        "        \"手机认证\":"+sl.getPhoneok()+",\n" +
                        "        \"户口认证\":"+sl.getHukouok()+",\n" +
                        "        \"视频认证\":"+sl.getShipinok()+",\n" +
                        "        \"学历认证\":"+sl.getXueliok()+",\n" +
                        "        \"征信认证\":"+sl.getZhenxinok()+",\n" +
                        "        \"淘宝认证\":"+sl.getTaobaook()+",\n" +
                        "        \"历史成功借款次数\":"+sl.getHiscount()+",\n" +
                        "        \"历史成功借款金额\":"+sl.getHislimit()+",\n" +
                        "        \"总待还本金\":"+sl.getSumlimit()+",\n" +
                        "        \"历史正常还款期数\":"+sl.getHishuanokcount()+",\n" +
                        "        \"历史逾期还款期数\":"+sl.getHishuanerrcount()+"\n" +
                        "}";
            }
        }



        String params ="{\n" +
                "        \"module\":\"个人贷款信用评估\",\n" +
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
        list = service.querySingleLoan("");
    }

}
