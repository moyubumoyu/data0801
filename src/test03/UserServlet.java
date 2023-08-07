package test03;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*@WebServlet("/user")*/
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getParameter("method");
        if("login".equals(method)){
            login(req,resp);
        }
    }
    private void login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(1001,username,password);

        if("aaa".equals(username) && "111".equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }
    }
}
