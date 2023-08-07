package test02.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/r2")
public class AjaxServlet_02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String arr[] = {"aaa","bbb","ccc"};
        String username = req.getParameter("username");
        for(String name:arr){
            if(username.equals(name)){
                resp.getWriter().println(1);
                return;
            }
        }
        resp.getWriter().println(0);
    }
}
