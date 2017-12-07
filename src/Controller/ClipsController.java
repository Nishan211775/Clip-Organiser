/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Clips;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClipsController extends Clips{
    private PreparedStatement pst;
    private final Database db;
    private final Connection con;
    
    public ClipsController() {
        super();
        
        db = new Database();
        con = db.getConnection();
    }
    
    public int addClips(Clips c) {
        int res = 0;
        String sql = "";
        
        
        try {
            sql = "INSERT INTO clips VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, c.getClipName());
            pst.setTime(2, c.getClipDuration());
            pst.setString(3, c.getClipType());
            pst.setBoolean(4, c.getAdvertisement());
            pst.setInt(5, c.getTimesPlayedAccrossStation());
            pst.setInt(6, c.getMaxTimeCanPlayedInCurrentStation());
            pst.setInt(7, c.getMinTimeMustPlayedInCurrentStation());
            pst.setString(8, c.getGenre());
            
            res = pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ResultSet getClipFullName() {
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "select clip_full_filename from clips";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public int updateClips(Clips c, int row) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "UPDATE clips SET clip_full_filename = ?, duration = ?, clip_type = ?"
                    + ", whether_it_is_advertising_or_not = ?, no_of_times_its_been_played_accross_station = ?"
                    + ", max_no_of_times_it_can_be_played_in_current_period =? ,"
                    + "min_no_of_times_it_must_be_played_in_current_period = ?, genre = ?"
                    + "where clip_id = "+row;
            
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getClipName());
            pst.setTime(2, c.getClipDuration());
            pst.setString(3, c.getClipType());
            pst.setBoolean(4, c.getAdvertisement());
            pst.setInt(5, c.getTimesPlayedAccrossStation());
            pst.setInt(6, c.getMaxTimeCanPlayedInCurrentStation());
            pst.setInt(7, c.getMinTimeMustPlayedInCurrentStation());
            pst.setString(8, c.getGenre());
            
            res = pst.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
         
        return res;
    }
    
    public int deleteClip(int row) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "delete from clips where clip_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, row);
            
            res = pst.executeUpdate();
                    
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return res;
    }
    
}
