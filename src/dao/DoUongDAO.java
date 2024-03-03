/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.DoUong;

/**
 *
 * @author Admin
 */
public class DoUongDAO {
    Connection con = null;
    PreparedStatement statement = null;
    
    public List<DoUong> getAll() {
        List<DoUong> list = new ArrayList<>();
        
        ResultSet rs = null;
        Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM DOUONG";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);
            
            while (rs.next()) {
                DoUong du = new DoUong();
                
                du.setMaDU(rs.getInt(1));
                du.setTenDU(rs.getString(2));
                du.setGiaDU(rs.getInt(3));
                du.setHinhAnh(rs.getString(4));
                du.setTrangThai(rs.getBoolean(5));
                
                list.add(du);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        
        finally {
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return list;
    }
    
    public DoUong getDoUongByID(int maDU) {
        //List<DoUong> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM DOUONG WHERE MaDU = ?";
            con = DatabaseHelper.getDBConnect();
            //sttm = con.createStatement();
            //rs = sttm.executeQuery(stringSQL);
            statement = con.prepareStatement(stringSQL);
            statement.setInt(1, maDU);
            rs = statement.executeQuery();
            
            
            while (rs.next()) {
                DoUong du = new DoUong();
                
                du.setMaDU(rs.getInt(1));
                du.setTenDU(rs.getString(2));
                du.setGiaDU(rs.getInt(3));
                du.setHinhAnh(rs.getString(4));
                du.setTrangThai(rs.getBoolean(5));
                
                return du;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        
        finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return null;
    }
    
    public int add(DoUong du) {
        try {
            String stringSQL = "INSERT INTO DOUONG ([MaDU], [TenDU],[GiaDU],[HinhAnh], [TrangThai]) "
                    + "VALUES(?, ?, ?, ?, ?)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, du.getMaDU());
            statement.setString(2, du.getTenDU());
            statement.setInt(3, du.getGiaDU());
            statement.setString(4, du.getHinhAnh());
            statement.setBoolean(5, du.isTrangThai());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(DoUong du) {
        try {
            String stringSQL = "UPDATE DOUONG "
                    + "SET TenDU = ?, GiaDU = ?,HinhAnh = ?, TrangThai = ? "
                    + "WHERE MaDU = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, du.getTenDU());
            statement.setInt(2, du.getGiaDU());
            statement.setString(3, du.getHinhAnh());
            statement.setBoolean(4, du.isTrangThai());
            
            statement.setString(5, String.valueOf(du.getMaDU()));
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(DoUong du) {
        try {
            String stringSQL = "DELETE DOUONG WHERE MaDU = ?" +
                    " AND MaDU NOT IN (SELECT MaDU FROM CHITIETHOADON)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, String.valueOf(du.getMaDU()));
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            } else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
}
