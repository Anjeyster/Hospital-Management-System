/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author anjet
 */
public class AdmitPatient {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected int id;
    protected int patient_id;
    protected String reason;
    protected String recomended_by;
    protected int consultant;
    protected String ward;
    protected int leading_doctor;
    protected String admitted_on;
    protected String discharged_on;
    
    public AdmitPatient(){
       
    }
  

    public AdmitPatient(int patient_id, String reason, String recomended_by, int consultant, String ward, int leading_doctor) {
        
        this.patient_id = patient_id;
        this.reason = reason;
        this.recomended_by = recomended_by;
        this.consultant = consultant;
        this.ward = ward;
        this.leading_doctor = leading_doctor;
    }
    
    public void admit(){
        con  = MySqlConnect.ConnectDB();
        String sql = "INSERT INTO `patient_admit`(`patient_id`, `reason`, `recomended_by`, `consultant`, `ward`, `leading_doctor`, `admitted_on`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, this.patient_id);
            pst.setString(2, this.reason);
            pst.setString(3, this.recomended_by);
            pst.setInt(4, this.consultant);
            pst.setString(5, this.ward);       
            pst.setInt(6, this.leading_doctor);
            
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            
            this.admitted_on = timeStamp;
            
            pst.setString(7, timeStamp);       
            
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
    }
    
}
