package com.BtBuoi14.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CustomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Check filter");
//        Hàm set font chữ thiết việt
        servletRequest.setCharacterEncoding("UTF-8");
//
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


//        Luu session để kiểm tra xem user đã đăng nhập chưa, có thì khỏi cần vào login còn không thì vào trang đăng nhập
//        HttpSession session = request.getSession();
//        boolean isLogin = (boolean)session.getAttribute("isLogin");
//
//        if(session.getAttribute("isLogin") == null){
//            if (request.getServletPath().equals("/login")){
//                filterChain.doFilter(servletRequest,servletResponse);
//            }else {
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//        }else {
//            if(isLogin == true){
//                if(request.getServletPath().equals("/login")){
//                    response.sendRedirect("index.jsp");
//                }else {
//                    filterChain.doFilter(servletRequest,servletResponse);
//                }
//            }else {
//                filterChain.doFilter(servletRequest,servletResponse);
//            }
//        }
//        System.out.println(session.getAttribute("isLogin"));
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
    }
}
