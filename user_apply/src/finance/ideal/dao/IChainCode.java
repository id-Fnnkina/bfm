package finance.ideal.dao;

import finance.ideal.domain.ChainCodeDomain;

import java.util.List;

public interface IChainCode {
    List<ChainCodeDomain> SendChainCodeData();//发送区块链的数据
    ChainCodeDomain SendChainCodeDataDetail(String recordId);//查询单条区块链详情的数据
    List<ChainCodeDomain> SendSelectChainCodeData(String BusinessNumber);
}
