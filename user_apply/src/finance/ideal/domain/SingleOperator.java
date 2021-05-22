package finance.ideal.domain;

import java.io.Serializable;

/**
 * Created by AIR on 2018/10/30.
 */
public class SingleOperator implements Serializable{
    private String uphone;
    private String isblack;
    private String isarrears;
    private String setmeal;
    private String monthlevel;
    private String workgps;
    private String homegps;
    private String playgps;
    private String buyapp;
    private String gameapp;
    private String movieapp;
    private String financeapp;

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getIsblack() {
        return isblack;
    }

    public void setIsblack(String isblack) {
        this.isblack = isblack;
    }

    public String getIsarrears() {
        return isarrears;
    }

    public void setIsarrears(String isarrears) {
        this.isarrears = isarrears;
    }

    public String getSetmeal() {
        return setmeal;
    }

    public void setSetmeal(String setmeal) {
        this.setmeal = setmeal;
    }

    public String getMonthlevel() {
        return monthlevel;
    }

    public void setMonthlevel(String monthlevel) {
        this.monthlevel = monthlevel;
    }

    public String getWorkgps() {
        return workgps;
    }

    public void setWorkgps(String workgps) {
        this.workgps = workgps;
    }

    public String getHomegps() {
        return homegps;
    }

    public void setHomegps(String homegps) {
        this.homegps = homegps;
    }

    public String getPlaygps() {
        return playgps;
    }

    public void setPlaygps(String playgps) {
        this.playgps = playgps;
    }

    public String getBuyapp() {
        return buyapp;
    }

    public void setBuyapp(String buyapp) {
        this.buyapp = buyapp;
    }

    public String getGameapp() {
        return gameapp;
    }

    public void setGameapp(String gameapp) {
        this.gameapp = gameapp;
    }

    public String getMovieapp() {
        return movieapp;
    }

    public void setMovieapp(String movieapp) {
        this.movieapp = movieapp;
    }

    public String getFinanceapp() {
        return financeapp;
    }

    public void setFinanceapp(String financeapp) {
        this.financeapp = financeapp;
    }
}
