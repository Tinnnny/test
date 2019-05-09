package cn.y1.dao;

import cn.y1.domain.PurchaseImg;
import cn.y1.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PurchaseImgDaoImpl implements PurchaseImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<PurchaseImg> findOne(int id) {
        String sql="select * from tab_purchase_img where id = ? ";
        return template.query(sql,new BeanPropertyRowMapper<PurchaseImg>(PurchaseImg.class),id);
    }
}
