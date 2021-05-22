package finance.ideal.domain;

public class P2PCompany {
    private String id;
    private String uname;//平台名称
    private String time;//平台上线时间
    private String place;//区域
    private String term;//投资期限
    private String average;//平均收益率
    private String score;//评分
    private String money;//注册资金
    private String equity;//股权上市
    private String bank;//银行存管
    private String finance;//融资记录
    private String regulatory;//监管协会
    private String icp;//ICP号
    private String bidding;//自动投标

    @Override
    public String toString() {
        return "P2PCompany{" +
                "id='" + id + '\'' +
                ", uname='" + uname + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", term='" + term + '\'' +
                ", average='" + average + '\'' +
                ", score='" + score + '\'' +
                ", money='" + money + '\'' +
                ", equity='" + equity + '\'' +
                ", bank='" + bank + '\'' +
                ", finance='" + finance + '\'' +
                ", regulatory='" + regulatory + '\'' +
                ", icp='" + icp + '\'' +
                ", bidding='" + bidding + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getRegulatory() {
        return regulatory;
    }

    public void setRegulatory(String regulatory) {
        this.regulatory = regulatory;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getBidding() {
        return bidding;
    }

    public void setBidding(String bidding) {
        this.bidding = bidding;
    }
}
