package finance.ideal.domain;

public class workPlace {
    private String Id;
    private String businessTime;
    private String businessType;
    private String businessLeader;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessLeader() {
        return businessLeader;
    }

    public void setBusinessLeader(String businessLeader) {
        this.businessLeader = businessLeader;
    }

    @Override
    public String toString() {
        return "workPlace{" +
                "Id='" + Id + '\'' +
                ", businessTime='" + businessTime + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessLeader='" + businessLeader + '\'' +
                '}';
    }
}
