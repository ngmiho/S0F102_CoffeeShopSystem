/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DatabaseHelper {
    
    public static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=QuanLyQuanCaPhe;user=sa;password=123;"
            + "encrypt=true;trustServerCertificate=true;";

    public static Connection getDBConnect() {
        Connection con = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Chưa có Driver " + e.toString());
        }
        
        try {
            con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (Exception e) {
            System.out.println("Lỗi Connect: " + e.toString());
        }
        
        return null;
    }
}
