package finance.ideal.util;

import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.Applicant;
import finance.ideal.domain.LabelResult;
import finance.ideal.domain.SysConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by AIR on 2018/11/22.
 */
public class ChainCode {
    String token = "wwwwwwwwwwwwwwwwwwwwwwwwww";

    //final static  String baseUrl = "http://192.168.20.68:8031/";
    final static  String baseUrl = "http://172.31.24.34:8031/enroll";
    final static  String invokeUrl = "http://172.31.24.34:8031/api/invoke";
    final static  String Url1 = "http://172.31.24.34:8031/index";
    final static  String Url2 = "http://172.31.24.34:8031/actuator/info";
    final static  String modelUrl = "http://47.101.169.47:5000/predict";

    //fudan
//    final static  String baseUrl = "http://10.190.11.70:8031/enroll";
//    final static  String invokeUrl = "http://10.190.11.70:8031/api/invoke";
//    final static  String Url1 = "http://10.190.11.70:8031/index";
//    final static  String Url2 = "http://10.190.11.70:8031/actuator/info";
//    final static  String modelUrl = "http://47.101.169.47:5000/predict";

    public void invoke(Applicant applicant, SysConfig sc, String source,String sourceUrl) throws Exception {

        String RecordId2 = String.valueOf(System.currentTimeMillis());
        //StringBuilder inParams = new StringBuilder();
        String inParams = "";
        String [] p = sc.getInparam().split(",");
        inParams = "{";

        for (int i=0; i<p.length; i++){
            if("uphone".equals(p[i])){
                if(i==p.length-1){
                    //inParams.append("uphone="+applicant.getUphone());
                    inParams = inParams+"\\\"uphone\\\":"+"\\\""+applicant.getUphone()+"\\\""+"}";
                }else{
                    //inParams.append("uphone="+applicant.getUphone()+"&");
                    inParams = inParams+"\\\"uphone\\\":"+"\\\""+applicant.getUphone()+"\\\""+",";
                }
            }else if("cardnum".equals(p[i])){
                if(i==p.length-1){
                    //inParams.append("cardnum="+applicant.getIdnumber());
                    inParams = inParams+"\\\"cardnum\\\":"+"\\\""+applicant.getIdnumber()+"\\\""+"}";
                }else{
                    //inParams.append("cardnum="+applicant.getIdnumber()+"&");
                    inParams = inParams+"\\\"cardnum\\\":"+"\\\""+applicant.getIdnumber()+"\\\""+",";
                }
            }else if("name".equals(p[i])){
                if(i==p.length-1){
                    inParams = inParams+"\\\"name\\\":"+"\\\""+applicant.getUname()+"\\\""+"}";
                    //inParams.append("name="+applicant.getUname());
                }else{
                    inParams = inParams+"\\\"name\\\":"+"\\\""+applicant.getUname()+"\\\""+",";
                    //inParams.append("name="+applicant.getUname()+"&");
                }
            }
        }
        String VerifyDate = String.valueOf(System.currentTimeMillis());
        //inParams 格式
        /**
         * uphone=b6fab4934c00509c1ee7cd7ba7eee359&cardnum=8450ef6e991668df9f204f46b9173443&name=张三
         */

        /**
         * {"uphone":"17317718229","cardnum":"422678879011986678","name":"张三"}
         */

//      String params = "{ \"passWord\": \"123\", \"peerWithOrg\": \"peerOrg1\", \"userName\": \"zhangwei\"}";
        String params ="{\n" +
                "    \"args\":[\n" +
                "        \""+RecordId2+"\",\n" +
                "        \""+applicant.getOrdernum()+"\",\n" +
                "        \""+applicant.getServietype()+"\",\n" +
                "        \""+applicant.getIdnumber()+"\",\n" +
                "        \""+applicant.getUname()+"\",\n" +
                "        \""+applicant.getUphone()+"\",\n" +
                "        \""+applicant.getBankcard()+"\",\n" +
                "        \""+source+"\",\n" +
                "        \""+VerifyDate+"\",\n" +
                "        \""+sc.getAssessmentmodel()+"\",\n" +
                "        \""+sourceUrl+"\",\n" +
                "        \""+inParams+"\"\n" +
                "    ],\n" +
                "    \"chainCodeName\":\"VerifyChainCode\",\n" +
                "    \"function\":\"verify\",\n" +
                "    \"chainCodeVersion\":\"1.0\",\n" +
                "    \"userName\":\"111\",\n" +
                "    \"belongWithOrg\":\"peerOrg1\",\n" +
                "    \"channelName\":\"idealchannel\",\n" +
                "    \"peerWithOrgs\":[\n" +
                "        \"peerOrg1\"\n" +
                "    ]\n" +
                "}";

        System.out.println("inParams:"+inParams);
        System.out.println("params:"+params);

        String ret = doPost(invokeUrl, params, "");

        JSONObject jsonObject = JSONObject.parseObject(ret);
        if ("000000".equals(jsonObject.getString("code"))) {
            System.out.println(" 合约调用成功！ ");
            System.out.println("in method:ChainCode-invoke");
            //scCount.addAndGet(1);
        } else {
            //system.err.println(data.getClass() + " 合约调用失败！");
            //flCount.addAndGet(1);
            System.out.println(jsonObject.getString("msg")   );
            System.out.println("合约调用失败！");
            System.out.println("in method:ChainCode-invoke");
//            for (int i=0; i<3; i++){
//                Thread.sleep(1000);
//                invoke(applicant, sc, source, sourceUrl);
//            }
            //throw new Exception(jsonObject +" "+data.toString());
        }
    }



    public void invokeModel(LabelResult rs) throws Exception {

        String RecordId1 = String.valueOf(System.currentTimeMillis());
        String ordernum = rs.getOrdernum();
        String servicetype = rs.getSource();
        String modelid = "128";
        String modelversion = "1.0";
        String model = rs.getModel();
        String hashdata = rs.getModel();
        String Remark = rs.getModel();
        String time = String.valueOf(System.currentTimeMillis());


        String params ="{\n" +
                "    \"args\":[\n" +
                "        \""+RecordId1+"\",\n" +
                "        \""+ordernum+"\",\n" +
                "        \""+servicetype+"\",\n" +
                "        \""+modelid+"\",\n" +
                "        \""+modelversion+"\",\n" +
                "        \""+model+"\",\n" +
                "        \""+hashdata+"\",\n" +
                "        \""+Remark+"\",\n" +
                "        \""+time+"\"\n" +
                "    ],\n" +
                "    \"chainCodeName\":\"EstimateChainCode\",\n" +
                "    \"function\":\"estimate\",\n" +
                "    \"chainCodeVersion\":\"1.0\",\n" +
                "    \"userName\":\"111\",\n" +
                "    \"belongWithOrg\":\"peerOrg1\",\n" +
                "    \"channelName\":\"idealchannel\",\n" +
                "    \"peerWithOrgs\":[\n" +
                "        \"peerOrg1\"\n" +
                "    ]\n" +
                "}";

        String ret = doPost(invokeUrl, params, "");

        JSONObject jsonObject = JSONObject.parseObject(ret);
        if ("000000".equals(jsonObject.getString("code"))) {
            System.out.println(" 合约调用成功！ ");
            System.out.println("in method:ChainCode-invokeModel");
        } else {
            System.out.println(jsonObject.getString("msg")   );
            System.out.println("合约调用失败！");
            System.out.println("in method:ChainCode-invokeModel");
        }
    }



    public String postModel(String params) throws Exception {

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

        String ret = doPost(modelUrl, params, "");

        JSONObject jsonObject = JSONObject.parseObject(ret);
        if (null !=jsonObject.getString("prediction")) {
            System.out.println(" 模型调用成功！ ");
            System.out.println("in method:ChainCode-postModel");
            return jsonObject.toString();
        } else {
            //System.out.println(jsonObject.getString("msg")   );
            System.out.println("模型调用失败！");
            System.out.println("in method:ChainCode-postModel");
        }
        return "";
    }



    /**
     * post请求（用于请求json格式的参数）
     *
     * @param url
     * @param params
     * @return
     */
    public String doPost(String url, String params, String Authorization) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        if (Authorization != null) {
            httpPost.setHeader("Authorization", Authorization);
        }
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            } else {
                System.err.println("请求返回:" + state + "(" + url + ")");
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
