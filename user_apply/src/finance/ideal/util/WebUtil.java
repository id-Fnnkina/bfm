package finance.ideal.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by AIR on 2018/10/31.
 */
public class WebUtil {
    /**
     * 将request对象转换成T对象
     * @param request
     * @param clazz
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                System.out.println("name:"+name);
                System.out.println("value:"+value);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成UUID
     * @return
     */
    public static String makeId(){
        return UUID.randomUUID().toString();
    }
}
