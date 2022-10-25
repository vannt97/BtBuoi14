package com.BtBuoi14.respository;

import com.BtBuoi14.config.MySqlConnection;
import com.BtBuoi14.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRespository {

    public List<User> getUserByEmailAndPassword(String email, String password){
        List<User>  list = new ArrayList<>();
        try {
            String query = "select * from user u where u.email=? and u.password=?";
            Connection connection = MySqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
                user.setAddress(resultSet.getString("address"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setRoleId(resultSet.getInt("role_id"));
                list.add(user);
            }
        }catch (Exception e){
            System.out.println("Error User Respository");
        }

        return list;
    }
}
