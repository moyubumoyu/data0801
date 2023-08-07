package test04.demo;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.LinkedList;

@WebListener
public class OnlineListner implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
   ServletContext context;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LinkedList<String> list = new LinkedList<>();
        context = servletContextEvent.getServletContext();
        context.setAttribute("list",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if("username".equals(httpSessionBindingEvent.getName())){
            HttpSession session = httpSessionBindingEvent.getSession();
            String username = (String) session.getAttribute("username");
            LinkedList<String> list = (LinkedList<String>) context.getAttribute("list");
            list.add(username);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String username = (String) session.getAttribute("username");
        LinkedList<String> list = (LinkedList<String>) context.getAttribute("list");
        list.remove(username);
    }
}
