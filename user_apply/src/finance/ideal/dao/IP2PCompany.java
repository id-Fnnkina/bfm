package finance.ideal.dao;

import finance.ideal.domain.P2PCompany;

import java.util.List;

public interface IP2PCompany {
    List<P2PCompany> SendP2PCompanyData();
    List<P2PCompany> SendP2PCompanyDataSelect(String companyname);
    List<Object> SaveP2PCompanyDataSelect(String companyname);
    P2PCompany SendP2PCompanyDataView(String companyname);
}
