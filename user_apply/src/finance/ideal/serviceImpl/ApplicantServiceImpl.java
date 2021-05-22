package finance.ideal.serviceImpl;

import finance.ideal.dao.IApplicantDao;
import finance.ideal.daoImpl.ApplicantDaoImpl;
import finance.ideal.domain.*;
import finance.ideal.service.IApplicantService;

import java.sql.Connection;
import java.util.List;

/**
 * Created by AIR on 2018/10/30.
 */
public class ApplicantServiceImpl implements IApplicantService{
    private IApplicantDao dao = new ApplicantDaoImpl();

    @Override
    public void register(Applicant applicant) {
        dao.add(applicant);
    }

    public SysConfig initConfig(String servicetype,String level) {
        SysConfig sc = dao.queryConfig(servicetype,level);
        return sc;
    }

    public void addModelSourceStatus(ModelSourceStatus mss) {
        dao.addModelSourceStatus(mss);
    }

    public void updateModelSourceStatus(String modellabel,String sourcelabel,String ordernum,
                                        String model,String source,String modelstatus,String sourcestatus,String flag){
        dao.updateModelSourceStatus(modellabel,sourcelabel,ordernum,model,source,modelstatus,sourcestatus,flag);
    }

    public ModelSourceStatus queryModelSourceStatus(String ordernum,String model,String source){
        ModelSourceStatus mss = dao.queryModelSourceStatus(ordernum,model,source);
        return mss;
    }

    public int queryModelSourceCount(String ordernum,String model,String sourcestatus){
        int i = dao.queryModelSourceCount(ordernum,model,sourcestatus);
        return i;
    }

    public List<ModelSourceStatus> queryModelSource(String ordernum,String model,String sourcestatus){
        List<ModelSourceStatus> lists =  dao.queryModelSource(ordernum,model,sourcestatus);
        return lists;
    }

    public void updateApplicant(String assessmentresults,String assessmentresultscode,String ordernum,String rs){
        dao.updateApplicant(assessmentresults,assessmentresultscode,ordernum,rs);
    }

    public Applicant queryApplicant(String ordernum){
        Applicant a = dao.queryApplicant(ordernum);
        return a;
    }

    public List<SingleLoan> querySingleLoan(String cardnum){
        List<SingleLoan> list = dao.querySingleLoan(cardnum);
        return list;
    }

    public List<SingleOperator> querySingleOperator(){
        List<SingleOperator> list = dao.querySingleOperator();
        return list;
    }

    public List<Enterprise> queryEnterprise(){
        List<Enterprise> list = dao.queryEnterprise();
        return list;
    }

    public List<P2p> queryP2p(){
        List<P2p> list = dao.queryP2p();
        return list;
    }
}
