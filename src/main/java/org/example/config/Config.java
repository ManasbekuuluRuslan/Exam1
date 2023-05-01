package org.example.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Config {
   public static Connection getConnection() {
       Connection connection = null;
       try {
           connection = null;
           connection = DriverManager.getConnection(
                   "jdbc:postgresql://localhost:5432/postgres",
                   "postgres",
                   "postgres");
           System.out.println("Connected to database");
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return connection;
   }

}
