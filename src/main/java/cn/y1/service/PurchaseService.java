package cn.y1.service;

import cn.y1.domain.News;
import cn.y1.domain.PageBean;
import cn.y1.domain.Purchase;
import cn.y1.domain.PurchaseImg;

public interface PurchaseService {
    PageBean<Purchase> PageQuery(int currentPage,int pageSize);
    PageBean<News> PageQuery2(int currentPage, int pageSize);

    Purchase findOne(String id);

}
