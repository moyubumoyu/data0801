package test03;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter
public class FilterDemo_01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig)throws ServletException{}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain) throws ServletException, IOException {
        System.out.println("执行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行");
    }
    @Override
    public void destroy(){}

}
