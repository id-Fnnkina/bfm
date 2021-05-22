package finance.ideal.dao;

import finance.ideal.domain.Arithmetic;
import finance.ideal.domain.Model;

import java.util.List;

public interface IArithmetic {
    List<Arithmetic> SendArithmeticData();//获取联盟成员集合用于联盟成员管理
    Arithmetic SendArithmeticSelectData(String arithmeticname);//获取一个联盟成员用于详情
}
