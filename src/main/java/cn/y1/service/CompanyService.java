package cn.y1.service;

import cn.y1.domain.Company;

public interface CompanyService {
    boolean saveC(Company company);
    Company checkResult(String code);


}
