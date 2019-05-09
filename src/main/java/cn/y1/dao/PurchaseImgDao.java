package cn.y1.dao;

import cn.y1.domain.PurchaseImg;

import java.util.List;

public interface PurchaseImgDao {
    List<PurchaseImg> findOne(int id);
}
