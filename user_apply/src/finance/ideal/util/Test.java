package finance.ideal.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AIR on 2018/12/4.
 */
public class Test {
    public static Map<String,List<Map<String,List<String>>>> reqMap = new HashMap<>();

    public static List<Map<String,List<String>>> reqModelList = new ArrayList<>();

    public static Map<String,List<String>> reqMSMap = new HashMap<>();

    public static List<String> reqSourceList = new ArrayList<>();

    public static void main(String[]args){
        reqSourceList.add("reqSourceList");

        reqMSMap.put("reqMSMap",reqSourceList);
        reqSourceList.clear();

        reqModelList.add(reqMSMap);
        reqMSMap.clear();

        reqMap.put("reqMap",reqModelList);
        //reqModelList.clear();

        if(reqMap.containsKey("reqMap")){
            System.out.println("reqMap.containsKey(\"reqMap\")");

            List<Map<String,List<String>>> reqModelList1 = reqMap.get("reqMap");
            System.out.println(reqModelList1.size());
        }
        ;
        double  p3  =  (float)2  /  3;
        NumberFormat nf  =  NumberFormat.getPercentInstance() ;
        nf.setMinimumFractionDigits( 2 );
        String str  =  nf.format(p3);
        System.out.println(str);
    }
}
