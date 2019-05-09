package cn.y1.dao;

import cn.y1.domain.News;
import cn.y1.domain.Purchase;
import cn.y1.domain.Seller;
import cn.y1.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Purchase findOne(int id) {
        String sql="select * from tab_purchase where id = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Purchase>(Purchase.class),id);
    }

    @Override
    public List<Purchase> findByPage(int start, int pageSize) {
        String sql="select * from tab_purchase limit ? , ?  ";
        return template.query(sql,new BeanPropertyRowMapper<Purchase>(Purchase.class),start,pageSize);
    }

    @Override
    public List<News> findByPage2(int start, int pageSize) {
        String sql="select * from tab_news limit ? , ?  ";
        return template.query(sql,new BeanPropertyRowMapper<News>(News.class),start,pageSize);
    }

    @Override
    public Seller findS(int sid) {
        String sql="select * from tab_seller where sid= ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),sid);
    }

    @Override
    public int findTotalCount() {
        String sql="select count(*) from tab_purchase  ";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public int findTotalCount2() {
        String sql="select count(*) from tab_news  ";
        return template.queryForObject(sql, Integer.class);
    }
}
