package finance.ideal.dao;

import finance.ideal.domain.Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IDashboard {
    Map<String, Integer> SendCompanyCount();// 获得使用方的统计结果
    Map<String, Integer> SendModelCount();// 获得模型的统计结果
    Map<String,List> SendTimeAndModelCount();// 获得模型的统计结果
    public Map<String, Integer> SendMemberSCCount();// 有效碰撞数据
}
