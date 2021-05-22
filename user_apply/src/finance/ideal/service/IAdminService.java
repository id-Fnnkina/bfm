package finance.ideal.service;

import finance.ideal.domain.Applicant;
import finance.ideal.domain.ModelSourceStatus;
import finance.ideal.domain.SysConfig;

import java.util.List;

/**
 * Created by AIR on 2018/10/30.
 */
public interface IAdminService {
    /**
     * 提供注册服务
     * * @param Applicant
     * @throws
     */
     String Login(String uname,String password);

}
