/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.LuongNV;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class LuongNVDAO {

    Connection con = null;
    PreparedStatement statement = null;

    public int add(LuongNV lnv) {
        try {
            String stringSQL = "INSERT INTO LUONGNV (MaLuongNV, MaNV, TongCaLamViec, TongTien, KyLuong) "
                    + "VALUES (?,?,?,?,?)";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            statement.setInt(1, lnv.getMaLuongNV());
            statement.setString(2, lnv.getNhanVien().getMaNV());
            statement.setInt(3, lnv.getTongCaLamViec());
            statement.setInt(4, lnv.getTongTien());
            statement.setString(5, lnv.getKyLuong());

            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }

    public int update(LuongNV lnv) {
        try {
            String stringSQL = "UPDATE LUONGNV SET MaNV=?, TongCaLamViec=?, TongTien=?, KyLuong=? WHERE MaLuongNV=?)";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            statement.setString(1, lnv.getNhanVien().getMaNV());
            statement.setInt(2, lnv.getTongCaLamViec());
            statement.setInt(3, lnv.getTongTien());
            statement.setString(4, lnv.getKyLuong());
            statement.setInt(5, lnv.getMaLuongNV());

            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public int updateTongCaLamViec(LuongNV lnv) {
        try {
            String stringSQL = "UPDATE LUONGNV SET TongCaLamViec = (SELECT COUNT(LNV.MaLuongNV) FROM LUONGNV LNV  INNER JOIN CHITIETLUONGNV CT ON LNV.MaLuongNV = CT.MaLuongNV GROUP BY LNV.MaLuongNV HAVING LNV.MaLuongNV = ?) WHERE MaLuongNV = ?";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, lnv.getMaLuongNV());
            statement.setInt(2, lnv.getMaLuongNV());

            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public int updateTongTien(LuongNV lnv) {
        try {
            String stringSQL = "UPDATE LUONGNV SET TongTien = (SELECT (NV.LuongTheoCa * LNV.TongCaLamViec) FROM NHANVIEN NV INNER JOIN LUONGNV LNV ON NV.MaNV = LNV.MaNV WHERE LNV.MaLuongNV = ?) WHERE MaLuongNV = ?";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, lnv.getMaLuongNV());
            statement.setInt(2, lnv.getMaLuongNV());

            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public int delete(LuongNV lnv) {
        try {
            String stringSQL = "DELETE LUONGNV WHERE MaLuongNV=?)";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, lnv.getMaLuongNV());

            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public List<LuongNV> getAll() {
        List<LuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM LUONGNV";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);
            
            while (rs.next()) {
                LuongNV lnv = new LuongNV();
                
                lnv.setMaLuongNV(rs.getInt(1));
                
                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                lnv.setNhanVien(nv);
                
                lnv.setTongCaLamViec(rs.getInt(3));
                lnv.setTongTien(rs.getInt(4));
                lnv.setKyLuong(rs.getString(5));
                
                list.add(lnv);
            }
            
            
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return list;
    }
    
    public List<LuongNV> getLuongNVByMaNV(String maNV) {
        List<LuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM LUONGNV WHERE MaNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                LuongNV lnv = new LuongNV();
                
                lnv.setMaLuongNV(rs.getInt(1));
                
                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                lnv.setNhanVien(nv);
                
                lnv.setTongCaLamViec(rs.getInt(3));
                lnv.setTongTien(rs.getInt(4));
                lnv.setKyLuong(rs.getString(5));
                
                list.add(lnv);
            }
            
            
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return list;
    }
    
    public LuongNV getLuongNVByID(int maLuongNV) {
        //List<LuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM LUONGNV WHERE MaLuongNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setInt(1, maLuongNV);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                LuongNV lnv = new LuongNV();
                
                lnv.setMaLuongNV(rs.getInt(1));
                
                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                lnv.setNhanVien(nv);
                
                lnv.setTongCaLamViec(rs.getInt(3));
                lnv.setTongTien(rs.getInt(4));
                lnv.setKyLuong(rs.getString(5));
                
                return lnv;
            }
            
            
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return null;
    }
    
    public List<LuongNV> getLuongNVByKyLuong(String kyLuong) {
        List<LuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM LUONGNV WHERE KyLuong = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, kyLuong);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                LuongNV lnv = new LuongNV();
                
                lnv.setMaLuongNV(rs.getInt(1));
                
                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                lnv.setNhanVien(nv);
                
                lnv.setTongCaLamViec(rs.getInt(3));
                lnv.setTongTien(rs.getInt(4));
                lnv.setKyLuong(rs.getString(5));
                
                list.add(lnv);
            }
            
            
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        return list;
    }
    
    public LuongNV getLuongNVByMaNVAndKyLuong(String maNV, String kyLuong) {
        //List<LuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM LUONGNV WHERE MaNV = ? AND KyLuong = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maNV);
            statement.setString(2, kyLuong);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                LuongNV lnv = new LuongNV();
                
                lnv.setMaLuongNV(rs.getInt(1));
                
                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                lnv.setNhanVien(nv);
                
                lnv.setTongCaLamViec(rs.getInt(3));
                lnv.setTongTien(rs.getInt(4));
                lnv.setKyLuong(rs.getString(5));
                
                return lnv;
            }
            
            
        } catch (Exception e) {
        } finally {
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
