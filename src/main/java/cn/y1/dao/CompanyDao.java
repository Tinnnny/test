package cn.y1.dao;

import cn.y1.domain.Company;

public interface CompanyDao {
    Company findByCompany(String company);

    void saveCom(Company company);
    Company findByCode(String code);

}
