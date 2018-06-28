package com.sl.service;
import com.sl.dao.Login;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/UpDataInformServlet")
public class UpDataInformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = (HttpSession) request.getSession();
        String phone = (String) session.getAttribute("phone");
        String mess=request.getParameter("pass");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("phone", phone);
//        response.getWriter().write(mess);
        Login login=new Login();
        boolean res=login.check(phone,mess);
        if (res){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
