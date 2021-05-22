package finance.ideal.domain;

import java.io.Serializable;

/**
 * Created by AIR on 2018/10/30.
 */
public class Enterprise implements Serializable{
    private String enterprisename;
    private String investorshareschange;
    private String enterprisenamechange;
    private String legalpersonchange;
    private String regtime;
    private String enterprisereportyearcount;
    private String subenterprisecount;
    private String recruitsaleproportion;
    private String Differentplacesworker;
    private String enterprisesentimentcount;
    private String enterprisesanctioncount;
    private String Breakfaithcount;
    private String sentimentsum;

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getInvestorshareschange() {
        return investorshareschange;
    }

    public void setInvestorshareschange(String investorshareschange) {
        this.investorshareschange = investorshareschange;
    }

    public String getEnterprisenamechange() {
        return enterprisenamechange;
    }

    public void setEnterprisenamechange(String enterprisenamechange) {
        this.enterprisenamechange = enterprisenamechange;
    }

    public String getLegalpersonchange() {
        return legalpersonchange;
    }

    public void setLegalpersonchange(String legalpersonchange) {
        this.legalpersonchange = legalpersonchange;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getEnterprisereportyearcount() {
        return enterprisereportyearcount;
    }

    public void setEnterprisereportyearcount(String enterprisereportyearcount) {
        this.enterprisereportyearcount = enterprisereportyearcount;
    }

    public String getSubenterprisecount() {
        return subenterprisecount;
    }

    public void setSubenterprisecount(String subenterprisecount) {
        this.subenterprisecount = subenterprisecount;
    }

    public String getRecruitsaleproportion() {
        return recruitsaleproportion;
    }

    public void setRecruitsaleproportion(String recruitsaleproportion) {
        this.recruitsaleproportion = recruitsaleproportion;
    }

    public String getDifferentplacesworker() {
        return Differentplacesworker;
    }

    public void setDifferentplacesworker(String differentplacesworker) {
        Differentplacesworker = differentplacesworker;
    }

    public String getEnterprisesentimentcount() {
        return enterprisesentimentcount;
    }

    public void setEnterprisesentimentcount(String enterprisesentimentcount) {
        this.enterprisesentimentcount = enterprisesentimentcount;
    }

    public String getEnterprisesanctioncount() {
        return enterprisesanctioncount;
    }

    public void setEnterprisesanctioncount(String enterprisesanctioncount) {
        this.enterprisesanctioncount = enterprisesanctioncount;
    }

    public String getBreakfaithcount() {
        return Breakfaithcount;
    }

    public void setBreakfaithcount(String breakfaithcount) {
        Breakfaithcount = breakfaithcount;
    }

    public String getSentimentsum() {
        return sentimentsum;
    }

    public void setSentimentsum(String sentimentsum) {
        this.sentimentsum = sentimentsum;
    }
}
