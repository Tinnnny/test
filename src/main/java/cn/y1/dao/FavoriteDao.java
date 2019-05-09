package cn.y1.dao;

import cn.y1.domain.Favorite;

public interface FavoriteDao {
    Favorite findByIdandUid(int id, int uid);

    int findCountById(int id);

    void add(int id, int uid);
}
