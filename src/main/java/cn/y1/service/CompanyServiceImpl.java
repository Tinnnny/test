package cn.y1.service;

import cn.y1.dao.CompanyDao;
import cn.y1.dao.CompanyDaoImpl;
import cn.y1.domain.Company;
import cn.y1.util.UuidUtil;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao=new CompanyDaoImpl();
    @Override
    public boolean saveC(Company company) {
        Company b = companyDao.findByCompany(company.getCompanyname());
        if(b!=null){
            return false;
        }
        company.setCode(UuidUtil.getUuid());
        companyDao.saveCom(company);

        return true;
    }

    @Override
    public Company checkResult(String code) {
        return companyDao.findByCode(code);
    }


}
