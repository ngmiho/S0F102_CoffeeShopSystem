/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.CaLamViec;
import model.ChiTietLuongNV;
import model.LuongNV;

/**
 *
 * @author Admin
 */
public class ChiTietLuongNVDAO {
    
    Connection con = null;
    PreparedStatement statement = null;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public int add(ChiTietLuongNV ct) {
        try {
            String stringSQL = "INSERT INTO CHITIETLUONGNV (MaLuongNV, MaCLV, NgayLamViec) "
                    + "VALUES (?,?,?)";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            
            statement.setInt(1, ct.getLuongNV().getMaLuongNV());
            statement.setString(2, ct.getCaLamViec().getMaCLV());
            statement.setString(3, ct.getNgayLamViec().format(formatter));
            

            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public int update(ChiTietLuongNV ct) {
        try {
            String stringSQL = "UPDATE CHITIETLUONGNV NgayLamViec=? WHERE MaLuongNV=? AND MaCLV=?) ";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            
            statement.setInt(2, ct.getLuongNV().getMaLuongNV());
            statement.setString(3, ct.getCaLamViec().getMaCLV());
            statement.setString(1, ct.getNgayLamViec().format(formatter));
            

            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    
    public int delete(ChiTietLuongNV ct) {
        try {
            String stringSQL = "DELETE CHITIETLUONGNV WHERE MaLuongNV=? AND MaCLV=? AND NgayLamViec=?) ";

            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            
            statement.setInt(1, ct.getLuongNV().getMaLuongNV());
            statement.setString(2, ct.getCaLamViec().getMaCLV());
            statement.setString(3, ct.getNgayLamViec().format(formatter));
            

            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }
    
    public List<ChiTietLuongNV> getAll() {
        List<ChiTietLuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM CHITIETLUONGNV";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);
            
            while (rs.next()) {
                ChiTietLuongNV ct = new ChiTietLuongNV();
                
                LuongNVDAO lnvDAO = new LuongNVDAO();
                LuongNV lnv = new LuongNV();
                lnv = lnvDAO.getLuongNVByID(rs.getInt(1));
                ct.setLuongNV(lnv);
                
                CaLamViecDAO clvDAO = new CaLamViecDAO();
                CaLamViec clv = new CaLamViec();
                clv = clvDAO.getCaLamViecByID(rs.getString(2));
                ct.setCaLamViec(clv);
                
                ct.setNgayLamViec(LocalDate.parse(rs.getString(3), formatter));
                
                list.add(ct);
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
    
    public List<ChiTietLuongNV> getCTLuongNVByMaNV(String maNV) {
        List<ChiTietLuongNV> list = new ArrayList<>();
        
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT CT.* FROM CHITIETLUONGNV CT INNER JOIN LUONGNV LNV ON CT.MaLuongNV = LNV.MaLuongNV WHERE LNV.MaNV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                ChiTietLuongNV ct = new ChiTietLuongNV();
                
                LuongNVDAO lnvDAO = new LuongNVDAO();
                LuongNV lnv = new LuongNV();
                lnv = lnvDAO.getLuongNVByID(rs.getInt(1));
                ct.setLuongNV(lnv);
                
                CaLamViecDAO clvDAO = new CaLamViecDAO();
                CaLamViec clv = new CaLamViec();
                clv = clvDAO.getCaLamViecByID(rs.getString(2));
                ct.setCaLamViec(clv);
                
                ct.setNgayLamViec(LocalDate.parse(rs.getString(3), formatter));
                
                list.add(ct);
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
}
