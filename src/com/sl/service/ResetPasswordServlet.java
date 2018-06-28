package com.sl.service;
import com.sl.dao.ResetPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass=request.getParameter("password");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = (HttpSession) request.getSession();
        String phone = (String) session.getAttribute("phone");
        ResetPassword resetPassword=new ResetPassword();
        boolean res=resetPassword.reset(phone,pass);
        response.setContentType("text/html;charset=UTF-8");
        if (res){
//            response.getWriter().write("<script>alert('修改成功!')</script>");
//            response.sendRedirect("../index.jsp");
            response.sendRedirect("../jsp/logout.jsp");
        }else{
            response.getWriter().write("<script>alert('阿欧，请稍后再试!')</script>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
