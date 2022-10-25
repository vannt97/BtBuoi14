package com.BtBuoi14.config;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection  {
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_crm","root","qweedc@123");
            System.out.println("Ket noi thanh cong");
        }catch (Exception e){
            System.out.println("ket noi that bai");
        }
        return  connection;
    }
}
