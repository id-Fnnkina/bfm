package finance.ideal.dao;

import finance.ideal.domain.Member;

import java.util.List;

public interface IMember {
    List<Member> SendP2PMemberData();//获取联盟成员集合用于联盟成员管理
    Member SendP2PMemberSelectData(String companyname);//获取一个联盟成员用于详情
    List<String> SendP2PMemberNameData();//获取联盟成员的名称
    List<String> SendP2PModelNameData();//获取评估模型的名称
    void SendChaincodeMemberData(Member member);
}
