package finance.ideal.daoImpl;

import finance.ideal.dao.IApplicantDao;
import finance.ideal.domain.*;
import finance.ideal.util.Constants;
import finance.ideal.util.JdbcUtils;
import finance.ideal.util.MD5;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AIR on 2018/10/30.
 */
public class ApplicantDaoImpl implements IApplicantDao{

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static final CallableStatement cs = null;


    @Override
    public void add(Applicant applicant) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO applicant (uname,uphone,cardnum,time,description,city,people,work," +
                    "worknum,money,industry,education,marriage,yt,ly,ordernum,servicetype," +
                    "bankcard,serviceleader,batchno,assessmentresults,assessmentresultscode) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";        //插入sql语句

            ps = conn.prepareStatement(sql);

            /**
             * 调用实体StuInfo类,获取需要插入的各个字段的值
             * 注意参数占位的位置
             * 通过set方法设置参数的位置
             * 通过get方法取参数的值
             */
            ps.setString(1, applicant.getUname());
            ps.setString(2, applicant.getUphone());
            ps.setString(3, applicant.getIdnumber());
            ps.setString(4, String.valueOf(System.currentTimeMillis()));
            ps.setString(5, "description");

            ps.setString(6, applicant.getAddress());
            ps.setString(7, applicant.getPeople());
            ps.setString(8, applicant.getDwname());
            ps.setString(9, applicant.getDwphone());
            ps.setString(10, applicant.getMoney());
            ps.setString(11, applicant.getWork());
            ps.setString(12, "benke");
            ps.setString(13, "yihun");
            ps.setString(14, applicant.getYt());
            ps.setString(15, applicant.getLy());
            ps.setString(16, applicant.getOrdernum());
            ps.setString(17, applicant.getServietype());
            ps.setString(18, applicant.getBankcard());
            ps.setString(19, "普安信贷科技有限公司");
            ps.setString(20,applicant.getBatchno());
            ps.setString(21,"正在进行业务评估，请稍后查看评估结果");
            ps.setString(22,"1");

            ps.executeUpdate();            //执行sql语句

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //JdbcUtils.releaseConn();
                try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public SysConfig queryConfig(String servicetype,String level) {
        String sql="select * from sysconfig where servicetype = ? and modellevel = ?";
        SysConfig sc = new SysConfig();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, servicetype);
            ps.setString(2, level);
            ResultSet rs=ps.executeQuery();


            while (rs.next()){

                sc.setServicetype(rs.getString("servicetype"));
                sc.setAssessmentmodel(rs.getString("Assessmentmodel"));
                sc.setDatasource(rs.getString("datasource"));
                sc.setInparam(rs.getString("inparam"));
                sc.setOutparam(rs.getString("outparam"));
                sc.setVerifydate(rs.getString("verifydate"));
                sc.setUrl(rs.getString("url"));
                sc.setEnterprise_url(rs.getString("enterprise_url"));
                sc.setBank_url(rs.getString("bank_url"));
                sc.setOperator_url(rs.getString("Operator_url"));
                sc.setModellevel(rs.getString("modellevel"));

                System.out.println("==========================queryConfig==============================");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sc;
    }

    public ModelSourceStatus queryModelSourceStatus(String ordernum,String model,String source) {
        String sql="select * from modelsourcestatus where ordernum = ? and model = ? and source = ?";
        ModelSourceStatus mss = null;

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ordernum);
            ps.setString(2, model);
            ps.setString(3, source);
            ResultSet rs=ps.executeQuery();


            while (rs.next()){
                mss = new ModelSourceStatus();
                mss.setSourcelabel(rs.getString("sourcelabel"));

                System.out.println("==========================queryModelSourceStatus==============================");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //Thread.sleep(500);
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mss;
    }

    public int queryModelSourceCount(String ordernum,String model,String sourcestatus) {
        String sql="select count(*) from modelsourcestatus where ordernum = ? and model = ? and source = ?";
        int row=0;
        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ordernum);
            ps.setString(2, model);
            ps.setString(3, sourcestatus);

            System.out.println("queryModelSourceCount:sql:"+sql);
            System.out.println("ordernum:"+ordernum);
            System.out.println("model:"+model);
            System.out.println("source:"+sourcestatus);

            ResultSet rs=ps.executeQuery();
            rs.next();
            row = rs.getInt(1);
            System.out.println("====================queryModelSourceStatus==========行数:"+row);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return row;
    }

    public List<ModelSourceStatus> queryModelSource(String ordernum,String model,String sourcestatus) {
        String sql="select * from modelsourcestatus where ordernum = ? and model = ? and sourcestatus = ?";
        ModelSourceStatus mss = null;
        List<ModelSourceStatus> lists = null;

        try{
            lists = new ArrayList<>();
            conn = JdbcUtils.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, ordernum);
            ps.setString(2, model);
            ps.setString(3, sourcestatus);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                mss = new ModelSourceStatus();
                mss.setOrdernum(rs.getString("ordernum"));
                mss.setModel(rs.getString("model"));
                mss.setModellabel(rs.getString("modellabel"));
                mss.setSource(rs.getString("source"));
                mss.setSourcelabel(rs.getString("sourcelabel"));

                lists.add(mss);
                System.out.println("==========================queryModelSourceStatusList==============================");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lists;
    }


    public void addModelSourceStatus(ModelSourceStatus mss) {
        try {
            conn = JdbcUtils.getConnection();

            String sql = "INSERT INTO modelsourcestatus (ordernum,serviceleader,modellabel,model," +
                    "time,source,description,sourcelabel,modelstatus,sourcestatus) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";        //插入sql语句

            ps = conn.prepareStatement(sql);

            ps.setString(1, mss.getOrdernum());
            ps.setString(2, "普安信贷科技有限公司");
            ps.setString(3, mss.getModellabel());
            ps.setString(4, mss.getModel());
            ps.setString(5, String.valueOf(System.currentTimeMillis()));
            ps.setString(6, mss.getSource());
            ps.setString(7, "description");
            ps.setString(8, mss.getSourcelabel());
            ps.setString(9, "0");
            ps.setString(10, "0");

            ps.executeUpdate();            //执行sql语句

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void updateModelSourceStatus(String modellabel,String sourcelabel,String ordernum,
                                        String model,String source,String modelstatus,String sourcestatus,String flag) {
        try {
                conn = JdbcUtils.getConnection();
                String sqlstr ="";

                if ("source".equals(flag)){
                    sqlstr = "UPDATE modelsourcestatus SET sourcelabel=?,sourcestatus=? " +
                            "WHERE ordernum=? and model=? and source=?";
                }else{
                    sqlstr = "UPDATE modelsourcestatus SET modellabel=?,modelstatus=? " +
                            "WHERE ordernum=? and model=?";
                }

                ps = conn.prepareStatement(sqlstr);
                if("source".equals(flag)){
                    ps.setString(1, sourcelabel);
                    ps.setString(2, sourcestatus);
                    ps.setString(3, ordernum);
                    ps.setString(4, model);
                    ps.setString(5, source);
                }else{
                    ps.setString(1, modellabel);
                    ps.setString(2, modelstatus);
                    ps.setString(3, ordernum);
                    ps.setString(4, model);
                }

                ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateApplicant(String assessmentresults,String assessmentresultscode,String ordernum,String rs) {
        try {
            conn = JdbcUtils.getConnection();
            String sqlstr ="UPDATE applicant SET assessmentresults=?,assessmentresultscode=?,rs=? WHERE ordernum=?";

            ps = conn.prepareStatement(sqlstr);
            ps.setString(1, assessmentresults);
            ps.setString(2, "1");
            ps.setString(3, rs);
            ps.setString(4, ordernum);


            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Applicant queryApplicant(String ordernum) {
        String sql="select * from applicant where ordernum = ?";
        Applicant at = new Applicant();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ordernum);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                at.setUname(rs.getString("uname"));
                at.setUphone(rs.getString("uphone"));
                at.setIdnumber(rs.getString("cardnum"));
                at.setOrdernum(rs.getString("ordernum"));
                at.setServietype(rs.getString("servicetype"));
                at.setBankcard(rs.getString("bankcard"));

                System.out.println("==========================queryApplicant==============================");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return at;
    }

    public List<SingleLoan> querySingleLoan(String cardnum) {
        String sql="select * from singleloan";
        List<SingleLoan> list =new ArrayList<>();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //ps.setString(1, cardnum);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                SingleLoan sl = new SingleLoan();
                sl.setCardnum(rs.getString("cardnum"));
                sl.setLimit(rs.getString("limit"));
                sl.setTerm(rs.getString("term"));
                sl.setInterest_rate(rs.getString("interest_rate"));
                sl.setLevel(rs.getString("level"));
                sl.setType(rs.getString("type"));
                sl.setAge(rs.getString("age"));
                sl.setSex(rs.getString("sex"));
                sl.setPhoneok(rs.getString("phoneok"));
                sl.setHukouok(rs.getString("hukouok"));
                sl.setShipinok(rs.getString("shipinok"));
                sl.setIsfrist(rs.getString("isfrist"));
                sl.setXueliok(rs.getString("xueliok"));
                sl.setZhenxinok(rs.getString("zhenxinok"));
                sl.setTaobaook(rs.getString("taobaook"));
                sl.setHiscount(rs.getString("hiscount"));
                sl.setHislimit(rs.getString("hislimit"));
                sl.setSumlimit(rs.getString("sumlimit"));
                sl.setHishuanokcount(rs.getString("hishuanokcount"));
                sl.setHishuanerrcount(rs.getString("hishuanerrcount"));

                list.add(sl);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }


    public List<SingleOperator> querySingleOperator() {
        String sql="select * from singleoperator";
        List<SingleOperator> list =new ArrayList<>();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                SingleOperator so = new SingleOperator();
                so.setUphone(rs.getString("uphone"));
                so.setIsblack(rs.getString("isblack"));
                so.setIsarrears(rs.getString("isarrears"));
                so.setSetmeal(rs.getString("setmeal"));
                so.setMonthlevel(rs.getString("monthlevel"));
                so.setWorkgps(rs.getString("workgps"));
                so.setHomegps(rs.getString("homegps"));
                so.setPlaygps(rs.getString("playgps"));
                so.setBuyapp(rs.getString("buyapp"));
                so.setGameapp(rs.getString("gameapp"));
                so.setMovieapp(rs.getString("movieapp"));
                so.setFinanceapp(rs.getString("financeapp"));

                list.add(so);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public List<Enterprise> queryEnterprise() {
        String sql="select * from enterprise";
        List<Enterprise> list =new ArrayList<>();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Enterprise en = new Enterprise();
                en.setEnterprisename(rs.getString("enterprisename"));
                en.setInvestorshareschange(rs.getString("investorshareschange"));
                en.setEnterprisenamechange(rs.getString("enterprisenamechange"));
                en.setLegalpersonchange(rs.getString("legalpersonchange"));
                en.setRegtime(rs.getString("regtime"));
                en.setEnterprisereportyearcount(rs.getString("enterprisereportyearcount"));
                en.setSubenterprisecount(rs.getString("subenterprisecount"));
                en.setRecruitsaleproportion(rs.getString("recruitsaleproportion"));
                en.setDifferentplacesworker(rs.getString("Differentplacesworker"));
                en.setEnterprisesentimentcount(rs.getString("enterprisesentimentcount"));
                en.setEnterprisesanctioncount(rs.getString("enterprisesanctioncount"));
                en.setBreakfaithcount(rs.getString("Breakfaithcount"));
                en.setSentimentsum(rs.getString("sentimentsum"));

                list.add(en);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }


    public List<P2p> queryP2p() {
        String sql="select * from p2p";
        List<P2p> list =new ArrayList<>();

        try{
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                P2p p = new P2p();
                p.setP2pname(rs.getString("p2pname"));
                p.setGrade(rs.getString("grade"));
                p.setTime(rs.getString("time"));
                p.setRate(rs.getString("rate"));
                p.setBank(rs.getString("bank"));
                p.setFinacing(rs.getString("finacing"));
                p.setRegulation(rs.getString("regulation"));
                p.setAuto(rs.getString("auto"));
                p.setAssignment(rs.getString("assignment"));
                p.setICP(rs.getString("ICP"));
                p.setIPO(rs.getString("IPO"));
                p.setMonth(rs.getString("month"));
                p.setRegister(rs.getString("register"));
                p.setProtection(rs.getString("protection"));

                list.add(p);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.releaseConn();
            try {
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
