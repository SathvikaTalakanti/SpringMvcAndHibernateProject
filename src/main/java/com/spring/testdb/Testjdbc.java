package com.spring.testdb;


import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {
    public static void main(String[] args){
        String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user= "springstudent";
        String pass="Sath@9381@#9";

        try{
            System.out.println("Connecting to database: "+jdbcUrl);
            Connection myConn= DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection Successful!!!!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}