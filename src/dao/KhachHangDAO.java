/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {
    Connection con = null;
    PreparedStatement statement = null;
    
    public int add(KhachHang kh) {
        try {
            String stringSQL = "INSERT INTO KHACHHANG (TenKH, DiaChiKH, SDTKH) "
                    + "VALUES (?,?,?)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, kh.getTenKH());
            statement.setString(2, kh.getDiaChiKH());
            statement.setString(3, kh.getSdtKH());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(KhachHang kh) {
        try {
            String stringSQL = "UPDATE KHACHHANG SET TenKH = ?, DiaChiKH = ?, SDTKH = ? WHERE MaKH = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, kh.getTenKH());
            statement.setString(2, kh.getDiaChiKH());
            statement.setString(3, kh.getSdtKH());
            statement.setString(4, kh.getMaKH());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(KhachHang kh) {
        try {
            String stringSQL = "DELETE KHACHHANG WHERE MaKH = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, kh.getMaKH());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<KhachHang> getAll() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        
        ResultSet rs = null;
        Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM KHACHHANG";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);
            
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                
                kh.setMaKH(String.valueOf(rs.getInt(1)));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChiKH(rs.getString(3));
                kh.setSdtKH(rs.getString(4));
                
                listKhachHang.add(kh);
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
        
        return listKhachHang;
    }
    
    public KhachHang findKhachHangByID(String maKH) {
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM KHACHHANG WHERE MaKH=?";
            con = DatabaseHelper.getDBConnect();
            //sttm = con.createStatement();
            //rs = sttm.executeQuery(stringSQL);
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maKH);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                
                kh.setMaKH(String.valueOf(rs.getInt(1)));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChiKH(rs.getString(3));
                kh.setSdtKH(rs.getString(4));
                
                return kh;
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
}
