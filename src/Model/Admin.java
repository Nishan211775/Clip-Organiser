/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Admin {
    private int adminId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    
    public int getAdminId() {
        return adminId;
    }
    
    public void setFristName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    
    public String getUserName() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }    
    
}
