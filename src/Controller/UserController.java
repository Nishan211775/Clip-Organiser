/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Admin;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class UserController extends User{
    private final Database db;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public UserController() {
        super();
        
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAccount(User a) {
        
        String sql = "";
        int res = 0;
        
        try {
            sql = "INSERT INTO user(`user_id`, `first_name`, `last_name`, `user_name`, `password`) VALUES(NULL, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, a.getFirstName());
            pst.setString(2, a.getLastName());
            pst.setString(3, a.getUserName());
            pst.setString(4, a.getPassword());
            
            res = pst.executeUpdate();
            con.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public boolean checkLogin(User a) {
        String sql = "";
        boolean res = false;
        
        try {
            sql = "SELECT * FROM user WHERE user_name = ? and password = ?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, a.getUserName());
            pst.setString(2, a.getPassword());
            
            rs = pst.executeQuery();
            
            while(rs.next()) {
                res = true;
            }
            
            //con.close();
            
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ResultSet getUserInfo(String email, String password) {
        
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "SELECT * FROM user where user_name = ? and password = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            
            res = pst.executeQuery();
            
            while (res.next()) {
                return res;
            }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
}
