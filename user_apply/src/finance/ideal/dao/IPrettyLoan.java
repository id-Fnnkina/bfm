package finance.ideal.dao;

import finance.ideal.domain.PrettyLoan;

import java.util.List;

public interface IPrettyLoan {
    List<PrettyLoan> SendPrettyLoanData();
    void BusinessPrettyWrite(String batchno,String path,String methodid);
    void BusinessPrettyWrit(String batchno);
}
