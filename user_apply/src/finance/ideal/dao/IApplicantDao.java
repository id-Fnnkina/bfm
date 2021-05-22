package finance.ideal.dao;

import finance.ideal.domain.*;

import java.sql.Connection;
import java.util.List;

/**
 * Created by AIR on 2018/10/30.
 */
public interface IApplicantDao {

    void add(Applicant applicant);

    SysConfig queryConfig(String servicetype, String level);

    void addModelSourceStatus(ModelSourceStatus mss);

    void updateModelSourceStatus(String modellabel,String sourcelabel,String ordernum,
                                 String model,String source,String modelstatus,String sourcestatus,String flag);

    ModelSourceStatus queryModelSourceStatus(String ordernum,String model,String source);

    int queryModelSourceCount(String ordernum,String model,String sourcestatus);

    List<ModelSourceStatus> queryModelSource(String ordernum,String model,String sourcestatus);

    void updateApplicant(String assessmentresults,String assessmentresultscode,String ordernum,String rs);

    Applicant queryApplicant(String ordernum);

    List<SingleLoan> querySingleLoan(String cardnum);

    List<SingleOperator> querySingleOperator();

    List<Enterprise> queryEnterprise();

    List<P2p> queryP2p();
}
