package finance.ideal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.Enterprise;
import finance.ideal.domain.P2p;
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
public class P2pSimulationCollisionUtil extends HttpServlet{

    private static List<P2p>  list = null;

    static{
        getList();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("in method : P2pSimulationCollisionUtil-init()........");
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

        System.out.println("in method : P2pSimulationCollisionUtil-parseResult()........");


        String name = result.getString("name");
        System.out.println("name:"+name);

        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题

        String data = "";
        for (P2p p : list){
            if(p.getP2pname().equals(name)){
                data ="{\n" +
                        "        \"grade\":"+p.getGrade()+",\n" +
                        "        \"time\":"+p.getTime()+",\n" +
                        "        \"rate\":"+p.getRate()+",\n" +
                        "        \"bank\":"+p.getBank()+",\n" +
                        "        \"finacing\":"+p.getFinacing()+",\n" +
                        "        \"regulation\":"+p.getRegulation()+",\n" +
                        "        \"auto\":"+p.getAuto()+",\n" +
                        "        \"assignment\":"+p.getAssignment()+",\n" +
                        "        \"ICP\":"+p.getICP()+",\n" +
                        "        \"IPO\":"+p.getIPO()+",\n" +
                        "        \"month\":"+p.getMonth()+",\n" +
                        "        \"register\":"+p.getRegister()+",\n" +
                        "        \"protection\":"+p.getProtection()+"\n" +
                        "}";
            }
        }

        String params ="{\n" +
                "        \"module\":\"网贷平台风险评估\",\n" +
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
        list = service.queryP2p();
    }

}
