package finance.ideal.dao;

import finance.ideal.domain.*;

import java.util.List;

public interface IWorkBase {
    List<workPlace> SendWorkBaseData(int pageIndex,int pageSize);
    List<Log> SendOperateData(int pageIndex,int pageSize);
    List<State> SendStateData();
    Applicant SendWorkBaseListData(String  ordernum);
    State SendLogStateDetailData(String id);
    Log SendLogOperateDetailData(String id);
    void SendWorkBaseListWriteData(String path,String startTime,String endTime);

}
