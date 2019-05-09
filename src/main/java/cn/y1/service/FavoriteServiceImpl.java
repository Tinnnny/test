package cn.y1.service;

import cn.y1.dao.FavoriteDao;
import cn.y1.dao.FavoriteDaoImpl;
import cn.y1.domain.Favorite;

public class FavoriteServiceImpl implements FavoriteService {
     private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String id, int uid) {
        Favorite favorite = favoriteDao.findByIdandUid(Integer.parseInt(id), uid);
        return favorite!=null;

    }

    @Override
    public void add(String id, int uid) {
        favoriteDao.add(Integer.parseInt(id),uid);
    }
}
