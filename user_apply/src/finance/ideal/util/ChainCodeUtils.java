package finance.ideal.util;

import com.alibaba.fastjson.JSONObject;
import finance.ideal.domain.Applicant;
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
import java.util.Date;

/**
 * Created by AIR on 2018/11/22.
 */
public class ChainCodeUtils {
    String token = "wwwwwwwwwwwwwwwwwwwwwwwwww";

    //园区
    //final static  String baseUrl = "http://192.168.20.68:8031/";
//    final static  String baseUrl = "http://172.31.24.34:8031/enroll";
//    final static  String invokeUrl = "http://172.31.24.34:8031/api/invoke";
//    public final static  String queryUrl = "http://172.31.24.34:8031/api/query";
    //复旦
    final static  String baseUrl = "http://10.190.11.72:8031/enroll";
    final static  String invokeUrl = "http://10.190.11.72:8031/api/invoke";
    public final static  String queryUrl = "http://10.190.11.72:8031/api/query";

    public void invoke(Applicant applicant, SysConfig sc, String source) throws Exception {

        String RecordId2 = String.valueOf(System.currentTimeMillis());
        String VerifyDate = "";
        String inParams = "id=111&name =222";
        String [] p = sc.getInparam().split(",");
//        for(String s : p){
//            if("uphone".equals(s)){
//                inParams.append("uphone="+applicant.getUphone()+"&");
//            }else if("cardnum".equals(s)){
//                inParams.append("cardnum="+applicant.getIdnumber());
//            }
//        }


//      String params = "{ \"passWord\": \"123\", \"peerWithOrg\": \"peerOrg1\", \"userName\": \"zhangwei\"}";
        Date dt= new Date();
        Long time= dt.getTime();
        System.out.println(time);
        String params ="{\n" +
                "    \"args\":[\n" +
                "        \""+time+"\",\n" +
                "        \""+applicant.getOrdernum()+"\",\n" +
                "        \""+applicant.getServietype()+"\",\n" +
                "        \""+applicant.getIdnumber()+"\",\n" +
                "        \""+applicant.getUname()+"\",\n" +
                "        \""+applicant.getUphone()+"\",\n" +
                "        \""+applicant.getBankcard()+"\",\n" +
                "        \""+source+"\",\n" +
                "        \""+VerifyDate+"\",\n" +
                "        \"http://172.31.24.34:8031/index/\",\n" +
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
        System.out.println(params);
//        System.out.println(taskName + "=========" + data.adName);
//        System.out.println(params);
//        System.out.println("数据序号："+data.radom);

        String ret = doPost(invokeUrl, params, "");

        JSONObject jsonObject = JSONObject.parseObject(ret);
        if ("000000".equals(jsonObject.getString("code"))) {
            System.out.println(" 合约调用成功！ ");
            //scCount.addAndGet(1);
        } else {
            //system.err.println(data.getClass() + " 合约调用失败！");
            //flCount.addAndGet(1);
            System.out.println(jsonObject.getString("msg")   );
            System.out.println("合约调用失败！");
            //throw new Exception(jsonObject +" "+data.toString());
        }
    }

    public void query(Applicant applicant, SysConfig sc, String source) throws Exception {
        String RecordId2 = String.valueOf(System.currentTimeMillis());
        String VerifyDate = "";
        String inParams = "id=111&name =222";
        String [] p = sc.getInparam().split(",");
//        for(String s : p){
//            if("uphone".equals(s)){
//                inParams.append("uphone="+applicant.getUphone()+"&");
//            }else if("cardnum".equals(s)){
//                inParams.append("cardnum="+applicant.getIdnumber());
//            }
//        }


//      String params = "{ \"passWord\": \"123\", \"peerWithOrg\": \"peerOrg1\", \"userName\": \"zhangwei\"}";
        System.out.println(applicant.getOrdernum()+applicant.getBankcard());
        String params ="{\n" +
                "    \"userName\":\"111\",\n" +
                "    \"args\":[\n" +
                "    \""+applicant.getOrdernum()+"\"\n" +
                "    ],\n" +
                "    \"channelName\":\"idealchannel\",\n" +
                "    \"chainCodeName\":\"VerifyChainCode\",\n" +
                "    \"chainCodeVersion\":\"1.0\",\n" +
                "    \"function\":\"queryListByBusinessNumber\",\n" +
                "    \"peerWithOrg\":\"peerOrg1\"\n" +
                "}";

//        System.out.println(taskName + "=========" + data.adName);
//        System.out.println(params);
//        System.out.println("数据序号："+data.radom);

        String ret = doPost(queryUrl, params, "");

        JSONObject jsonObject = JSONObject.parseObject(ret);
        if ("000000".equals(jsonObject.getString("code"))) {
            System.out.println(" 合约调用成功！ ");
            System.out.println(jsonObject.getString("data"));
            //scCount.addAndGet(1);
        } else {
            //system.err.println(data.getClass() + " 合约调用失败！");
            //flCount.addAndGet(1);
            System.out.println(jsonObject.getString("msg")   );
            System.out.println("合约调用失败！");
            //throw new Exception(jsonObject +" "+data.toString());
        }
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
//    public static void main(String[] args) throws Exception {
//        Chaincode chaincode = new Chaincode();
//        chaincode.quer();
//    }


}
