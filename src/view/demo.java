/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.ChiTietLuongNVDAO;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietLuongNV;

/**
 *
 * @author Admin
 */
public class demo {

    public static void main(String[] args) {
        LocalTime time1 = LocalTime.now();
        String timeString1 = time1.toString();
        System.out.println("timeString1: " + timeString1);

        LocalTime time2 = LocalTime.of(23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString2 = time2.format(formatter);
        System.out.println("timeString2: " + timeString2);

        int result = time1.compareTo(time2);
        System.out.println("Result = " + result);

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        System.out.println("Day: " + day + ", Month: " + month + ", Year: " + year);
        String kyLuong = "" + month + year;
        System.out.println("Ky luong: " + kyLuong);
        
        ChiTietLuongNVDAO ctDAO = new ChiTietLuongNVDAO();
        List<ChiTietLuongNV> list = new ArrayList<>();
        
        list = ctDAO.getAll();
        
        for (ChiTietLuongNV ct : list) {
            System.out.println("MaLuongNV: " + ct.getLuongNV().getMaLuongNV());
            System.out.println("MaCLV: " + ct.getCaLamViec().getMaCLV());
            System.out.println("NgayLamViec: " + ct.getNgayLamViec());
        }
    }
}
