/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formdangky;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 84377
 */
public class TestDate {

    public static Date parse(String chuoi, String mau) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern(mau);
            Date d = format.parse(chuoi);
            return d;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
