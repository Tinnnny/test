package cn.y1.service;


import cn.y1.domain.News;
import cn.y1.domain.User;

public interface UserService {

    boolean regist(User user);

    boolean active(String code);

    User login(User user);

    boolean edit(News news);
}
