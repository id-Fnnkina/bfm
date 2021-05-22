package finance.ideal.domain;

/**
 * 业务信息
 */
public class BusinessList {
    private String businessId;
    private String Id;
    private String businessLeader;
    private String evModel;
    private String businessTime;
    private String businessDataUse;
    private String businessDataSuc;
    private String businessSendTime;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBusinessLeader() {
        return businessLeader;
    }

    public void setBusinessLeader(String businessLeader) {
        this.businessLeader = businessLeader;
    }

    public String getEvModel() {
        return evModel;
    }

    public void setEvModel(String evModel) {
        this.evModel = evModel;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getBusinessDataUse() {
        return businessDataUse;
    }

    public void setBusinessDataUse(String businessDataUse) {
        this.businessDataUse = businessDataUse;
    }

    public String getBusinessDataSuc() {
        return businessDataSuc;
    }

    public void setBusinessDataSuc(String businessDataSuc) {
        this.businessDataSuc = businessDataSuc;
    }

    public String getBusinessSendTime() {
        return businessSendTime;
    }

    public void setBusinessSendTime(String businessSendTime) {
        this.businessSendTime = businessSendTime;
    }

    @Override
    public String toString() {
        return "businessList{" +
                "businessId='" + businessId + '\'' +
                ", Id='" + Id + '\'' +
                ", businessLeader='" + businessLeader + '\'' +
                ", evModel='" + evModel + '\'' +
                ", businessTime='" + businessTime + '\'' +
                ", businessDataUse='" + businessDataUse + '\'' +
                ", businessDataSuc='" + businessDataSuc + '\'' +
                ", businessSendTime='" + businessSendTime + '\'' +
                '}';
    }
}
