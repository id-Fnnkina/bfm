package finance.ideal.util;

import finance.ideal.domain.Applicant;
import finance.ideal.domain.ModelSourceStatus;
import finance.ideal.domain.SysConfig;
import finance.ideal.formbean.RegisterFormBean;
import finance.ideal.service.IApplicantService;
import finance.ideal.serviceImpl.ApplicantServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AIR on 2018/12/18.
 */
public class AssessmentRequestUtil {

    public static RegisterFormBean formValidate(HttpServletRequest request) throws Exception{
        //将客户端提交的表单数据封装到RegisterFormBean对象中
        RegisterFormBean formbean = WebUtil.request2Bean(request,RegisterFormBean.class);
        //校验用户注册填写的表单数据
        if (formbean.validate() == false) {//如果校验失败
            System.out.println("校验失败");
            //将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
            //request.setAttribute("formbean", formbean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp

            return null;
        }
        return formbean;
    }

    public static Applicant structureFormBean(RegisterFormBean bean) throws Exception{
        Applicant applicant = new Applicant();
        BeanUtils.copyProperties(applicant, bean);//把表单的数据填充到javabean中
        return applicant;
    }

    public static void getRequest(Applicant applicant,String serviceType){
        try {
            IApplicantService service = new ApplicantServiceImpl();

            applicant.setUphone(MD5.md5(applicant.getUphone(), Constants.md5SecretKey));
            applicant.setIdnumber(MD5.md5(applicant.getIdnumber(), Constants.md5SecretKey));
            applicant.setBankcard(MD5.md5(applicant.getBankcard(), Constants.md5SecretKey));

            if("个人贷款信用评估".equals(serviceType)){
                applicant.setOrdernum("single_loan_"+String.valueOf(System.currentTimeMillis()));
                applicant.setServietype("PersonalLoancount");
            }else if("个人运营商信用风险评估".equals(serviceType)){
                applicant.setOrdernum("single_operator_"+String.valueOf(System.currentTimeMillis()));
                applicant.setServietype("PersonalOperatorcount");
            }else if("企业经营风险评估".equals(serviceType)){
                applicant.setOrdernum("enterprise_risk_"+String.valueOf(System.currentTimeMillis()));
                applicant.setServietype("enterprisecount");
            }else if("网贷平台风险评估".equals(serviceType)){
                applicant.setOrdernum("p2p_risk_"+String.valueOf(System.currentTimeMillis()));
                applicant.setServietype("NetLoancount");
            }

            //调用service层新增业务数据
            service.register(applicant);
            System.out.println("***********新增一条业务数据成功*****************");

            SysConfig sc = service.initConfig(applicant.getServietype(),Constants.MODEL_LEVEL);
            if(null != sc){
                ChainCode c = new ChainCode();

                //调用合约，在合约回调中碰撞数据
                System.out.println("****调用合约，在合约回调中碰撞数据***");
                c.invoke(applicant,sc,applicant.getServietype(),sc.getUrl());
            }else{
                System.out.println("servicetype检测失败");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConn();
        }
    }
}
