package finance.ideal.domain;

public class Member {

    private String id;
    private String companyname;//平台名称
    private String introduce;//平台介绍
    private String images;//图片地址
    private String membertype;//成员类型
    private String memberrole;//成员角色
    private String memberrolenum;//成员角色ID
    private String memberinterface;//需要提供的接口
    private String datastructure;//数据结构
    private String memberlabel;//碰撞返回的数据标签
    private String businesstype;//业务类型
    private String businessinterface;//业务调用接口
    private String modelSelect;//业务调用接口

    public String getModelSelect() {
        return modelSelect;
    }

    public void setModelSelect(String modelSelect) {
        this.modelSelect = modelSelect;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMemberrole() {
        return memberrole;
    }

    public void setMemberrole(String memberrole) {
        this.memberrole = memberrole;
    }

    public String getMemberrolenum() {
        return memberrolenum;
    }

    public void setMemberrolenum(String memberrolenum) {
        this.memberrolenum = memberrolenum;
    }

    public String getMemberinterface() {
        return memberinterface;
    }

    public void setMemberinterface(String memberinterface) {
        this.memberinterface = memberinterface;
    }

    public String getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(String datastructure) {
        this.datastructure = datastructure;
    }

    public String getMemberlabel() {
        return memberlabel;
    }

    public void setMemberlabel(String memberlabel) {
        this.memberlabel = memberlabel;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getBusinessinterface() {
        return businessinterface;
    }

    public void setBusinessinterface(String businessinterface) {
        this.businessinterface = businessinterface;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;


    @Override
    public String toString() {
        return "P2PMember{" +
                "id='" + id + '\'' +
                ", companyname='" + companyname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", images='" + images + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
