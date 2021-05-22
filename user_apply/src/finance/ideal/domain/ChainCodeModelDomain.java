package finance.ideal.domain;

/**
 * 链码的信息
 */
public class ChainCodeModelDomain {
    private String recordId;//记录id 唯一
    private String businessNumber;//业务流水号
    private String businessTypeId;//业务类型
    private String estimateDate;//上链时间
    private String estimateModelId;//模型id
    private String estimateModelType;//模型类型
    private String estimateModelVersion;//模型版本
    private String hashData;//hash值
    private String remark;//备注
    private String txId;//文件id

    @Override
    public String toString() {
        return "ChainCodeModelDomain{" +
                "recordId='" + recordId + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", estimateDate='" + estimateDate + '\'' +
                ", estimateModelId='" + estimateModelId + '\'' +
                ", estimateModelType='" + estimateModelType + '\'' +
                ", estimateModelVersion='" + estimateModelVersion + '\'' +
                ", hashData='" + hashData + '\'' +
                ", remark='" + remark + '\'' +
                ", txId='" + txId + '\'' +
                '}';
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
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

    public String getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(String estimateDate) {
        this.estimateDate = estimateDate;
    }

    public String getEstimateModelId() {
        return estimateModelId;
    }

    public void setEstimateModelId(String estimateModelId) {
        this.estimateModelId = estimateModelId;
    }

    public String getEstimateModelType() {
        return estimateModelType;
    }

    public void setEstimateModelType(String estimateModelType) {
        this.estimateModelType = estimateModelType;
    }

    public String getEstimateModelVersion() {
        return estimateModelVersion;
    }

    public void setEstimateModelVersion(String estimateModelVersion) {
        this.estimateModelVersion = estimateModelVersion;
    }

    public String getHashData() {
        return hashData;
    }

    public void setHashData(String hashData) {
        this.hashData = hashData;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
}
