package cn.y1.dao;

import cn.y1.domain.News;
import cn.y1.domain.User;

public interface UserDao {
    User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);

    void edit(News news);
}
