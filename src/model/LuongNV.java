/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class LuongNV {
    int maLuongNV;
    NhanVien nhanVien;
    int tongCaLamViec;
    int tongTien;
    String kyLuong;

    public LuongNV() {
    }

    public LuongNV(int maLuongNV, NhanVien nhanVien, int tongCaLamViec, int tongTien, String kyLuong) {
        this.maLuongNV = maLuongNV;
        this.nhanVien = nhanVien;
        this.tongCaLamViec = tongCaLamViec;
        this.tongTien = tongTien;
        this.kyLuong = kyLuong;
    }

    public int getMaLuongNV() {
        return maLuongNV;
    }

    public void setMaLuongNV(int maLuongNV) {
        this.maLuongNV = maLuongNV;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getTongCaLamViec() {
        return tongCaLamViec;
    }

    public void setTongCaLamViec(int tongCaLamViec) {
        this.tongCaLamViec = tongCaLamViec;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getKyLuong() {
        return kyLuong;
    }

    public void setKyLuong(String kyLuong) {
        this.kyLuong = kyLuong;
    }
    
    
}
