package finance.ideal.util;

import com.alibaba.fastjson.JSONObject;
import finance.ideal.daoImpl.WorkBaseImpl;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 转换工具
 **/

public class Utils {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;

    /**
     * 时间转换
     * @param dateFormat
     * @param millSec
     * @return
     */
    public String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 将时间转换成毫秒数
     * @param time
     * @return
     */
    public Long transferLongToMillstime(String time) {
        Date slectTime=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            slectTime = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return slectTime.getTime();
    }

    /**
     * 查找字典转换业务名称
     * @param englishType
     * @return
     */
    public String turnBusinessType(String englishType) {
        String sql = "select * from utils";
        String type = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                type = res.getString(englishType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return type;
    }

    /**
     * 转换数据源名称
     * @param englishType
     * @return
     */
    public String turnSourceType(String englishType) {
        String sql = "select companyname from memberutils WHERE modelselect= "+"\'"+englishType+"\'";
        System.out.println(sql);
        String type = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                type = res.getString("companyname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return type;
    }

    /**
     *
     * 转换用户的名称
     * @param englishType
     * @return
     */
    public String turnMember(String englishType) {
        String sql = "select * from tableutils";
        String member = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                member = res.getString(englishType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
        return member;
    }

    /**
     * 往批量导入的表中插入数据
     * @param result
     * @param batchno
     * @param time
     * @param username
     */
    public void insertCount(int result,String batchno,String time,String username,String tableName){
        WorkBaseImpl workBase = new WorkBaseImpl();
        String sql="insert INTO "+tableName+" (count,batchno,time,company,username) values (?,?,?,?,?) ";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,result);
            pStmt.setString(2,batchno);
            pStmt.setString(3,time);
            pStmt.setString(4,this.SelectUserName(username));
            pStmt.setString(5,username);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConn();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 成功导入数据量
     * @param batchno
     * @return
     */
    public int successCount(String batchno){
        String sql="select * from applicant where batchno=?";
        int result=0;
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,batchno);
            res = pStmt.executeQuery();
            while (res.next()) {
                if (res.getString("assessmentresultscode").equals("1")){
                    result++;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(batchno+":"+result);
        return result;
    }

    public int businessNameScCount(String batchno,String businessName){
        String sql="select * from applicant where batchno=?";
        int result=0;
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,batchno);
            res = pStmt.executeQuery();
            while (res.next()) {
                String assessmentresults = res.getString("assessmentresults");
                String dataresult=null;
                Pattern pattern = Pattern.compile("正在.*");
                Matcher matcher = pattern.matcher(assessmentresults); //  正则判断结果
                boolean rs = matcher.find();
                if (!rs){
//                    System.out.println(assessmentresults);
//                    Map resultInvoke = (Map) JSONObject.parse(assessmentresults);//查询后json
//                    dataresult = (String) resultInvoke.get("prediction");
//                    System.out.println(dataresult);
//                    if (dataresult.equals(businessName)){
//                        result++;
//                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(batchno+":"+result);
        return result;
    }

    /**
     * 查询用户所在公司的信息
     * @param uname
     * @return
     */
    public String SelectUserName(String uname) {
        String companyname=null;
        String sql="select companyname from adminusertable WHERE uname = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  uname);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return companyname;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    companyname=res.getString("companyname");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return companyname;
    }

    /**
     * 业务通过标记查询公司名称
     * @param batchno
     * @return
     */
    public String SelectComapnynameByBatchno(String batchno,String modelTable) {
        String companyname=null;
        String sql="select company from "+modelTable+" WHERE batchno = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  batchno);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    companyname=res.getString("company");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return companyname;
    }

    /**
     * 业务通过标记查询公司名称
     * @param businessNumber
     * @return
     */
    public String SelectComapnynameByBusinessNumber(String modelTableName,String businessNumber) throws SQLException {
        String companyname=null;
        System.out.println(modelTableName);
        String sql="select company from "+modelTableName+" WHERE batchno in " +
                "(SELECT batchno FROM applicant WHERE ordernum = ?)";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  businessNumber);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                conn.close();
                return companyname;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    companyname=res.getString("company");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return companyname;
    }

    /**
     * 区块链查询业务类型
     * @param Businessnumber
     * @return
     */
    public String SelectServicetypeByBusinessnumber(String Businessnumber) {
        String servicetype=null;
        String sql="select servicetype from  applicant WHERE ordernum = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  Businessnumber);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    servicetype = res.getString("servicetype");
                    servicetype = this.turnBusinessType(servicetype);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return servicetype;
    }

    /**
     * 计算碰撞成功百分比
     * @param batchno
     * @return
     */
    public String collisionPercentage(String batchno) {
        String pass_rate=null;//百分比结果
        String sql="select A.batchno,  CONCAT(FORMAT((sum(if(A.i_s = 1, A.num, 0))) / sum(A.num), 4) * 100,\"%\") as pass_rate\n" +
                "FROM (select batchno, INTERVAL(rs, 1) as i_s, count(1) as num from applicant where batchno= ? and assessmentresultscode = 1\n" +
                "group by batchno, i_s) A GROUP BY A.batchno\n";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  batchno);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    pass_rate = res.getString("pass_rate");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return pass_rate;
    }






}
