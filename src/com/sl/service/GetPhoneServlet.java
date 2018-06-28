package com.sl.service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/GetPhoneServlet")
public class GetPhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = (HttpSession) request.getSession();
        String phone = (String) session.getAttribute("phone");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("phone", phone);
//        response.getWriter().write(jsonObject.toString());
        response.getWriter().write(phone);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
