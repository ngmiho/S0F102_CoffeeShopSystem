/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author Admin
 */
public class CaLamViec {
    String maCLV;
    LocalTime gioBD;
    LocalTime gioKT;

    public CaLamViec() {
    }

    public CaLamViec(String maCLV, LocalTime gioBD, LocalTime gioKT) {
        this.maCLV = maCLV;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
    }

    public String getMaCLV() {
        return maCLV;
    }

    public void setMaCLV(String maCLV) {
        this.maCLV = maCLV;
    }

    public LocalTime getGioBD() {
        return gioBD;
    }

    public void setGioBD(LocalTime gioBD) {
        this.gioBD = gioBD;
    }

    public LocalTime getGioKT() {
        return gioKT;
    }

    public void setGioKT(LocalTime gioKT) {
        this.gioKT = gioKT;
    }
    
    
}
