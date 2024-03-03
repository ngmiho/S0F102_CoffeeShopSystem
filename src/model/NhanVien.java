/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String maNV;
    private String tenNV, DiaChi, SDT, ChucVu;
    private boolean gioiTinh, phanQuyen;
    private String matKhau, hinhAnh;
    private int luongTheoCa;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String DiaChi, String SDT, String ChucVu, boolean gioiTinh, boolean phanQuyen, String matKhau, String hinhAnh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.ChucVu = ChucVu;
        this.gioiTinh = gioiTinh;
        this.phanQuyen = phanQuyen;
        this.matKhau = matKhau;
        this.hinhAnh = hinhAnh;
    }

    public NhanVien(String maNV, boolean phanQuyen, String matKhau) {
        this.maNV = maNV;
        this.phanQuyen = phanQuyen;
        this.matKhau = matKhau;
    }
    
    

    public NhanVien(String maNV, String tenNV, String DiaChi, String SDT, String ChucVu, boolean gioiTinh, boolean phanQuyen, String matKhau, String hinhAnh, int luongTheoCa) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.ChucVu = ChucVu;
        this.gioiTinh = gioiTinh;
        this.phanQuyen = phanQuyen;
        this.matKhau = matKhau;
        this.hinhAnh = hinhAnh;
        this.luongTheoCa = luongTheoCa;
    }

    
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(boolean phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getLuongTheoCa() {
        return luongTheoCa;
    }

    public void setLuongTheoCa(int luongTheoCa) {
        this.luongTheoCa = luongTheoCa;
    }

    
    
    
}
