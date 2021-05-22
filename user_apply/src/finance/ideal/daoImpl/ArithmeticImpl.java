package finance.ideal.daoImpl;

import finance.ideal.dao.IArithmetic;
import finance.ideal.domain.Arithmetic;
import finance.ideal.domain.Model;
import finance.ideal.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticImpl implements IArithmetic {

    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    @Override
    public List<Arithmetic> SendArithmeticData() {
        ArrayList<Arithmetic> list= new ArrayList<Arithmetic>();
        String sql="select * from arithmeticutils";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                Arithmetic model = new Arithmetic();
                model.setArithmeticname(res.getString("arithmeticname"));//模型名称
                model.setImages(res.getString("images"));//logo地址
                model.setIntroduce(res.getString("introduce"));//模型介绍
                model.setTime(res.getString("time"));//配置完成时间
                list.add(model);
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
    public Arithmetic SendArithmeticSelectData(String arithmeticname) {
        String sql="select * from modelutils where companyname = ?";
        System.out.println(1111);
        Arithmetic model = new Arithmetic();
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  arithmeticname);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                conn.close();
                return model;

            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    model.setArithmeticname(res.getString("arithmeticname"));//模型名称
                    model.setImages(res.getString("images"));//logo地址
                    model.setIntroduce(res.getString("introduce"));//模型介绍
                    model.setTime(res.getString("time"));//配置完成时间
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
        return model;
    }
}
