package finance.ideal.domain;

public class State {
    private String id;
    private String leader;
    private String servicetype;
    private String verifydate;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
