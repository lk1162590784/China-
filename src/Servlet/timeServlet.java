package Servlet;

import Dao.BarDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/timeServlet")
public class timeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //创建DAO
        BarDao barDao = new BarDao();
        //从数据库里取数据
        String barArr = barDao.time_out();
        //设置服务器响应时向JSP表示层传输数据的编码格式
        response.setContentType("text/html; charset=utf-8");
        //ArrayList对象转化为JSON对象
        JSONArray json = JSONArray.fromObject(barArr);
        //控制台显示JSON
        System.out.println(json.toString());
        //返回到JSP
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        //关闭输出流
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
