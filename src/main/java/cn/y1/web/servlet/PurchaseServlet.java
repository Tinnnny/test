package cn.y1.web.servlet;

import cn.y1.domain.*;
import cn.y1.service.FavoriteService;
import cn.y1.service.FavoriteServiceImpl;
import cn.y1.service.PurchaseService;
import cn.y1.service.PurchaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/purchase/*")
public class PurchaseServlet extends BaseServlet {

    private PurchaseService purchaseService=new PurchaseServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String des=request.getParameter("des");
//        des=new String(des.getBytes("iso-8859-1"),"utf-8");
        int currentPage=1;
        if (currentPageStr!=null && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            currentPage=1;
        }

        int pageSize=6;
        if (pageSizeStr!=null && pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize=6;
        }
        PageBean<Purchase> pb = purchaseService.PageQuery(currentPage, pageSize);

        writeValue(pb,response);
//        request.setAttribute("pb",pb);
//        request.getRequestDispatcher("purchase.html").forward(request,response);

    }
    public void pageQuery2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String des=request.getParameter("des");
//        des=new String(des.getBytes("iso-8859-1"),"utf-8");
        int currentPage=1;
        if (currentPageStr!=null && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            currentPage=1;
        }

        int pageSize=6;
        if (pageSizeStr!=null && pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize=6;
        }
        PageBean<News> pb = purchaseService.PageQuery2(currentPage, pageSize);

        writeValue(pb,response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Purchase purchase = purchaseService.findOne(id);
        writeValue(purchase,response);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
         User user = (User) request.getSession().getAttribute("user");
         int uid;
         if (user==null){
             uid=0;
         }else{
             uid=user.getUid();
         }
         boolean flag = favoriteService.isFavorite(id, uid);
         writeValue(flag,response);
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
         User user = (User) request.getSession().getAttribute("user");
         int uid;
         if (user==null){
             return;
         }else{
             uid=user.getUid();
         }
        favoriteService.add(id,uid);
    }





}
