/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDon;
import model.DoUong;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonDAO {

    Connection con = null;
    PreparedStatement statement = null;

    public int add(ChiTietHoaDon hd) {
        try {
            String stringSQL = "INSERT INTO CHITIETHOADON (MaDU, MaHD, SoLuong, GhiChu) "
                    + "VALUES (?,?,?,?)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, hd.getDoUong().getMaDU());
            statement.setInt(2, (int) hd.getHoaDon().getId());
            statement.setInt(3, hd.getSoLuong());
            statement.setString(4, hd.getGhiChu());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(ChiTietHoaDon hd) {
        try {
            String stringSQL = "UPDATE CHITIETHOADON SET SoLuong = ?, GhiChu = ? WHERE MaDU = ? AND MaHD = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            
            statement.setInt(1, hd.getSoLuong());
            statement.setString(2, hd.getGhiChu());
            statement.setInt(3, hd.getDoUong().getMaDU());
            statement.setInt(4, (int) hd.getHoaDon().getId());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(ChiTietHoaDon hd) {
        try {
            String stringSQL = "DELETE CHITIETHOADON WHERE MaDU = ? AND MaHD = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            
            statement.setInt(1, hd.getDoUong().getMaDU());
            statement.setInt(2, (int) hd.getHoaDon().getId());
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<ChiTietHoaDon> getCTHDByMaHD(int maHD) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        //Statement sttm = null;
        
        try {
            String stringSQL = "SELECT * FROM CHITIETHOADON WHERE MaHD = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, String.valueOf(maHD));
            rs = statement.executeQuery();
            
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                
                DoUongDAO duDAO = new DoUongDAO();
                DoUong du = new DoUong();
                /*for (DoUong item : duDAO.getAll()) {
                    if (item.getMaDU() == rs.getInt(1)) {
                        du = item;
                        break;
                    }
                }*/
                du = duDAO.getDoUongByID(rs.getInt(1));
                cthd.setDoUong(du);
                
                HoaDonDAO hdDAO = new HoaDonDAO();
                HoaDon hd = new HoaDon();
                /*for (HoaDon item : hdDAO.getAll()) {
                    if (item.getId() == rs.getInt(2)) {
                        hd = item;
                        break;
                    }
                }*/
                hd = hdDAO.getHoaDonByID(rs.getInt(2));
                cthd.setHoaDon(hd);
                
                cthd.setSoLuong(rs.getInt(3));
                cthd.setGhiChu(rs.getString(4));
                
                list.add(cthd);
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
        
        return list;
    }
        
}
