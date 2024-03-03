/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    Connection con = null;
    PreparedStatement statement = null;
    
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        
        ResultSet rs = null;
        Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM NHANVIEN";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);
            
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setDiaChi(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setChucVu(rs.getString(5));
                nv.setGioiTinh(rs.getBoolean(6));
                nv.setPhanQuyen(rs.getBoolean(7));
                nv.setMatKhau(rs.getString(8));
                nv.setHinhAnh(rs.getString(9));
                
                list.add(nv);
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
    
    public NhanVien getNhanVienByID(String maNV) {
        //List<NhanVien> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM NHANVIEN WHERE MaNV=?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setDiaChi(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setChucVu(rs.getString(5));
                nv.setGioiTinh(rs.getBoolean(6));
                nv.setPhanQuyen(rs.getBoolean(7));
                nv.setMatKhau(rs.getString(8));
                nv.setHinhAnh(rs.getString(9));
                
                return nv;
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
    
    public int add(NhanVien nv) {
        try {
            String stringSQL = "INSERT INTO NHANVIEN ([MaNV], [TenNV],[DiaChi],[SDT],[ChucVu],[GioiTinh],[PhanQuyen],[MatKhau],[HinhAnh]) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, nv.getMaNV());
            statement.setString(2, nv.getTenNV());
            statement.setString(3, nv.getDiaChi());
            statement.setString(4, nv.getSDT());
            statement.setString(5, nv.getChucVu());
            statement.setBoolean(6, nv.isGioiTinh());
            statement.setBoolean(7, nv.isPhanQuyen());
            statement.setString(8, nv.getMatKhau());
            statement.setString(9, nv.getHinhAnh());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(NhanVien nv) {
        try {
            String stringSQL = "UPDATE NHANVIEN "
                    + "SET TenNV = ?, DiaChi = ?, SDT = ?, ChucVu = ?, GioiTinh = ?, PhanQuyen = ?, MatKhau = ?, HinhAnh = ? "
                    + "WHERE MaNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, nv.getTenNV());
            statement.setString(2, nv.getDiaChi());
            statement.setString(3, nv.getSDT());
            statement.setString(4, nv.getChucVu());
            statement.setBoolean(5, nv.isGioiTinh());
            statement.setBoolean(6, nv.isPhanQuyen());
            statement.setString(7, nv.getMatKhau());
            statement.setString(8, nv.getHinhAnh());
            statement.setString(9, nv.getMaNV());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int updateluong(NhanVien nv) {
        int luong = 0;
        if (nv.isPhanQuyen()) {
            luong = 200000;
        } else {
            luong = 100000;
        }
        try {
            String stringSQL = "UPDATE NHANVIEN "
                    + "SET LuongTheoCA = ? "
                    + "WHERE MaNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, luong);
            statement.setString(2, nv.getMaNV());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(String maNV) {
        try {
            String stringSQL = "DELETE NHANVIEN WHERE MaNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setString(1, maNV);
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
}
