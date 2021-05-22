package finance.ideal.daoImpl;

import finance.ideal.dao.IWorkBase;
import finance.ideal.domain.*;
import finance.ideal.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  WorkBaseImpl  implements IWorkBase {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;

    /**
     * 金融业务页面信息
     * @return
     */
    @Override
    public List<workPlace> SendWorkBaseData(int pageIndex,int pageSize) {
        ArrayList<workPlace> list= new ArrayList<>();
        String sql="select ordernum,time,servicetype,serviceleader,batchno,modeltype from applicant ORDER BY id DESC limit ?,?";
        Utils Utils = new Utils();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageIndex - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            res = pstmt.executeQuery();
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                workPlace place = new workPlace();
                place.setId(res.getString("ordernum"));
                long l = Long.parseLong(res.getString("time"));
                place.setBusinessTime(Utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                place.setBusinessType(Utils.turnBusinessType(res.getString("servicetype")));
                place.setBusinessLeader(Utils.SelectComapnynameByBatchno(res.getString("batchno"),res.getString("servicetype")));
                list.add(place);
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
        return list;
    }
    public List<workPlace> SendSelectWorkBaseData(int pageIndex,int pageSize,String[] time) {

        ArrayList<workPlace> list= new ArrayList<workPlace>();
        String sql="select ordernum,time,servicetype,serviceleader from applicant where time BETWEEN ? AND ? ORDER BY id DESC limit ?,?";
        Utils Utils = new Utils();
        String selecttime1 = String.valueOf(Utils.transferLongToMillstime(time[0])) ;
        String selecttime2 = String.valueOf(Utils.transferLongToMillstime(time[1])) ;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,selecttime1);
            pstmt.setString(2,selecttime2);
            pstmt.setInt(3, (pageIndex - 1) * pageSize);
            pstmt.setInt(4, pageSize);
            res = pstmt.executeQuery();
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                workPlace place = new workPlace();
                place.setId(res.getString("ordernum"));
                long l = Long.parseLong(res.getString("time"));
                place.setBusinessTime(Utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                place.setBusinessType(Utils.turnBusinessType(res.getString("servicetype")));
                place.setBusinessLeader(res.getString("serviceleader"));
                list.add(place);
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
        return list;
    }

    /**
     * 金融业务详情数据
     * @param ordernum
     * @return
     */
    @Override
    public Applicant SendWorkBaseListData(String ordernum){
        Applicant applicant = new Applicant();
        String sql="select * from applicant WHERE ordernum = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  ordernum);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return applicant;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                applicant.setId(res.getString("id"));
                applicant.setUname(res.getString("uname"));//姓名
                applicant.setUphone(res.getString("uphone"));//电话
                applicant.setIdnumber(res.getString("cardnum"));//身份证号
                applicant.setAddress(res.getString("city"));//住址
                applicant.setPeople(res.getString("people"));//联系人
                applicant.setDwname(res.getString("work"));//单位
                applicant.setDwphone(res.getString("worknum"));//单位电话
                applicant.setMoney(res.getString("money"));//工资
                applicant.setWork(res.getString("industry"));//行业
                applicant.setXueli(res.getString("education"));//学历
                applicant.setIsdog(res.getString("marriage"));//婚姻状况
                applicant.setYt(res.getString("yt"));//用途
                applicant.setLy(res.getString("ly"));//来源
                applicant.setOrdernum(res.getString("ordernum"));//业务流水号
                applicant.setServietype(res.getString("servicetype"));//业务类型
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
        return applicant;
    }

    /**
     * 金融业务写入文件
     * @return
     */
    @Override
    public void SendWorkBaseListWriteData(String path,String startTime,String endTime){
        ExcelOperaation excelOperaation = new ExcelOperaation();
        List<String[]> result = new ArrayList<String[]>();
        String[] title={"ID","用户姓名","手机电话","身份证号","业务办理时间","description","居住城市","联系人","公司","工资","行业","教育背景","婚姻状况","借款用途","还款来源",
                "业务流水号","业务类型","银行卡号","返回信息"};
        String sql=null;
        if (startTime.equals(null)||startTime.equals("")){
            sql ="select * from applicant";
        }else {
            sql ="select * from applicant where time BETWEEN "+startTime+" AND "+endTime ;
        }
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            System.out.println("执行业务报表导出");
            //如果查询的结果是空
            while (res.next()) {
                String[] values = {res.getString("id"),res.getString("uname"),res.getString("uphone"),
                        res.getString("cardnum"),res.getString("city"),res.getString("people"),
                        res.getString("work"),res.getString("worknum"),res.getString("money"),
                        res.getString("industry"),res.getString("marriage"),res.getString("yt"),
                        res.getString("ly"),res.getString("ordernum"),res.getString("servicetype")};
                result.add(values);
//                file=file+res.getString("id")+","+res.getString("uname")+","+res.getString("uphone")
//                        + "," +res.getString("cardnum")+","+res.getString("city")+","+res.getString("people")
//                        + "," +res.getString("work")+","+res.getString("worknum")+","+res.getString("money")
//                        + "," +res.getString("industry")+","+res.getString("marriage")+","+res.getString("yt")
//                        + "," +res.getString("ly")+","+res.getString("ordernum")+","+res.getString("servicetype")+"\n";
//                    System.out.println(111);
            }
            excelOperaation.writeExcel(path,result,"workbase",title);
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

    }


    /**
     * 统计业务的所有数据
     * @return
     */
    public int count() {
        int result = 0;
        String sql = "select * from applicant";
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                result++;
            }
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
        return result;
    }


    /**
     * 分页调用
     * @param page
     */
    public void RecordsBusinessList(PageUtil<workPlace> page) {
        int count=this.count();//获取所有消息的数量
        page.setTotalCount(count);
        //判断传入的页面是否合法
        if(page.getPageIndex()>page.getTotalPageCount()) {
            //确保页面不会超过总页数
            page.setPageIndex(page.getTotalPageCount());
        }
        List<workPlace> dataList=this.SendWorkBaseData(page.getPageIndex(), page.getPageSize());
        page.setDataList(dataList);
    }
    public void SelectRecordsList(PageUtil<workPlace> page,String[] selectTime) {
        int count=this.count();//获取所有消息的数量
        page.setTotalCount(count);
        //判断传入的页面是否合法
        if(page.getPageIndex()>page.getTotalPageCount()) {
            //确保页面不会超过总页数
            page.setPageIndex(page.getTotalPageCount());
        }
        List<workPlace> dataList=this.SendSelectWorkBaseData(page.getPageIndex(), page.getPageSize(),selectTime);
        page.setDataList(dataList);
    }



    /**
     * 系统日志操作
     * @return
     */
    @Override
    public List<Log> SendOperateData(int pageIndex,int pageSize) {
        ArrayList<Log> list= new ArrayList<Log>();
        String sql="select * from logtable ORDER BY TIME DESC limit ?,?            ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageIndex - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            res = pstmt.executeQuery();
            while (res.next()) {
                Log log = new Log();
                log.setId(res.getString("id"));
                log.setLeader(res.getString("username"));
                log.setServicetype(res.getString("operation"));
                log.setVerifydate(res.getString("time"));
                list.add(log);
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
        return list;
    }
    public int logcount() {
        int result = 0;
        String sql = "select * from logtable ";
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                result++;
            }
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
        System.out.println(result);
        return result;
    }
    public void RecordsLogList(PageUtil<Log> page) {
        int count=page.getTotalCount();//获取所有消息的数量
        page.setTotalCount(count);
        //判断传入的页面是否合法
        if(page.getPageIndex()>page.getTotalPageCount()) {
            //确保页面不会超过总页数
            page.setPageIndex(page.getTotalPageCount());
        }
        List<Log> dataList=this.SendOperateData(page.getPageIndex(), page.getPageSize());
        page.setDataList(dataList);
    }
    @Override
    public Log SendLogOperateDetailData(String id) {
        Log log = new Log();
        String sql="select * from operatestatus WHERE id = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  id);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return log;
            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    log.setId(res.getString("id"));
                    log.setLeader(res.getString("leader"));
                    log.setServicetype(res.getString("servicetype"));
                    log.setVerifydate(res.getString("verifydate"));
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
        return log;
    }
    /**
     * 系统日志安全日志
     * @return
     */
    @Override
    public List<State> SendStateData() {
        ArrayList<State> list= new ArrayList<State>();
        String sql="select * from operatestatus";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                State save = new State();
                save.setId(res.getString("id"));
                save.setLeader(res.getString("leader"));
                save.setServicetype(res.getString("servicetype"));
                save.setVerifydate(res.getString("verifydate"));
                save.setState(res.getString("state"));
                list.add(save);
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
        return list;
    }
    @Override
    public State SendLogStateDetailData(String id){
        State save = new State();
        String sql="select * from operatestatus WHERE id = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  id);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return save;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    save.setId(res.getString("id"));
                    save.setLeader(res.getString("leader"));
                    save.setServicetype(res.getString("servicetype"));
                    save.setVerifydate(res.getString("verifydate"));
                    save.setState(res.getString("state"));

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
        return save;
    }




}
