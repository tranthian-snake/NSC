package com.demo.dao;

import com.demo.database.ConnectionUtil;
import com.demo.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = ConnectionUtil.getConnection();

    public List<User> getUser(String username, String password){
        List<User> list = new ArrayList<>();

        String sql = "select * from user where username = '"+ username +"' and password = " + password;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                User user = new User(name,pass);
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
