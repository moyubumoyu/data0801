package test04.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login1")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.setAttribute("username",username);
        resp.sendRedirect("/web02/jsp/show.jsp");
    }
}
