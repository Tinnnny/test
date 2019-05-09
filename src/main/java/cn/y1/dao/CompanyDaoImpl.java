package cn.y1.dao;

import cn.y1.domain.Company;
import cn.y1.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CompanyDaoImpl implements CompanyDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Company findByCompany(String companyname) {
        Company company=null;
        try {
            String sql = "select * from tab_company where companyname = ? ";
            company = template.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), companyname);
        } catch (Exception e) {
        }
        return company;
    }

    @Override
    public void saveCom(Company company) {
        String sql="insert into tab_company (companyname,proseries,testmeth,bookingdate,testnum,address,code)values(?,?,?,?,?,?,?)";
        template.update(sql,company.getCompanyname()
                             ,company.getProseries()
                             ,company.getTestmeth()
                             ,company.getBookingdate()
                             ,company.getTestnum()
                             ,company.getAddress()
                             ,company.getCode());
    }

    @Override
    public Company findByCode(String code) {
        Company company=null;
        try {
            String sql="select * from tab_company where code = ? ";
            company = template.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return company;
    }


}
