package finance.ideal.dao;

import finance.ideal.domain.Member;
import finance.ideal.domain.Model;

import java.util.List;

public interface IModel {
    List<Model> SendP2PModelData();//获取联盟成员集合用于联盟成员管理
    Model SendP2PModelSelectData(String modelname);//获取一个联盟成员用于详情
}
