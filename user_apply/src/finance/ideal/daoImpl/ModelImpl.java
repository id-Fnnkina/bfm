package finance.ideal.daoImpl;

import finance.ideal.dao.IModel;
import finance.ideal.domain.Member;
import finance.ideal.domain.Model;
import finance.ideal.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements IModel {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    @Override
    public List<Model> SendP2PModelData() {
        ArrayList<Model> list= new ArrayList<Model>();
        String sql="select * from modelutils";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                Model model = new Model();
                model.setModelname(res.getString("modelname"));//模型名称
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
        return  list;
    }

    @Override
    public Model SendP2PModelSelectData(String modelname) {
        String sql="select * from modelutils where modelname = ?";
        Model model = new Model();
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  modelname);
            ResultSet res = pStmt.executeQuery();
            //如果查询的结果是空
            if (!res.next()) {
                conn.close();
                return model;
            }else {
                res = pStmt.executeQuery();
                while (res.next()) {
                    model.setModelname(res.getString("modelname"));//模型名称
                    model.setImages(res.getString("images"));//logo地址
                    model.setIntroduce(res.getString("introduce"));//模型介绍
                    model.setTime(res.getString("time"));//配置完成时间
                    model.setModeldata(res.getString("modeldata"));
                    model.setModelmanufacturer(res.getString("modelmanufacturer"));//模型制造者
                    model.setDatainput(res.getString("datainput"));//输入的数据
                    model.setModelinterface(res.getString("modelinterface"));//需要提供的接口
                    model.setDataselect(res.getString("dataselect"));//数据源选择
                    model.setModelintroducedetail(res.getString("modelintroducedetail"));//模型详细介
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
