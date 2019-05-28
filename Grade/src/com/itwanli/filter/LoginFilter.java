package com.itwanli.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁!");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;    // 请求转化 - HttpServletRequest是浏览器可懂
        HttpSession session = request.getSession();

        Object object = session.getAttribute("currentUser");

        // 先获取到你访问的url路径,如果你的url是以login、login.jsp这两种情况，过滤器应该放行;
        String path = request.getServletPath();
        System.out.println(path);

        // indexOf函数是指找字符串中是否包含你需要寻找的字符串，能找到以数量计算，不能找到-1；
        if(object == null && path.indexOf("login")<0 && path.indexOf("login.jsp")<0 ){ // 按登录超时处理跳转到登录页面
            request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        }else{  // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig config)
            throws ServletException {
        System.out.println("过滤器初始化产生!");
    }

}
