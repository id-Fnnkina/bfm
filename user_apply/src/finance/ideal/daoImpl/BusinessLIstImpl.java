package finance.ideal.daoImpl;

import finance.ideal.dao.IBusinessList;
import finance.ideal.domain.BusinessList;
import finance.ideal.util.JdbcUtils;
import finance.ideal.util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessLIstImpl implements IBusinessList {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;

    /**
     * 发送业务数据
     * @param str_id
     * @return
     */
    @Override
    public List<BusinessList> SendData(String str_id) {
        ArrayList<BusinessList> list= new ArrayList<BusinessList>();
        String sql="select * from modelsourcestatus WHERE ordernum = ?";
        Utils utils = new Utils();
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  str_id );
            BusinessList blist = new BusinessList();
            ResultSet res = pStmt.executeQuery();
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                blist.setBusinessId(res.getString("ordernum"));
                blist.setId(res.getString("id"));
                blist.setBusinessLeader(res.getString("serviceleader"));
                blist.setEvModel(utils.turnBusinessType(res.getString("model")));
                long l = Long.parseLong(res.getString("time"));
                blist.setBusinessTime(utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                blist.setBusinessDataUse(utils.turnBusinessType(res.getString("source")));
                blist.setBusinessDataSuc(res.getString("sourcelabel"));
                blist.setBusinessSendTime(res.getString("description"));
                list.add(blist);
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
    public BusinessList SendBusinessListData(String str_id) {
        BusinessList blist = new BusinessList();
        String sql="select * from modelsourcestatus WHERE id = ?";
        Utils utils = new Utils();
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  str_id );
            ResultSet res = pStmt.executeQuery();
            while (res.next()) {
                blist.setId(res.getString("id"));
                blist.setBusinessId(res.getString("ordernum"));
                blist.setBusinessLeader(res.getString("serviceleader"));
                blist.setEvModel(utils.turnBusinessType(res.getString("model")));
                long l = Long.parseLong(res.getString("time"));
                blist.setBusinessTime(utils.transferLongToDate("yyyy-MM-dd HH:mm:ss",l));
                blist.setBusinessDataUse(utils.turnBusinessType(res.getString("source")));
                blist.setBusinessDataSuc(res.getString("sourcelabel"));
                blist.setBusinessSendTime(res.getString("description"));

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
        return blist;
    }
}
