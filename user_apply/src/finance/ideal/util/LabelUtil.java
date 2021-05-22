package finance.ideal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import finance.ideal.controller.RegisterController;
import finance.ideal.domain.Applicant;
import finance.ideal.domain.LabelResult;
import finance.ideal.domain.ModelSourceStatus;
import finance.ideal.domain.SysConfig;
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
import java.util.Map;

/**
 * Created by AIR on 2018/11/29.
 */
// 组织输出标签，节点数据匹配，模型调用
public class LabelUtil extends HttpServlet{
    static Connection conn = JdbcUtils.getConnection();

    @Override
    public void init() throws ServletException {
        System.out.println("in method : LabelUtil-init()........");
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

        LabelResult rs = new LabelResult();
        IApplicantService service = new ApplicantServiceImpl();
        try{

            System.out.println("in method : LabelUtil-parseResult()........");
            String params = "true";

            PrintWriter out =null ;
            out =response.getWriter() ;
            out.write(params);
            out.close();

            System.out.println("LabelUtil：response.getWriter()");
            //Thread.sleep(2000);

            /**
             * result
             * {"ordernum":"str","result":"str","source":"str","model":"str"}
             *
             */

            rs.setOrdernum(result.getString("ordernum"));
            rs.setModel(result.getString("model"));
            rs.setSource(result.getString("source"));
            JSONObject result1;
            System.out.println("LabelUtil---get--result:"+result.getString("result"));

            result1 = JSON.parseObject(result.getString("result"));
            String data = result1.getString("data");
            if(data.length()>10){

                //发起模型调用，获得模型评估结果
                String mlabel = "";
                ChainCode c = new ChainCode();

                mlabel = c.postModel(result.getString("result"));
                System.out.println("mlabel:"+mlabel+"发起模型调用");

                //更新模型结果入库，业务表
                String s = getrs(mlabel);
                service.updateApplicant(mlabel,"1",rs.getOrdernum(),s);
                System.out.println(rs.getOrdernum()+","+rs.getModel()+"模型调用成功,结果入业务库");

                //记录模型上链
                c.invokeModel(rs);
            }else{
                service.updateApplicant("{\"prob\": {\"告警\":\"NOTFOUND PRIMARYKEY OF USERINFO\"},\"prediction\": \"ERROR\"}","1",rs.getOrdernum(),"-1");
            }
        }catch (Exception e){
            service.updateApplicant("{\"prob\": {\"告警\":\"NOTFOUND PRIMARYKEY OF USERINFO\"},\"prediction\": \"ERROR\"}","1",rs.getOrdernum(),"-1");
            e.printStackTrace();
        }finally {
            //JdbcUtils.closeConnection(conn);
        }
    }

    private static String getrs(String str){
        /**
         * {
         *"prediction": "运营中",
         *"prob": {
         *"停业或转型": "0.4640",
         *"运营中": "0.5360",
         *"问题平台": "0.0000"
         *}
         *}
         */
        JSONObject jsonObject = JSONObject.parseObject(str);
        String r = jsonObject.getString("prediction");
        String ss = "";

        if("pay".equals(r)){
            ss="1";
        }else if("信用极好".equals(r)){
            ss="1";
        }else if("不存在经营风险".equals(r)){
            ss="1";
        }else if("运营中".equals(r)){
            ss="1";
        }else{
            ss="0";
        }

        return ss;
    }

}
