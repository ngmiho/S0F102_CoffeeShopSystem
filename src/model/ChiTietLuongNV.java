/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class ChiTietLuongNV {

    private LuongNV luongNV;
    private CaLamViec caLamViec;
    private LocalDate ngayLamViec;

    public ChiTietLuongNV(LuongNV luongNV, CaLamViec caLamViec, LocalDate ngayLamViec) {
        this.luongNV = luongNV;
        this.caLamViec = caLamViec;
        this.ngayLamViec = ngayLamViec;
    }

    public ChiTietLuongNV() {
    }

    public LuongNV getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(LuongNV luongNV) {
        this.luongNV = luongNV;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public LocalDate getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(LocalDate ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

}
