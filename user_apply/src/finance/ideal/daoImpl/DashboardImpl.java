package finance.ideal.daoImpl;

import finance.ideal.dao.IDashboard;
import finance.ideal.domain.Dashboard;
import finance.ideal.util.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardImpl implements IDashboard {

    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;

    /**
     * 查询某个使用方使用的情况
     * @return
     */
    @Override
    public Map<String, Integer> SendCompanyCount() {
        Map<String, Integer> dashBoards = new HashMap<>();//新建一个综合报表的集合
        String sql="SELECT source, count(1) AS counts FROM modelsourcestatus GROUP BY source";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
               dashBoards.put(res.getString("source"),res.getInt("counts"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dashBoards;
    }

    /**
     * 查询某个模型使用的统计结果
     * @return
     */
    @Override
    public Map<String, Integer> SendModelCount() {
        Map<String, Integer> dashBoards = new HashMap<>();//新建一个综合报表的集合
        String sql="SELECT servicetype, count(1) AS counts FROM applicant GROUP BY servicetype";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                dashBoards.put(res.getString("servicetype"),res.getInt("counts"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dashBoards;
    }


    /**
     * 查询某个模型使用的统计结果
     * @return
     */
    @Override
    public Map<String, Integer> SendMemberSCCount() {
        Map<String, Integer> dashBoards = new HashMap<>();//新建一个综合报表的集合
        String sql="SELECT servicetype, count(1) AS counts FROM applicant WHERE assessmentresultscode=1 GROUP BY servicetype";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                dashBoards.put(res.getString("servicetype"),res.getInt("counts"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dashBoards;
    }




    /**
     * 查询某一天某个模型使用统计结果
     * @return
     */
    @Override
    public Map<String,List> SendTimeAndModelCount() {
        Map<String,List> dashBoards=new HashMap<>();
        ArrayList<String > times = new ArrayList<>();
        ArrayList<String > single_loan = new ArrayList<>();
        ArrayList<String > single_operator = new ArrayList<>();
        ArrayList<String > enterprise_risk = new ArrayList<>();
        ArrayList<String > p2p_risk = new ArrayList<>();
        String sql="SELECT FROM_UNIXTIME ( t.time/1000,'%Y-%m-%d') AS triggerDay,\n" +
                "SUM( CASE WHEN t.servicetype = 'PersonalLoancount' THEN  1 ELSE 0 END)as single_loan,\n" +
                "SUM( CASE WHEN t.servicetype = 'PersonalOperatorcount' THEN  1 ELSE 0 END)as single_operator,\n" +
                "SUM( CASE WHEN t.servicetype = 'enterprisecount' THEN  1 ELSE 0 END)as enterprise_risk,\n" +
                "SUM( CASE WHEN t.servicetype = 'NetLoancount' THEN  1 ELSE 0 END)as p2p_risk\n" +
                "from applicant as t GROUP BY triggerDay  ORDER BY triggerDay DESC LIMIT 7";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                times.add(res.getString("triggerDay"));
                single_loan.add(res.getString("single_loan"));
                single_operator.add(res.getString("single_operator"));
                enterprise_risk.add(res.getString("enterprise_risk"));
                p2p_risk.add(res.getString("p2p_risk"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        dashBoards.put("times",times);
        dashBoards.put("single_loan",single_loan);
        dashBoards.put("single_operator",single_operator);
        dashBoards.put("enterprise_risk",enterprise_risk);
        dashBoards.put("p2p_risk",p2p_risk);
        return dashBoards;
    }
}
