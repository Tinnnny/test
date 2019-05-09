package cn.y1.service;

import cn.y1.domain.Favorite;

public interface FavoriteService {
    boolean isFavorite(String id,int uid);


    void add(String id, int uid);
}
