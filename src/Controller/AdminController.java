/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.Database;
import Model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class AdminController extends Admin{
    
    private final Database db;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public AdminController() {
        super();
        
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAccount(Admin a) {
        
        String sql = "";
        int res = 0;
        
        try {
            sql = "INSERT INTO admin(`admin_id`, `first_name`, `last_name`, `user_name`, `password`) VALUES(NULL, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, a.getFirstName());
            pst.setString(2, a.getLastName());
            pst.setString(3, a.getUserName());
            pst.setString(4, a.getPassword());
            
            res = pst.executeUpdate();
            con.close();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public boolean checkLogin(Admin a) {
        String sql = "";
        boolean res = false;
        
        try {
            sql = "SELECT * FROM admin WHERE user_name = ? and password = ?";
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
    
    public ResultSet getUserInfo(String username, String password) {
        
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "SELECT * FROM admin where user_name = ? and password = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
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
    
    public ResultSet getClips() {
        String sql = null;
        ResultSet res = null;
        
        try {
            sql = "select * from clips";
            pst = con.prepareStatement(sql);
            
            res = pst.executeQuery();
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
}
