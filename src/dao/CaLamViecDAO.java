/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import model.CaLamViec;

/**
 *
 * @author Admin
 */
public class CaLamViecDAO {

    Connection con = null;
    PreparedStatement statement = null;

    public CaLamViec getCaLamViecByID(String maCLV) {
        ResultSet rs = null;

        try {
            String stringSQL = "SELECT * FROM CALAMVIEC WHERE MaCLV = ?";
            con = DatabaseHelper.getDBConnect();
            statement = con.prepareStatement(stringSQL);
            statement.setString(1, maCLV);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                CaLamViec clv = new CaLamViec();
                
                clv.setMaCLV(rs.getString(1));
                clv.setGioBD(LocalTime.parse(rs.getString(2)));
                clv.setGioKT(LocalTime.parse(rs.getString(3)));
                
                return clv;
            }
        } catch (Exception e) {
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
}
