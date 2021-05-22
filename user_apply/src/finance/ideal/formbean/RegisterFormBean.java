package finance.ideal.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AIR on 2018/10/31.
 */
public class RegisterFormBean {
    /**
     * 封装的用户注册表单bean，用来接收register.jsp中的表单输入项的值
     * RegisterFormBean中的属性与register.jsp中的表单输入项的name一一对应
     * RegisterFormBean的职责除了负责接收register.jsp中的表单输入项的值之外还担任着校验表单输入项的值的合法性
     * @author gacl
     *
     */
        //RegisterFormBean中的属性与register.jsp中的表单输入项的name一一对应
        //<input type="text" name="name"/>
        private String uname;
        //<input type="password" name="mobile"/>
        private String uphone;
        private String idnumber;
        private String address;
        private String people;
        private String dwname;
        private String dwphone;
        private String money;
        private String work;
        private String isdog;
        private String xueli;
        private String yt;
        private String ly;
        private String bankcard;


        /**
         * 存储校验不通过时给用户的错误提示信息
         */
        private Map<String, String> errors = new HashMap<String, String>();

        public Map<String, String> getErrors() {
            return errors;
        }

        public void setErrors(Map<String, String> errors) {
            this.errors = errors;
        }

        /*
         * validate方法负责校验表单输入项
         * 表单输入项校验规则：
         *         private String userName; 用户名不能为空，并且要是3-8的字母 abcdABcd
         *         private String userPwd; 密码不能为空，并且要是3-8的数字
         *         private String confirmPwd; 两次密码要一致
         *         private String email; 可以为空，不为空要是一个合法的邮箱
         *         private String birthday; 可以为空，不为空时，要是一个合法的日期
         */
        public boolean validate() {

            boolean isOk = true;

//            if (this.name == null || this.name.trim().equals("")) {
//                isOk = false;
//                errors.put("name", "用户名不能为空！！");
//            } else {
//                if (!this.name.matches("[a-zA-Z]{3,8}")) {
//                    isOk = false;
//                    errors.put("name", "用户名必须是3-8位的字母！！");
//                }
//            }

            if (this.uphone == null || this.uphone.trim().equals("")) {
                isOk = false;
                errors.put("mobile", "手机不能为空！！");
            }

            if (this.idnumber == null || this.idnumber.trim().equals("")) {
                isOk = false;
                errors.put("idnumber", "身份证不能为空！！");
            }

            return isOk;
        }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDwname() {
        return dwname;
    }

    public void setDwname(String dwname) {
        this.dwname = dwname;
    }

    public String getDwphone() {
        return dwphone;
    }

    public void setDwphone(String dwphone) {
        this.dwphone = dwphone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getIsdog() {
        return isdog;
    }

    public void setIsdog(String isdog) {
        this.isdog = isdog;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }
}
