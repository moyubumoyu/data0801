package test02.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import test02.entity.Employees;
import test02.page.PageBean;
import test02.service.EmpService;
import test02.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/emp")

public class EmpServlet extends HttpServlet {
    EmpService empService = new EmpServiceImpl();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");

        if ("findAll".equals(method)) {
            findAll(req,resp);
        }
        if ("deleteEmp".equals(method)) {
            deleteEmp(req,resp);
        }
        if ("addEmp".equals(method)) {
            addEmp(req,resp);
        }
        if ("updateEmp".equals(method)) {
            updateEmp(req,resp);
        }

    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //接收用户想看的页码
        String currentPage = req.getParameter("currentPage");
        //接收用户想每页显示几条
        String pageSize = req.getParameter("pageSize");
        //调用业务
        PageBean pb = empService.findPage(currentPage, pageSize);
        //将对象转json
        String s = mapper.writeValueAsString(pb);
        System.out.println(s);
        //将json数据响应回页面
        resp.getWriter().println(s);
    }
    private void addEmp(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        System.out.println(employeeId);
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String hireDate = req.getParameter("hireDate");
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        int a =empService.addEmp(employeeId,name,salary,hireDate,departmentId);

        if(a>0){
            resp.getWriter().println(1);
        }else {
            resp.getWriter().println(0);
        }

    }
    private void updateEmp(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String hireDate = req.getParameter("hireDate");
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));

        int a = empService.updateEmp(name,salary,hireDate,departmentId,employeeId);
        System.out.println(a);
        if(a>0){
            resp.getWriter().println(1);
        }else {
            resp.getWriter().println(0);
        }
    }
    private void deleteEmp(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        int a = empService.deleteEmp(employeeId);
        if(a>0){
            resp.getWriter().println(1);
        }else {
            resp.getWriter().println(0);
        }
        System.out.println(employeeId);
    }
}
