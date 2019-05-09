package cn.y1.service;

import cn.y1.dao.*;
import cn.y1.domain.*;

import java.util.List;

public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseDao purchaseDao=new PurchaseDaoImpl();
    private PurchaseImgDao purchaseImgDao=new PurchaseImgDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public PageBean<Purchase> PageQuery(int currentPage, int pageSize) {
        //封装pagebean
        PageBean<Purchase> pb = new PageBean<>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = purchaseDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;//开始的记录数
        List<Purchase> list = purchaseDao.findByPage(start, pageSize);

        pb.setList(list);
        //设置总页数=总记录数/每页显示条数

        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<News> PageQuery2(int currentPage, int pageSize) {
        //封装pagebean
        PageBean<News> pb = new PageBean<>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = purchaseDao.findTotalCount2();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;//开始的记录数
        List<News> list = purchaseDao.findByPage2(start, pageSize);

        pb.setList(list);
        //设置总页数=总记录数/每页显示条数

        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Purchase findOne(String id) {
        Purchase purchase = purchaseDao.findOne(Integer.parseInt(id));
        List<PurchaseImg> purchaseImgList = purchaseImgDao.findOne(Integer.parseInt(id));
        purchase.setPurchaseImgList(purchaseImgList);
        System.out.println("sid:"+purchase.getSid());
        Seller seller = purchaseDao.findS(purchase.getSid());
        System.out.println("sid:"+purchase.getSid());
        purchase.setSeller(seller);
        int count=favoriteDao.findCountById(purchase.getId());
        purchase.setCount(count);
        return purchase;
    }
}
