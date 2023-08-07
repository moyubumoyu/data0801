package test04;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/md1")
public class MyServletDemo extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.invalidate();
    }
}
