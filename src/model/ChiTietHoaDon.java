/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon {
    private DoUong doUong;
    private HoaDon hoaDon;
    private int soLuong;
    private String ghiChu;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(DoUong doUong, HoaDon hoaDon, int soLuong, String ghiChu) {
        this.doUong = doUong;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public DoUong getDoUong() {
        return doUong;
    }

    public void setDoUong(DoUong doUong) {
        this.doUong = doUong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "doUong=" + doUong + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", ghiChu=" + ghiChu + '}';
    }
    
    
}
