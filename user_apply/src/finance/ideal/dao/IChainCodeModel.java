package finance.ideal.dao;

import finance.ideal.domain.ChainCodeDomain;
import finance.ideal.domain.ChainCodeModelDomain;

import java.util.List;

public interface IChainCodeModel {
    List<ChainCodeModelDomain> SendChainCodeModelData();//发送区块链模型的数据
    ChainCodeModelDomain SendChainCodeModelDataDetail(String recordId);//查询单条区块链详情的数据
}
