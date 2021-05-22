package finance.ideal.domain;

/**
 * 链码的信息
 */
public class ChainCodeDomain {
    private String bankCard;
    private String businessNumber;
    private String businessTypeId;
    private String hashData;
    private String idNo;
    private String mobile;
    private String realName;
    private String recordId;
    private String remark;
    private String source;
    private String txId;
    private String verifyDate;
    private String companyName;
    private String taskType ;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ChainCode{" +
                "bankCard='" + bankCard + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", hashData='" + hashData + '\'' +
                ", idNo='" + idNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", recordId='" + recordId + '\'' +
                ", remark='" + remark + '\'' +
                ", source='" + source + '\'' +
                ", txId='" + txId + '\'' +
                ", verifyDate='" + verifyDate + '\'' +
                '}';
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getHashData() {
        return hashData;
    }

    public void setHashData(String hashData) {
        this.hashData = hashData;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }
}
