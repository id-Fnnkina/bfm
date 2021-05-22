package finance.ideal.domain;

import java.io.Serializable;

/**
 * Created by AIR on 2018/10/30.
 */
public class Applicant implements Serializable{
    private String id;
    private String uname;
    private String uphone;
    private String idnumber;
    private String address;
    private String people;
    private String dwname;
    private String dwphone;
    private String money;
    private String work;
    private String isdog;
    private String xueli;
    private String yt;
    private String ly;
    private String servietype;
    private String ordernum;
    private String bankcard;
    private String batchno;
    private String assessmentresults;
    private String assessmentresultscode;
    private String modeltype;

    public String getModeltype() {
        return modeltype;
    }

    public void setModeltype(String modeltype) {
        this.modeltype = modeltype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssessmentresultscode() {
        return assessmentresultscode;
    }

    public void setAssessmentresultscode(String assessmentresultscode) {
        this.assessmentresultscode = assessmentresultscode;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDwname() {
        return dwname;
    }

    public void setDwname(String dwname) {
        this.dwname = dwname;
    }

    public String getDwphone() {
        return dwphone;
    }

    public void setDwphone(String dwphone) {
        this.dwphone = dwphone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getIsdog() {
        return isdog;
    }

    public void setIsdog(String isdog) {
        this.isdog = isdog;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getServietype() {
        return servietype;
    }

    public void setServietype(String servietype) {
        this.servietype = servietype;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getAssessmentresults() {
        return assessmentresults;
    }

    public void setAssessmentresults(String assessmentresults) {
        this.assessmentresults = assessmentresults;
    }
}
