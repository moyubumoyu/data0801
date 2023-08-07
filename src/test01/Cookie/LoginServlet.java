package test01.Cookie;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import test01.entity.User;
import test01.utils.JDBCUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        String sql = " select * from user where username=? and password=?";
        try{
            User u = qr.query(sql,new BeanHandler<>(User.class),username,password);
            if(u!=null){
                String remember = req.getParameter("remember");
                if(null==remember){
                    Cookie c1 = new Cookie("uname","");
                    Cookie c2 = new Cookie("pwd","");
                    c1.setMaxAge(0);
                    c2.setMaxAge(0);
                    resp.addCookie(c1);
                    resp.addCookie(c2);
                }else {
                    Cookie c1 = new Cookie("uname",u.getUsername());
                    Cookie c2 = new Cookie("pwd",u.getPassword());
                    c1.setMaxAge(60*60);
                    c2.setMaxAge(60*60);
                    resp.addCookie(c1);
                    resp.addCookie(c2);
                }
                req.setAttribute("user",u);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }else {
                req.setAttribute("msg","用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }

    }
}
