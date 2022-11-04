/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author asrat
 */
public class DatabseService {
    private final String url = "jdbc:postgressql://localhost:5432/inventory";
    private final String user = "postgres";
    private final String password = "gucci";
    
    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    } 
    public ResultSet execute(String sql) {
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ) {
            return rs;
         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



}
