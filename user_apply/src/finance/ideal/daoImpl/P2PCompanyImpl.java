package finance.ideal.daoImpl;

import finance.ideal.dao.IP2PCompany;
import finance.ideal.domain.P2PCompany;
import finance.ideal.util.JdbcUtils;
import finance.ideal.util.Utils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2PCompanyImpl implements IP2PCompany {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    private static final CallableStatement cs = null;

    //展示所有P2P所有公司的信息
    @Override
    public List<P2PCompany> SendP2PCompanyData() {
        ArrayList<P2PCompany> list= new ArrayList<>();
        String sql="select * from p2pcompany ORDER BY id DESC limit 10";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                P2PCompany p2PCompany = new P2PCompany();
                p2PCompany.setId(res.getString("id"));
                p2PCompany.setUname(res.getString("uname"));
                p2PCompany.setTime(res.getString("time"));
                p2PCompany.setPlace(res.getString("place"));
                p2PCompany.setTerm(res.getString("term"));
                p2PCompany.setAverage(res.getString("average"));
                p2PCompany.setScore(res.getString("score"));
                p2PCompany.setMoney(res.getString("money"));
                p2PCompany.setEquity(res.getString("equity"));
                list.add(p2PCompany);
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
        return  list;
    }
    /*
    * 发送p2p选择的数据
    * companyname 所查询的公司名称
    */

    @Override
    public List<P2PCompany> SendP2PCompanyDataSelect(String companyname) {
        ArrayList<P2PCompany> list= new ArrayList<>();
        String sql="select * from p2pcompany WHERE uname LIKE ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, "%" + companyname + "%");
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                SaveP2PCompanyDataSelect(companyname);
                list.add(null);//发送前端留着判断使用
                conn.close();
                return list;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    P2PCompany p2PCompany = new P2PCompany();
                    p2PCompany.setId(res.getString("id"));
                    p2PCompany.setUname(res.getString("uname"));
                    p2PCompany.setTime(res.getString("time"));
                    p2PCompany.setPlace(res.getString("place"));
                    p2PCompany.setTerm(res.getString("term"));
                    p2PCompany.setAverage(res.getString("average"));
                    p2PCompany.setScore(res.getString("score"));
                    p2PCompany.setMoney(res.getString("money"));
                    p2PCompany.setEquity(res.getString("equity"));
                    list.add(p2PCompany);
                }
            }
            } catch(SQLException e){
                e.printStackTrace();
            }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    /*
    * 保存查询未知公司的名称
    */
    @Override
    public List<Object> SaveP2PCompanyDataSelect(String companyname){
        String sql="insert INTO p2pcompanyselect (companyname,time) values (?,?)";

        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,companyname);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String day = df.format(date);
            pStmt.setString(2,day);
            pStmt.executeUpdate();
            conn.close();
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

        return null;
    }


    /**
     * 发送详情数据
     * @param companyname
     * @return
     */
    @Override
    public P2PCompany SendP2PCompanyDataView(String companyname) {
        P2PCompany p2PCompany = new P2PCompany();
        String sql="select * from p2pcompany WHERE uname = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  companyname);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return p2PCompany;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    p2PCompany.setId(res.getString("id"));
                    p2PCompany.setUname(res.getString("uname"));
                    p2PCompany.setTime(res.getString("time"));
                    p2PCompany.setPlace(res.getString("place"));
                    p2PCompany.setTerm(res.getString("term"));
                    p2PCompany.setAverage(res.getString("average"));
                    p2PCompany.setScore(res.getString("score"));
                    p2PCompany.setMoney(res.getString("money"));
                    p2PCompany.setEquity(res.getString("equity"));
                    p2PCompany.setBank(res.getString("bank"));
                    p2PCompany.setFinance(res.getString("finance"));
                    p2PCompany.setRegulatory(res.getString("regulatory"));
                    p2PCompany.setIcp("icp");
                    p2PCompany.setBidding("bidding");
                    return p2PCompany;
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p2PCompany;
    }

}
