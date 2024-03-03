/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class TestDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseHelper.getDBConnect();
        KhachHangDAO dao = new KhachHangDAO();
        DatabaseMetaData metadata = con.getMetaData();
        
        if (con != null) {
            System.out.println("Connect thành công");
            System.out.println("Database Name: " + metadata.getDatabaseProductVersion());
            
            // Add khách hàng
            //KhachHang kh1 = new KhachHang("07", "Nguyễn Văn Em", "Đà Lạt", "0123456785");
            //dao.add(kh1);
            //dao.update(kh1);
            //dao.delete(kh1);
            
            for (KhachHang kh : dao.getAll()) {
                System.out.println(kh.toString());
            }
            
            KhachHang khTim = dao.findKhachHangByID("1");
            if (khTim != null) {
                System.out.println("Tim thay khach hang");
                System.out.println(khTim.toString());
            }
        } else {
            System.out.println("Connect thất bại");
        }
    }
}
