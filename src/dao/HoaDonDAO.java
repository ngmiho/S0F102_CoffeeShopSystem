/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {

    Connection con = null;
    PreparedStatement statement = null;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public int add(HoaDon hd) {
        try {
            String stringSQL = "INSERT INTO HOADON (MaHD, MaNV, MaKH, NgayHD, TongTien, TienKhachDua, TienThua) "
                    + "VALUES (?,?,?,?,?,?,?)";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            statement.setInt(1, hd.getId());
            statement.setString(2, hd.getNhanVien().getMaNV());

            if (hd.getKhachHang() == null) {
                statement.setString(3, null);
            } else {
                statement.setString(3, hd.getKhachHang().getMaKH());
            }

            statement.setString(4, sdf.format(hd.getNgayHD()));
            statement.setInt(5, hd.getTongTien());
            statement.setInt(6, hd.getTienKhachDua());
            statement.setInt(7, hd.getTienThua());

            if (statement.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }

    public int update(HoaDon hd) {
        try {
            String stringSQL = "UPDATE HOADON SET MaNV = ?, MaKH = ?, NgayHD = ?, TongTien = ?, TienKhachDua = ?, TienThua = ? WHERE MaHD = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            statement.setString(1, hd.getNhanVien().getMaNV());

            if (hd.getKhachHang() == null) {
                statement.setString(2, null);
            } else {
                statement.setString(2, hd.getKhachHang().getMaKH());
            }
            //statement.setString(2, hd.getKhachHang().getMaKH());
            statement.setString(3, sdf.format(hd.getNgayHD()));
            statement.setInt(4, hd.getTongTien());
            statement.setInt(5, hd.getTienKhachDua());
            statement.setInt(6, hd.getTienThua());
            statement.setInt(7, hd.getId());

            if (statement.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }

    public int delete(HoaDon hd) {
        try {
            String stringSQL = "DELETE HOADON WHERE MaHD = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);

            statement.setInt(1, hd.getId());

            if (statement.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }

    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();

        ResultSet rs = null;
        Statement sttm = null;

        try {
            String stringSQL = "SELECT * FROM HOADON";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(stringSQL);

            while (rs.next()) {
                HoaDon hd = new HoaDon();

                hd.setId(rs.getInt(1));

                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                /*for (NhanVien item : nvDAO.getAll()) {
                    if (item.getMaNV().equalsIgnoreCase(rs.getString(2))) {
                        nv = item;
                        break;
                    } 
                }*/
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                hd.setNhanVien(nv);

                KhachHangDAO khDAO = new KhachHangDAO();
                KhachHang kh = new KhachHang();
                /*for (KhachHang item : khDAO.getAll()) {
                    if (item.getMaKH().equalsIgnoreCase(String.valueOf(rs.getInt(3)))) {
                        kh = item;
                        break;
                    } else {
                        kh = null;
                    }
                }*/

                if (String.valueOf(rs.getInt(3)) == null) {
                    kh = null;
                } else {
                    kh = khDAO.findKhachHangByID(String.valueOf(rs.getInt(3)));
                }

                hd.setKhachHang(kh);

                hd.setNgayHD(sdf.parse(rs.getString(4)));
                hd.setTongTien(rs.getInt(5));
                hd.setTienKhachDua(rs.getInt(6));
                hd.setTienThua(rs.getInt(7));

                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
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

    public HoaDon getHoaDonByID(int maHD) {
        //List<HoaDon> list = new ArrayList<>();

        ResultSet rs = null;
        //Statement sttm = null;

        try {
            String stringSQL = "SELECT * FROM HOADON WHERE MaHD=?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setInt(1, maHD);
            rs = statement.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon();

                hd.setId(rs.getInt(1));

                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                /*for (NhanVien item : nvDAO.getAll()) {
                    if (item.getMaNV().equalsIgnoreCase(rs.getString(2))) {
                        nv = item;
                        break;
                    } 
                }*/
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                hd.setNhanVien(nv);

                KhachHangDAO khDAO = new KhachHangDAO();
                KhachHang kh = new KhachHang();
                /*for (KhachHang item : khDAO.getAll()) {
                    if (item.getMaKH().equalsIgnoreCase(String.valueOf(rs.getInt(3)))) {
                        kh = item;
                        break;
                    } else {
                        kh = null;
                    }
                }*/
                if (String.valueOf(rs.getInt(3)) == null) {
                    kh = null;
                } else {
                    kh = khDAO.findKhachHangByID(String.valueOf(rs.getInt(3)));
                }
                //kh = khDAO.findKhachHangByID(String.valueOf(rs.getInt(3)));
                hd.setKhachHang(kh);

                hd.setNgayHD(sdf.parse(rs.getString(4)));
                hd.setTongTien(rs.getInt(5));
                hd.setTienKhachDua(rs.getInt(6));
                hd.setTienThua(rs.getInt(7));

                return hd;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
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
    
    public List<HoaDon> getHoaDonByMaKH(int maKH) {
        List<HoaDon> list = new ArrayList<>();

        ResultSet rs = null;
        //Statement sttm = null;

        try {
            String stringSQL = "SELECT * FROM HOADON WHERE MaKH=?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setInt(1, maKH);
            rs = statement.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon();

                hd.setId(rs.getInt(1));

                NhanVienDAO nvDAO = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                /*for (NhanVien item : nvDAO.getAll()) {
                    if (item.getMaNV().equalsIgnoreCase(rs.getString(2))) {
                        nv = item;
                        break;
                    } 
                }*/
                nv = nvDAO.getNhanVienByID(rs.getString(2));
                hd.setNhanVien(nv);

                KhachHangDAO khDAO = new KhachHangDAO();
                KhachHang kh = new KhachHang();
                /*for (KhachHang item : khDAO.getAll()) {
                    if (item.getMaKH().equalsIgnoreCase(String.valueOf(rs.getInt(3)))) {
                        kh = item;
                        break;
                    } else {
                        kh = null;
                    }
                }*/
                if (String.valueOf(rs.getInt(3)) == null) {
                    kh = null;
                } else {
                    kh = khDAO.findKhachHangByID(String.valueOf(rs.getInt(3)));
                }
                //kh = khDAO.findKhachHangByID(String.valueOf(rs.getInt(3)));
                hd.setKhachHang(kh);

                hd.setNgayHD(sdf.parse(rs.getString(4)));
                hd.setTongTien(rs.getInt(5));
                hd.setTienKhachDua(rs.getInt(6));
                hd.setTienThua(rs.getInt(7));

                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
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
