/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.NhanVienDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAO {
    
    List<User> listUser = new ArrayList<>();

    public UserDAO() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        
        for (NhanVien nv : nvDAO.getAll()) {
            listUser.add(new User(nv.getMaNV(), nv.getMatKhau(), nv.isPhanQuyen()));
        }
        
        listUser.add(new User("admin", "123456", true));
        listUser.add(new User("user", "123456", false));
        
    }
    
    public List<User> getListUser() {
        return listUser;
    }
    
    public boolean checkLogin(String username, String password) {
        for (User user : listUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    }
}
