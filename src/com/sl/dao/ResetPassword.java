package com.sl.dao;
import com.sl.bean.BCrypt;
import com.sl.util.DBLink;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ResetPassword {
    Connection conn;
    Statement stat;
    ResultSet rs;
    public boolean reset(String phone, String password) {
        conn = DBLink.getConnection();
        String pass = BCrypt.hashpw(password, BCrypt.gensalt());
        String sql = "UPDATE user SET  password='"+pass+"' WHERE phone=" + phone;
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
