package finance.ideal.domain;

/**
 * 日志的信息
 */
public class Log{
    private String id;
    private String leader;
    private String servicetype;
    private String verifydate;

    @Override
    public String toString() {
        return "Operate{" +
                "id='" + id + '\'' +
                ", leader='" + leader + '\'' +
                ", servicetype='" + servicetype + '\'' +
                ", verifydate='" + verifydate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(String verifydate) {
        this.verifydate = verifydate;
    }
}
