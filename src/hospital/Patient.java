/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author anjet
 */
public class Patient {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected int id;
    protected String name; 
    protected String address; 
    protected String phone; 
    protected String nic; 
    protected String email;
    protected boolean isAdmitted; 
    protected String emergency_contact; 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsAdmitted() {
        return isAdmitted;
    }

    public void setIsAdmitted(boolean isAdmitted) {
        this.isAdmitted = isAdmitted;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    
    
    
    public Patient(){
        
    }
    
    public Patient(int id){
        this.id = id;
        
        con  = MySqlConnect.ConnectDB();
        String sql = "SELECT * FROM patient where id = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, this.id);
            rs = pst.executeQuery();        
            
            if(rs.next()){
                this.id = rs.getInt(1);
                this.name = rs.getString(2);
                this.address = rs.getString(3);
                this.phone = rs.getString(4);
                this.nic = rs.getString(5);
                this.email = rs.getString(6);
                this.isAdmitted = rs.getBoolean(7);
                this.emergency_contact = rs.getString(8);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public Patient(String name, String address, String phone, String nic, String email, String emergency_contact){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        this.isAdmitted = isAdmitted;
        this.emergency_contact = emergency_contact;
    }
    
    public void savePatient(){
        con  = MySqlConnect.ConnectDB();
        String sql = "INSERT INTO `patient`(`name`, `address`, `phone`, `nic`, `email`, `emergency_contact`) VALUES  (?, ?, ?, ?, ?, ?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.name);
            pst.setString(2, this.address);
            pst.setString(3, this.phone);
            pst.setString(4, this.nic);
            pst.setString(5, this.email);       
            pst.setString(6, this.emergency_contact);
            
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                this.id = rs.getInt(1);
//                return this;
            }
            
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
              
//        return this;
    }
    
    
}
