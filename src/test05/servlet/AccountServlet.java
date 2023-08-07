package test05.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import test05.entity.PageBean;
import test05.service.AccountService;
import test05.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    AccountService ac = new AccountServiceImpl();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");

        if ("findAll".equals(method)) {
            findAll(req,resp);
        }
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        PageBean pb = ac.findPage(currentPage, pageSize);

        String s = mapper.writeValueAsString(pb);
        System.out.println(s);
        resp.getWriter().println(s);
    }
}
