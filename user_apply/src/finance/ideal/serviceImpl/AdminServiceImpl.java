package finance.ideal.serviceImpl;

import finance.ideal.dao.IApplicantDao;
import finance.ideal.daoImpl.ApplicantDaoImpl;
import finance.ideal.domain.Applicant;
import finance.ideal.domain.ModelSourceStatus;
import finance.ideal.domain.SysConfig;
import finance.ideal.service.IAdminService;
import finance.ideal.service.IApplicantService;
import finance.ideal.util.JdbcUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.List;

/**
 * Created by AIR on 2018/10/30.
 */
public class AdminServiceImpl implements IAdminService{
    private boolean ok=false;//状态变量
    private String username=null;
    private String password=null;
    private String name=null;
    private String pass=null;
    private static Connection conn = null;
    private static Statement sta = null;
    private static ResultSet res = null;
    private static final CallableStatement cs = null;


    public boolean check()throws Exception{
        Login(this.username,this.password);
        return this.ok;
    }
    @Override
    public String Login(String uname, String password) {
        String sql="select * from adminusertable WHERE uname = ?";
        try {
            conn = JdbcUtils.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,  uname);
            ResultSet res = pStmt.executeQuery();
            if (!res.next()) {
                this.ok=false;
                return "1";
            }else {
                password = DigestUtils.md5Hex(password);
                if (password.equals(res.getString("password"))){
                    this.ok=true;
                    return "0";
                }
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
        this.ok=false;
        return "2";
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
