package finance.ideal.domain;

/**
 * Created by AIR on 2018/11/26.
 */
public class SysConfig {

    //业务类型
    private String servicetype;
    //模型类型
    private String Assessmentmodel;
    //节点，数据源
    private String datasource;
    //入参，数据拉取时候需要提交的参数
    private String inparam;
    //出参
    private String outparam;
    //日期
    private String verifydate;
    //数据拉取方url
    private String url;

    private String enterprise_url;

    private String bank_url;

    private String Operator_url;

    private String modellevel;

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getAssessmentmodel() {
        return Assessmentmodel;
    }

    public void setAssessmentmodel(String assessmentmodel) {
        Assessmentmodel = assessmentmodel;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getInparam() {
        return inparam;
    }

    public void setInparam(String inparam) {
        this.inparam = inparam;
    }

    public String getOutparam() {
        return outparam;
    }

    public void setOutparam(String outparam) {
        this.outparam = outparam;
    }

    public String getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(String verifydate) {
        this.verifydate = verifydate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEnterprise_url() {
        return enterprise_url;
    }

    public void setEnterprise_url(String enterprise_url) {
        this.enterprise_url = enterprise_url;
    }

    public String getBank_url() {
        return bank_url;
    }

    public void setBank_url(String bank_url) {
        this.bank_url = bank_url;
    }

    public String getOperator_url() {
        return Operator_url;
    }

    public void setOperator_url(String operator_url) {
        Operator_url = operator_url;
    }

    public String getModellevel() {
        return modellevel;
    }

    public void setModellevel(String modellevel) {
        this.modellevel = modellevel;
    }
}
