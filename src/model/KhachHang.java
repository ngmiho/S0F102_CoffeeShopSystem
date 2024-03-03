/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String maKH, tenKH, diaChiKH, sdtKH;

    public KhachHang() {
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String tenKH, String diaChiKH, String sdtKH) {
        this.tenKH = tenKH;
        this.diaChiKH = diaChiKH;
        this.sdtKH = sdtKH;
    }

    public KhachHang(String maKH, String tenKH, String diaChiKH, String sdtKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChiKH = diaChiKH;
        this.sdtKH = sdtKH;
    }
    
    

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", diaChiKH=" + diaChiKH + ", sdtKH=" + sdtKH + '}';
    }
    
    
}
