package finance.ideal.daoImpl;

import com.alibaba.fastjson.JSONObject;
import finance.ideal.dao.IPrettyLoan;
import finance.ideal.domain.PrettyLoan;
import finance.ideal.util.*;

import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrettyLoanImpl implements IPrettyLoan {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    private static final CallableStatement cs = null;
    public final  Map<String,String> businissNameSCMap = new HashMap();
    {
        businissNameSCMap.put("PersonalLoancount", "延期还款");
        businissNameSCMap.put("PersonalOperatorcount", "信用极好");
        businissNameSCMap.put("enterprisecount", "不存在经营风险");
        businissNameSCMap.put("NetLoancount", "运营中");
    }
    @Override
    public List<PrettyLoan> SendPrettyLoanData() {
        ArrayList<PrettyLoan> list= new ArrayList<PrettyLoan>();
        String sql="select batchno from applicant where batchno is not null and batchno <>''  group by batchno order by batchno ";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
//            while(res.next()){
//                totalCount = res.getInt(1);
//            }
//            ps = conn.prepareStatement(sql+" limit " + (pageNo-1)*pageSize+","+pageSize);
//            rs = ps.executeQuery();
            while (res.next()) {
                PrettyLoan prettyLoan = new PrettyLoan();
                prettyLoan.setId(res.getString("batchno"));
                list.add(prettyLoan);
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

    public List<PrettyLoan> FSendPrettyLoanData(int pageIndex,int pageSize,String tableName) {
        ArrayList<PrettyLoan> list= new ArrayList<PrettyLoan>();
        Utils utils = new Utils();

//        String sql="select batchno from applicant where batchno is not null and batchno <>''  group by batchno order by batchno limit ?,?";
        String sql="select * from "+tableName+" ORDER BY time DESC limit ?,?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageIndex - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            res = pstmt.executeQuery();
            String businissNameSc = businissNameSCMap.get(tableName);

            while (res.next()) {
                PrettyLoan prettyLoan = new PrettyLoan();
                String batchno = res.getString("batchno");
                int count = Integer.parseInt(res.getString("count"));
                int successCount = utils.successCount(batchno);
                prettyLoan.setId(batchno);// 流水号
                System.out.println(batchno);
                System.out.println(utils.collisionPercentage(batchno));
                double  p3  =  (float)successCount  /  count;
                NumberFormat nf  =  NumberFormat.getPercentInstance() ;
                nf.setMinimumFractionDigits( 2 );
                String str  =  nf.format(p3);
                prettyLoan.setCollisionPercentage(str);// 碰撞数据百分比

                prettyLoan.setCount(count);// 总数据数量
                prettyLoan.setCountSucceis(successCount);// 成功碰撞数据量
                prettyLoan.setTime(res.getString("time"));// 业务执行时间
                prettyLoan.setStatus(count==successCount?"任务已完成":"任务正在进行中");// 任务执行状态
                prettyLoan.setBusinessNameSc(businissNameSc);
                String ScGetCount = utils.collisionPercentage(batchno);
                prettyLoan.setScGetCount(ScGetCount);
                list.add(prettyLoan);
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

    public int count(String tablename) {
        int result = 0;
        String sql = "select batchno from "+ tablename;
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

    public void RecordsList(PageUtil<PrettyLoan> page,String tablename) {
        //判断传入的页面是否合法
        if(page.getPageIndex()>page.getTotalPageCount()) {
            //确保页面不会超过总页数
            page.setPageIndex(page.getTotalPageCount());
        }
        List<PrettyLoan> dataList=this.FSendPrettyLoanData(page.getPageIndex(), page.getPageSize(),tablename);
        page.setDataList(dataList);
    }

    /**
     * 导出报表的写出
     * @param batchno
     */
    @Override
    public void BusinessPrettyWrite(String batchno,String path,String methodid) {
        ExcelOperaation excelOperaation = new ExcelOperaation();
        List<String[]> result = new ArrayList<String[]>();
        if (methodid.equals("2")){
            String[] title={"ID","名称","结论","返回信息","联系人电话","企业注册账号","业务办理时间","description",
                    "业务流水号","业务类型","公司银行账户"}; // Excel文件信息头
            String sql="select * from applicant WHERE  batchno = ?";
            FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
            try {
                conn = JdbcUtils.getConnection();
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,  batchno);
                ResultSet res = pStmt.executeQuery();
//            String applicant="ID"+","+"用户姓名"+","+"手机电话"+","+"身份证号"+","+"业务办理时间"+","+"description"+","+"居住城市"
//                    +","+"联系人"+","+"公司"+","+"公司电话"+","+"工资"+","+"行业"+","+"教育背景"+","+"婚姻状况"+","+"借款用途"+","+"还款来源"
//                    +","+"业务流水号"+","+"业务类型"+","+"银行卡号"+","+"返回信息"+"\n";//存入读取得用信息
                while (res.next()) {
                    String id = res.getString("id");
                    String uname = res.getString("uname");
                    String uphone = res.getString("uphone");
                    String cardnum = res.getString("cardnum");
                    String time = res.getString("time");
                    String description = res.getString("description");
                    String ordernum = res.getString("ordernum");
                    String servicetype = res.getString("servicetype");
                    String bankcard = res.getString("bankcard");
                    String assessmentresults = res.getString("assessmentresults");
                    String dataresult=null;
                    Pattern pattern = Pattern.compile("正在.*");
                    Matcher matcher = pattern.matcher(assessmentresults); //  正则判断结果
                    boolean rs = matcher.find();
                    if (!rs){
                        Map resultInvoke = (Map) JSONObject.parse(assessmentresults);//查询后json
                        dataresult = (String) resultInvoke.get("prediction");

                    }else {
                        dataresult="正在评估";
                    }

                    String[] values={id,uname,dataresult,assessmentresults,uphone,cardnum,time,description,ordernum,servicetype,bankcard};
                    result.add(values);// 写入Excel的数据信息
//                applicant=applicant+id+","+uname+","+uphone+","+cardnum+","+ time+ "," + description+ ","+
//                        city+","+people+","+work+","+ worknum+ "," + money+ ","+
//                        industry+","+education+","+marriage+","+ yt+ "," + ly+ ","+
//                        ordernum+","+servicetype+","+bankcard+"," + assessmentresults+"\n";
                }
                excelOperaation.writeExcel(path,result,"applicant",title); //写入数据到Excel文件
//            fwr.appendMethodB(path,applicant);
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
        }else {
            String[] title={"ID","用户姓名","结论","返回信息","电话","有效证件号","业务办理时间","description","城市所在地","联系人","公司","公司电话","工资","行业","借款用途","还款来源",
                    "业务流水号","业务类型","银行卡号"};
            String sql="select * from applicant WHERE  batchno = ?";
            FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
            try {
                conn = JdbcUtils.getConnection();
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,  batchno);
                ResultSet res = pStmt.executeQuery();
//            String applicant="ID"+","+"用户姓名"+","+"手机电话"+","+"身份证号"+","+"业务办理时间"+","+"description"+","+"居住城市"
//                    +","+"联系人"+","+"公司"+","+"公司电话"+","+"工资"+","+"行业"+","+"教育背景"+","+"婚姻状况"+","+"借款用途"+","+"还款来源"
//                    +","+"业务流水号"+","+"业务类型"+","+"银行卡号"+","+"返回信息"+"\n";//存入读取得用信息
                while (res.next()) {

                    String id = res.getString("id");
                    String uname = res.getString("uname");
                    String uphone = res.getString("uphone");
                    String cardnum = res.getString("cardnum");
                    String time = res.getString("time");
                    String description = res.getString("description");
                    String city = res.getString("city");
                    String people = res.getString("people");
                    String work = res.getString("work");
                    String worknum = res.getString("worknum");
                    String money = res.getString("money");
                    String industry = res.getString("industry");
//                    String education = res.getString("education");
//                    String marriage = res.getString("marriage");
                    String yt = res.getString("yt");
                    String ly = res.getString("ly");
                    String ordernum = res.getString("ordernum");
                    String servicetype = res.getString("servicetype");
                    String bankcard = res.getString("bankcard");
                    String assessmentresults = res.getString("assessmentresults");
                    String dataresult=null;
                    Pattern pattern = Pattern.compile("正在.*");
                    Matcher matcher = pattern.matcher(assessmentresults);
                    boolean rs = matcher.find();
                    if (!rs){
                        Map resultInvoke = (Map) JSONObject.parse(assessmentresults);//查询后json
                        dataresult = (String) resultInvoke.get("prediction");

                    }else {
                        dataresult="正在评估";
                    }


                    String[] values={id,uname,dataresult,assessmentresults,uphone,cardnum,time,description,city,people,work,worknum,money,
                            industry,yt,ly,ordernum,servicetype,bankcard};
                    result.add(values);
//                applicant=applicant+id+","+uname+","+uphone+","+cardnum+","+ time+ "," + description+ ","+
//                        city+","+people+","+work+","+ worknum+ "," + money+ ","+
//                        industry+","+education+","+marriage+","+ yt+ "," + ly+ ","+
//                        ordernum+","+servicetype+","+bankcard+"," + assessmentresults+"\n";
                }
                excelOperaation.writeExcel(path,result,"applicant",title);
//            fwr.appendMethodB(path,applicant);
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


    }

    /**
     * 测试
     * @param batchno
     */
    @Override
    public void BusinessPrettyWrit(String batchno) {
        String sql="select * from applicant";
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            String applicant=null;//存入读取得用信息
            while (res.next()) {
                String id = res.getString("id");
                String uname = res.getString("uname");
                String uphone = res.getString("uphone");
                String cardnum = res.getString("cardnum");
                String time = res.getString("time");
                String description = res.getString("description");
                String city = res.getString("city");
                String people = res.getString("people");
                String work = res.getString("work");
                String worknum = res.getString("worknum");
                String money = res.getString("money");
                String industry = res.getString("industry");
                String education = res.getString("education");
                String marriage = res.getString("marriage");
                String yt = res.getString("yt");
                String ly = res.getString("ly");
                String ordernum = res.getString("ordernum");
                String servicetype = res.getString("servicetype");
                String bankcard = res.getString("bankcard");
                String serviceleader = res.getString("serviceleader");
                String batchno1 = res.getString("batchno");
                applicant=id+"\t"+uname+"\t"+uphone+"\t"+cardnum+"\t"+ time+ "\t" + description+ "\t"+
                        city+"\t"+people+"\t"+work+"\t"+ worknum+ "\t" + money+ "\t"+
                        industry+"\t"+education+"\t"+marriage+"\t"+ yt+ "\t" + ly+ "\t"+
                        ordernum+"\t"+servicetype+"\t"+bankcard+"\t"+ serviceleader+ "\t" + batchno1+ "\n";

            }
            fwr.appendMethodB("./new.txt",applicant);
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

}
