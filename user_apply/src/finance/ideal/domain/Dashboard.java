package finance.ideal.domain;

/**
 * 日志的信息
 */
public class Dashboard {
    private String id; //序列号
    private String company;//使用成员的名称
    private int companyCount;//使用成员统计结果
    private String model;//模型类型
    private int modelCount;// 模型统计结果
    private String times;//时间
    private String timeModel;//某个时间的模型类型
    private int timeModelCount;// 模型统计结果

    public String getTimes() {
        return times;
    }

    public void setTimes(String time) {
        this.times = time;
    }

    public String getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(String timeModel) {
        this.timeModel = timeModel;
    }

    public int getTimeModelCount() {
        return timeModelCount;
    }

    public void setTimeModelCount(int timeModelCount) {
        this.timeModelCount = timeModelCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCompanyCount() {
        return companyCount;
    }

    public void setCompanyCount(int companyCount) {
        this.companyCount = companyCount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelCount() {
        return modelCount;
    }

    public void setModelCount(int modelCount) {
        this.modelCount = modelCount;
    }
}
