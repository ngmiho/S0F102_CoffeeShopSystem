/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class DoUong {
    private int maDU;
    private String tenDU;
    private int giaDU;
    private String hinhAnh;
    private boolean trangThai;

    public DoUong() {
    }

    public DoUong(int maDU, String tenDU, int giaDU, String hinhAnh, boolean trangThai) {
        this.maDU = maDU;
        this.tenDU = tenDU;
        this.giaDU = giaDU;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public int getMaDU() {
        return maDU;
    }

    public void setMaDU(int maDU) {
        this.maDU = maDU;
    }

    public String getTenDU() {
        return tenDU;
    }

    public void setTenDU(String tenDU) {
        this.tenDU = tenDU;
    }

    public int getGiaDU() {
        return giaDU;
    }

    public void setGiaDU(int giaDU) {
        this.giaDU = giaDU;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DoUong{" + "maDU=" + maDU + ", tenDU=" + tenDU + ", giaDU=" + giaDU + ", hinhAnh=" + hinhAnh + ", trangThai=" + trangThai + '}';
    }
    
    
    
    
}
