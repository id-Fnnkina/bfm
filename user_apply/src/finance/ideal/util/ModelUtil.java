package finance.ideal.util;

/**
 * Created by AIR on 2018/11/29.
 */
public class ModelUtil {

    public static String exceuteUNcheatAssessmentModel(String model,String result){
        System.out.println("触发了反欺诈评估模型");
        return "{\"result\":\"UNcheatAssessmentModel模型得分80分\",\"rs\":\"评估通过\"}";
    }

    public static String exceuteCreditAssessmentModel(String model,String result){
        System.out.println("触发了信用评估模型");
        return "{\"result\":\"CreditAssessmentModel模型得分96分\",\"rs\":\"评估通过\"}";
    }

    public static String exceuteLimitAssessmentModel(String model,String result){
        System.out.println("触发了额度评估模型");
        return "{\"result\":\"评估结束，放款额度2w\",\"rs\":\"评估通过\"}";
    }
}
