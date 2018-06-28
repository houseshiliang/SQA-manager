package com.sl.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sl.bean.ParkDeal;
import com.sl.dao.ParkOrderHistory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/ParkOrderHistoryServlet")
public class ParkOrderHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session= (HttpSession) request.getSession();
        String phone= (String) session.getAttribute("phone");
        ParkOrderHistory parkOrderHistory=new ParkOrderHistory();
        List<ParkDeal> orderDeal= null;
        try {
            orderDeal=parkOrderHistory.getAllDeal(phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonArray.addAll(orderDeal);
        jsonObject.put("data",jsonArray);
        jsonObject.put("total",jsonArray.size());
        response.getWriter().write(jsonObject.toString());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
