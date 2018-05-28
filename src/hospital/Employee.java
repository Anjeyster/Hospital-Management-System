/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.*;

/**
 *
 * @author anjet
 */
public class Employee {
    
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected int id;
    protected String name; 
    protected String address; 
    protected String phone; 
    protected String nic; 
    protected String email; 
    protected String type; 
    protected String speciality; 

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    
    
    public Employee(String name, String address, String phone, String nic, String email, String type){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        this.type = type;
    }
    
    public Employee(String name, String address, String phone, String nic, String email, String type, String speciality){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        this.type = type;
        this.speciality = speciality;
    }
    
    public Employee(){
           
    }
    
    public void saveEmployee(){
        con  = MySqlConnect.ConnectDB();
        String sql = "INSERT INTO `employee`( `name`, `address`, `phone`, `nic`, `email`, `type`, `speciality`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.name);
            pst.setString(2, this.address);
            pst.setString(3, this.phone);
            pst.setString(4, this.nic);
            pst.setString(5, this.email);
            pst.setString(6, this.type);
            pst.setString(7, this.speciality);
            
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
