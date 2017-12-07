/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Shows;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nishan
 */
public class ShowsController extends Shows{
    private final Database db;
    private final Connection con;
    private PreparedStatement pst;
    
    public ShowsController() {
        super();
        db = new Database();
        con = db.getConnection();
    } 
    
    public int addShows(Shows s) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "insert into shows values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getShowName());
            pst.setTime(2, s.getShowDuration());
            pst.setTime(3, s.getAudioDuration());
            pst.setTime(4, s.getVideoDuration());
            pst.setTime(5, s.getAdvertisingDuration());
            pst.setTime(6, s.getVoiceoverDuration());
            pst.setString(7, s.getAudioOrMultimedia());
            pst.setInt(8, s.getShowsRunsPerDay());
            pst.setString(9, s.getGenre());
            
            res = pst.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ResultSet getAllShows() {
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "select * from shows";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    public int updateShow(Shows s, int row) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "UPDATE shows SET show_name = ?, duration = ?, audio_duration = ?"
                    + ", video_duration = ?, advertising_duration = ?, voiceover_duration =? ,"
                    + "audioormultimedia = ?, shows_runs_per_day = ?, genre = ? where show_id = ? ";
            
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getShowName());
            pst.setTime(2, s.getShowDuration());
            pst.setTime(3, s.getAudioDuration());
            pst.setTime(4, s.getVideoDuration());
            pst.setTime(5, s.getAdvertisingDuration());
            pst.setTime(6, s.getVoiceoverDuration());
            pst.setString(7, s.getAudioOrMultimedia());
            pst.setInt(8, s.getShowsRunsPerDay());
            pst.setString(9, s.getGenre());
            pst.setInt(10, row);
            
            res = pst.executeUpdate();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    public int deleteShow(int row) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "delete from shows where show_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, row);
            
            res = pst.executeUpdate();
                    
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return res;
    }
    
    public ResultSet getShows() {
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "select show_name from shows";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    public ArrayList getShowsDetails(String showName) {
        ArrayList list = new ArrayList();
        String sql = "";
        ResultSet res = null;
        
        try {
            sql = "SELECT * FROM shows WHERE show_name=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, showName);
            res = pst.executeQuery();
            
            while(res.next()) {
                list.add(res.getTime(3));
                list.add(res.getTime(4));
                list.add(res.getTime(5));
                list.add(res.getTime(6));
                list.add(res.getTime(7));
                list.add(res.getString(8));
                list.add(res.getInt(9));
                list.add(res.getString(10));
            }
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
}
