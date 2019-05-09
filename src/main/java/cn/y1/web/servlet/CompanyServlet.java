package cn.y1.web.servlet;

import cn.y1.domain.Company;
import cn.y1.domain.ResultInfo;
import cn.y1.service.CompanyService;
import cn.y1.service.CompanyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet {
    private CompanyService service = new CompanyServiceImpl();

    public void booking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证校验
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
            //验证码错误
            ResultInfo info = new ResultInfo();
            //预约失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        Company company=new Company();
        try {
            BeanUtils.populate(company,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成预约
        boolean flag = service.saveC(company);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if(flag){
            //预约成功
            info.setFlag(true);
        }else{
            //预约失败
            info.setFlag(false);
            info.setErrorMsg("预约失败!");
        }
        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        session.setAttribute("company",company);
    }


    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取查询序列号
        Object code = request.getSession().getAttribute("company");
        //将user写回客户端

       /* ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);*/
        writeValue(code,response);
    }

    public void checkResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String code = request.getParameter("code");
            Company company = service.checkResult(code);
            ResultInfo info = new ResultInfo();
            //4.响应结果
            if(company!=null){
                info.setFlag(true);
            }else{
                info.setFlag(false);
                info.setErrorMsg("查询码错误，请重新输入！");
            }
           writeValue(info,response);
           request.getSession().setAttribute("company",company);

        }
    }

