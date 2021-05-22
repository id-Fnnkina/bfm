package finance.ideal.daoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import finance.ideal.dao.IChainCodeModel;
import finance.ideal.domain.ChainCodeDomain;
import finance.ideal.domain.ChainCodeModelDomain;
import finance.ideal.util.ChainCodeUtils;
import finance.ideal.util.JdbcUtils;
import finance.ideal.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChainCodeModelImpl implements IChainCodeModel {
    @Override
    public List<ChainCodeModelDomain> SendChainCodeModelData() {
        ArrayList<ChainCodeModelDomain> list= new ArrayList<ChainCodeModelDomain>();
        ChainCodeUtils c = new ChainCodeUtils();//链码的工具
        Utils utils = new Utils();
        String params ="{\n" +
                "  \"userName\"        : \"111\",\n" +
                "  \"args\"            : [\"10\",\"\"],\n" +
                "  \"channelName\"     : \"idealchannel\",\n" +
                "  \"chainCodeName\"   : \"EstimateChainCode\",\n" +
                "  \"chainCodeVersion\": \"1.0\",\n" +
                "  \"function\"        : \"queryestimatelistforpage\",\n" +
                "  \"peerWithOrg\"     :\"peerOrg1\"\n" +
                "}\n";
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
                    ChainCodeModelDomain chainCodeModel = new ChainCodeModelDomain();//这个是链码对象
                    chainCodeModel.setRecordId((String)data.get("recordId"));
                    chainCodeModel.setBusinessNumber((String)data.get("businessNumber"));
                    chainCodeModel.setBusinessTypeId((String)data.get("businessTypeId"));
                    long l = Long.parseLong((String)data.get("estimateDate"));
                    chainCodeModel.setEstimateDate(utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                    chainCodeModel.setEstimateModelId((String)data.get("estimateModelId"));
                    System.out.println((String)data.get("estimateModelType"));
                    chainCodeModel.setEstimateModelType(utils.turnBusinessType((String)data.get("estimateModelType")));
                    chainCodeModel.setEstimateModelVersion((String)data.get("estimateModelVersion"));
                    chainCodeModel.setHashData((String)data.get("hashData"));
                    chainCodeModel.setRemark((String)data.get("remark"));
                    chainCodeModel.setTxId((String)data.get("txId"));
                    list.add(chainCodeModel);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return list;
    }

    @Override
    public ChainCodeModelDomain SendChainCodeModelDataDetail(String recordId) {
        List<ChainCodeModelDomain> list = this.SendChainCodeModelData();
        for (int i = 0; i < list.size(); i++) {
            ChainCodeModelDomain chainCodeModelDomain = list.get(i);
            if (recordId.equals(chainCodeModelDomain.getRecordId())){
                return chainCodeModelDomain;
            }
        }
        return null;
    }




    public List<ChainCodeModelDomain> SendChainCodeModelDataByBusinessnumber(String BusinessNumber) {
        ArrayList<ChainCodeModelDomain> list= new ArrayList<ChainCodeModelDomain>();
        ChainCodeUtils c = new ChainCodeUtils();//链码的工具
        Utils utils = new Utils();
        String params ="{\n" +
                "  \"userName\"        : \"111\",\n" +
                "  \"args\"            : [\""+BusinessNumber+"\",\"10\",\"\"], \n"+
                "  \"channelName\"     : \"idealchannel\",\n" +
                "  \"chainCodeName\"   : \"EstimateChainCode\",\n" +
                "  \"chainCodeVersion\": \"1.0\",\n" +
                "  \"function\"        : \"queryPageByBn\",\n" +
                "  \"peerWithOrg\"     :\"peerOrg1\"\n" +
                "}\n";
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
                    ChainCodeModelDomain chainCodeModel = new ChainCodeModelDomain();//这个是链码对象
                    chainCodeModel.setRecordId((String)data.get("recordId"));
                    chainCodeModel.setBusinessNumber((String)data.get("businessNumber"));
                    chainCodeModel.setBusinessTypeId((String)data.get("businessTypeId"));
                    long l = Long.parseLong((String)data.get("estimateDate"));
                    chainCodeModel.setEstimateDate(utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                    chainCodeModel.setEstimateModelId((String)data.get("estimateModelId"));
                    chainCodeModel.setEstimateModelType(utils.turnBusinessType((String)data.get("estimateModelType")));
                    chainCodeModel.setEstimateModelVersion((String)data.get("estimateModelVersion"));
                    chainCodeModel.setHashData((String)data.get("hashData"));
                    chainCodeModel.setRemark((String)data.get("remark"));
                    chainCodeModel.setTxId((String)data.get("txId"));
                    list.add(chainCodeModel);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return list;
    }
}
