package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");//程序入口
        String password = req.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)){
            //登陆成功
            resp.setContentType("text/html;charset=UTF-8");//否则会乱码
            resp.getWriter().write("登陆成功...");
        }else{
            //重定向登陆页面
            //设置302的状态码
            resp.setStatus(302);
            resp.setHeader("location", "/day10/response/login.html");

            //第二种方法重定向，把上面两步合起来
            resp.sendRedirect("/day10/response/login.html");
        }
    }
}
