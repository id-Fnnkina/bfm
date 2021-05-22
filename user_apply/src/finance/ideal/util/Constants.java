package finance.ideal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AIR on 2018/12/5.
 */
public class Constants {

    public static final String md5SecretKey = "2018*ideal";

    public static Map<String,String> modelLevelMap = new HashMap<>();

    public static final String MODEL_LEVEL = "1";

    public static final String MODEL_LEVEL_TWO = "2";

    public static final String MODEL_LEVEL_THREE = "3";

    public static final int SOURCE_LIST = 3;

    static {
        modelLevelMap.put("uncheatAssessment","1");
        modelLevelMap.put("creditAssessment","2");
        modelLevelMap.put("limitAssessment","3");
    }
}
