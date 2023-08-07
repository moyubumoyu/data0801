package test03;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*@WebFilter("/*")*/
public class FilterEncoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();

        ArrayList<String> list = new ArrayList<>();
        list.add("login.html");
        list.add("user");
        list.add("index.jsp");

        for(String url:list){
            if(uri.contains(url)){
                filterChain.doFilter(request,response);
                return;
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            filterChain.doFilter(request,response);
        }else {
            response.getWriter().println("登录失败");
            response.setHeader("refresh","5;url=/web02/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
