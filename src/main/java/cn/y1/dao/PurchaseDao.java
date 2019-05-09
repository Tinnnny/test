package cn.y1.dao;

import cn.y1.domain.News;
import cn.y1.domain.Purchase;
import cn.y1.domain.Seller;

import java.util.List;

public interface PurchaseDao {
    //根据id 查找
        Purchase findOne(int id);
        //每一页
        List<Purchase> findByPage( int start , int pageSize);
        List<News> findByPage2(int start , int pageSize);
        Seller findS(int sid);
    /**
     * 根据cid查询总记录数
     */
        int findTotalCount();
        int findTotalCount2();
}
