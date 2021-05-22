package finance.ideal.util;

/**
 * Created by AIR on 2018/12/14.
 */
public class ExportUtil {
    // TODO: 2018/12/14
    // 导入任务批次信息查询界面，列表展示批次导入信息
    String sql = "select batchno from applicant where batchno is not null and batchno <>''  group by batchno order by batchno";
    String sql1 = "select * from applicant where batchno = '2018-12-17'";

    // TODO: 2018/12/14
    // 选择某一批次，导出该批次的所有业务的评估情况


    // TODO: 2018/12/14
    // 1.导入信息，业务表，添加批次字段
    // 2.导入信息的测试文件及多条测试业务数据样本，对应着业务表各字段
    // 3.导出信息的测试文件及多条测试业务数据样本，对应着每条业务的评估结果

}
