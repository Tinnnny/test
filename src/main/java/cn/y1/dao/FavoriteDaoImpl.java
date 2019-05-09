package cn.y1.dao;

import cn.y1.domain.Favorite;
import cn.y1.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteDaoImpl implements FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByIdandUid(int id, int uid) {
        Favorite favorite=null;
        try {
            String sql="select * from tab_favorite where id= ? and uid= ? ";
            favorite= template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),id,uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public int findCountById(int id) {
        String sql="select count(*) from tab_favorite where id = ?";
        return template.queryForObject(sql, Integer.class, id);
    }

    @Override
    public void add(int id, int uid) {
        String sql="insert into tab_favorite values (?,?,?) ";
        template.update(sql, id, new Date(),uid);
    }
}
