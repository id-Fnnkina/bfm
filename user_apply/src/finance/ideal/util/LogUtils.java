package finance.ideal.util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    private static final CallableStatement cs = null;
    public void SaveLogData(String userName, String operation){
        String sql="insert INTO logtable (username,time,operation) values (?,?,?)";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,userName);
            java.util.Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String day = df.format(date);
            pStmt.setString(2,day);
            pStmt.setString(3,operation);
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
