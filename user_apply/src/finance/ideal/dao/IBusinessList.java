package finance.ideal.dao;

import finance.ideal.domain.BusinessList;

import java.util.List;

public interface IBusinessList {
    public List<BusinessList> SendData(String str_id);// 发送金融管理业务数据
    BusinessList SendBusinessListData(String  ordernum);//发送金融详情数据
}
