package com.BtBuoi14.controller;

import com.BtBuoi14.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login",urlPatterns = "/login")
public class LoginPage extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(10000);
        boolean isLogin = loginService.checkLogin(email,pass);
        if(isLogin){
            session.setAttribute("isLogin", true);
            System.out.println("dang nhap thanh cong");
        }
        req.getRequestDispatcher("login-page.jsp").forward(req,resp);
    }

}
