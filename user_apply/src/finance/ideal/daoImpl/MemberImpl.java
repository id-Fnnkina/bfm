package finance.ideal.daoImpl;


import finance.ideal.dao.IMember;
import finance.ideal.domain.Member;
import finance.ideal.util.JdbcUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 成员管理界面
 * 发送页面成员管理的一些div的内容
 */
public class MemberImpl implements IMember {

    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    @Override
    public List<Member> SendP2PMemberData() {
        ArrayList<Member> list= new ArrayList<Member>();
        String sql="select * from memberutils";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                Member member = new Member();
                member.setCompanyname(res.getString("companyname"));//公司名称
                member.setImages(res.getString("images"));//图片地址
                member.setIntroduce(res.getString("introduce"));//功能介绍
                member.setTime(res.getString("time"));// 时间
                member.setMemberrolenum(res.getString("memberrolenum"));
                list.add(member);
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

    /**
     *  联盟成员详情
     * @param companyname
     * @return
     */
    @Override
    public Member SendP2PMemberSelectData(String companyname) {
        String sql="select * from memberutils where companyname = ?";
        System.out.println(1111);
        Member member = new Member();
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  companyname);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                return member;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                   member.setCompanyname(res.getString("companyname"));
                   System.out.println(member.getCompanyname());
                   member.setMembertype(res.getString("membertype"));
                   member.setMemberrole(res.getString("memberrole"));
                   member.setMemberrolenum(res.getString("memberrolenum"));
                   member.setMemberinterface(res.getString("memberinterface"));
                   member.setDatastructure(res.getString("datastructure"));
                   member.setMemberlabel(res.getString("memberlabel"));
                    member.setModelSelect(res.getString("modelselect"));
                   member.setBusinesstype(res.getString("businesstype"));
                   member.setBusinessinterface(res.getString("businessinterface"));
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
        return member;
    }


    //集合联盟成员名称
    @Override
    public List<String> SendP2PMemberNameData() {
        ArrayList<String> list= new ArrayList<String>();
        String sql="select companyname from memberutils";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("companyname"));
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

    //获取评估模型的名称集合
    @Override
    public List<String> SendP2PModelNameData() {
        ArrayList<String> list= new ArrayList<String>();
        String sql="select modelname from modelutils";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("modelname"));
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

    @Override
    public void SendChaincodeMemberData(Member member) {
        String sql="insert INTO memberadd (companyname,introduce,memberrole,memberlabel,businesstype,time) values (?,?,?,?,?,?)";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,member.getCompanyname());
            pStmt.setString(2,member.getIntroduce());
            pStmt.setString(3,member.getMemberrole());
            pStmt.setString(4,member.getMemberlabel());
            pStmt.setString(5,member.getBusinesstype());
            java.util.Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String day = df.format(date);
            pStmt.setString(6,day);
            pStmt.executeUpdate();
            conn.close();
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
}
