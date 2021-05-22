package finance.ideal.daoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.dao.IChainCode;
import finance.ideal.domain.ChainCodeDomain;
import finance.ideal.util.ChainCodeUtils;
import finance.ideal.util.JdbcUtils;
import finance.ideal.util.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChainCodeImpl implements IChainCode {
  /*
  发送查询链码数据
   */
    @Override
    public List<ChainCodeDomain> SendChainCodeData() {
        ArrayList<ChainCodeDomain> list= new ArrayList<>();
        ChainCodeUtils c = new ChainCodeUtils();//链码的工具
        Utils utils = new Utils();
        String params ="{\n" +
                "  \"userName\"        : \"111\",\n" +
                "  \"args\"            : [\"10\",\"\"],\n" +
                "  \"channelName\"     : \"idealchannel\",\n" +
                "  \"chainCodeName\"   : \"VerifyChainCode\",\n" +
                "  \"chainCodeVersion\": \"1.0\",\n" +
                "  \"function\"        : \"queryalllistforpage\",\n" +
                "  \"peerWithOrg\"     :\"peerOrg1\"\n" +
                "}\n";
        try {
            String ret= c.doPost(c.queryUrl,params,"");
            Map resultInvoke = (Map) JSONObject.parse(ret);//查询后json
            System.out.println(ret);
            Map jsonData=(Map) JSONObject.parse((String) resultInvoke.get("data"));// data对应的内容
            JSONArray records = (JSONArray)jsonData.get("records");//得到内部的数据数组
            //遍历得到的数据上传到网页
            if(records.size()!=0&&records.size()<=10){
                for (int i = 0; i < records.size(); i++) {

                    Map data = (Map)records.get(i);
                    ChainCodeDomain chainCode = new ChainCodeDomain();//这个是链码对象
                    chainCode.setRecordId((String)data.get("recordId"));
                    chainCode.setRealName((String)data.get("realName"));// 业务主体

                    Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
                    Matcher matcher = pattern.matcher((String)data.get("verifyDate"));
                    boolean rs = matcher.find();
                    if (rs){
                        long l = Long.parseLong((String)data.get("verifyDate"));
                        String s = utils.transferLongToDate("yyyy-MM-dd HH:mm:ss", l);
                        chainCode.setVerifyDate(s);
                    }else {
                        chainCode.setVerifyDate((String)data.get("verifyDate"));// 业务办理时间
                    }

                    chainCode.setBankCard((String)data.get("bankCard"));// 银行卡号
                    chainCode.setHashData((String)data.get("hashData"));// 结果hash值
                    chainCode.setMobile((String)data.get("mobile"));// 手机号
                    chainCode.setTxId((String)data.get("txId"));// 业务ID

                    String businessNumber = (String) data.get("businessNumber");
                    chainCode.setBusinessNumber(businessNumber);// 序列号

                    chainCode.setRemark((String)data.get("remark"));// 业务标记

                    String source = utils.turnBusinessType((String) data.get("source"))+"模型";
//                    System.out.println("source"+source);

                    String turnSourceType = source.equals("来源未知模型")?"来源未知模型":utils.turnSourceType(source);
                    chainCode.setSource(turnSourceType);// 数据源

                    chainCode.setIdNo((String)data.get("idNo"));// 业务号

                    String businessTypeId=(String) data.get("businessTypeId");
                    String turnBusinessType=businessTypeId.equals("BusinessTypeId")?"BusinessTypeId":utils.turnBusinessType(businessTypeId);;
                    chainCode.setBusinessTypeId(turnBusinessType);// 业务类型

                    String turnComanyNemeBusinessType=businessTypeId.equals("BusinessTypeId")?"BusinessTypeId":utils.SelectComapnynameByBusinessNumber(businessTypeId,businessNumber);
                    chainCode.setCompanyName(turnComanyNemeBusinessType);// 业务申请方

                    chainCode.setTaskType(utils.SelectServicetypeByBusinessnumber(businessNumber));
                    list.add(chainCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
    return list;
    }
    @Override
    public ChainCodeDomain SendChainCodeDataDetail(String recordId){
        List<ChainCodeDomain> list = this.SendChainCodeData();
        ChainCodeDomain chainCode=new ChainCodeDomain();
        for (int i = 0; i < list.size(); i++) {
             chainCode=(ChainCodeDomain)list.get(i);
            if (recordId.equals(chainCode.getRecordId())){
                return chainCode;
            }
        }
        return chainCode;
    }

    /*
    发送查询链码数据
     */
    @Override
    public List<ChainCodeDomain> SendSelectChainCodeData(String BusinessNumber ) {
        ArrayList<ChainCodeDomain> list= new ArrayList<ChainCodeDomain>();
        ChainCodeUtils c = new ChainCodeUtils();//链码的工具
        Utils utils = new Utils();
        String params ="{\n" +
                "  \"userName\"        : \"111\",\n" +
                "  \"args\"            : [\""+BusinessNumber+"\",\"10\",\"\"], \n" +
                "  \"channelName\"     : \"idealchannel\",\n" +
                "  \"chainCodeName\"   : \"VerifyChainCode\",\n" +
                "  \"chainCodeVersion\": \"1.0\",\n" +
                "  \"function\"        : \"queryListForPage\",\n" +
                "  \"peerWithOrg\"     :\"peerOrg1\"\n" +
                "}\n" +
                "\n";
        try {
            String ret= c.doPost(c.queryUrl,params,"");
            System.out.println(params);
            Map resultInvoke = (Map) JSONObject.parse(ret);//查询后json
            System.out.println(resultInvoke.get("data"));
            Map jsonData=(Map) JSONObject.parse((String) resultInvoke.get("data"));// data对应的内容
            JSONArray records = (JSONArray)jsonData.get("records");//得到内部的数据数组

            //遍历得到的数据上传到网页
            if(records.size()!=0&&records.size()<=10){
                for (int i = 0; i < records.size(); i++) {
                    Map data = (Map)records.get(i);
                    ChainCodeDomain chainCode = new ChainCodeDomain();//这个是链码对象
                    chainCode.setRecordId((String)data.get("recordId"));
                    chainCode.setRealName((String)data.get("realName"));
                    long l = Long.parseLong((String)data.get("verifyDate"));
                    chainCode.setVerifyDate(utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                    chainCode.setBankCard((String)data.get("bankCard"));
                    chainCode.setHashData((String)data.get("hashData"));
                    chainCode.setMobile((String)data.get("mobile"));
                    chainCode.setTxId((String)data.get("txId"));
                    chainCode.setBusinessNumber((String)data.get("businessNumber"));
                    chainCode.setRemark((String)data.get("remark"));
                    String source = utils.turnBusinessType((String) data.get("source"));
                    String turnSourceType = utils.turnSourceType(source);
                    chainCode.setSource(turnSourceType);
                    chainCode.setIdNo((String)data.get("idNo"));
                    chainCode.setBusinessTypeId(utils.turnBusinessType((String)data.get("businessTypeId")));
                    list.add(chainCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return list;
    }

}
