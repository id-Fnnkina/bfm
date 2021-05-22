package finance.ideal.domain;

public class PrettyLoan {
    private String id;// 序列号
    private String batchno; // 流水号
    private int count; // 总数
    private int countSucceis; // 成功碰撞数量
    private String time; // 时间
    private String  ScGetCount;
    private String businessNameSc;
    private String collisionPercentage;

    public String getCollisionPercentage() {
        return collisionPercentage;
    }

    public void setCollisionPercentage(String collisionPercentage) {
        this.collisionPercentage = collisionPercentage;
    }

    public String getScGetCount() {
        return ScGetCount;
    }

    public void setScGetCount(String scGetCount) {
        ScGetCount = scGetCount;
    }

    public String getBusinessNameSc() {
        return businessNameSc;
    }

    public void setBusinessNameSc(String businessNameSc) {
        this.businessNameSc = businessNameSc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public int getCountSucceis() {
        return countSucceis;
    }

    public void setCountSucceis(int countSucceis) {
        this.countSucceis = countSucceis;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
