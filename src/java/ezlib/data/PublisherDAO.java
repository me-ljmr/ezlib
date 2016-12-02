/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Publisher;
import ezlib.exception.EZException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAUMIL
 */
public class PublisherDAO {
  private Connection con;
    public PublisherDAO(Connection con){
        this.con = con;
    }  
    
     public void updatePublisher(Publisher p) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("update ezlib_publishers set publisher_name=?,address=?,contact_person=?,contact_number=? where publisher_id=?");
             pstmt.setString(1,p.getPublisherName());
             pstmt.setString(2,p.getAddress());
             pstmt.setString(3,p.getContactPerson());
                          pstmt.setString(4,p.getContactNumber());
                          pstmt.setLong(5,p.getPublisherId());
              pstmt.executeUpdate();
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    
     public List<Publisher> getPublishers(){
    
        List<Publisher> p=new ArrayList<Publisher>();
        Publisher pub=null;
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_publishers");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 pub = new Publisher();
                 pub.setPublisherId(rs.getLong("publisher_id"));
                  pub.setPublisherName(rs.getString("publisher_name"));
                 pub.setAddress(rs.getString("address"));
                 pub.setContactPerson(rs.getString("contact_person"));
                 pub.setContactNumber(rs.getString("contact_number"));
                 p.add(pub);
             }
             
         } catch (SQLException ex) {
              p=null;
         }
         finally{
             return p;
         }
             
    
    }
    public Publisher getPublisher(long id){
       Publisher p =null;
        try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_publishers where publisher_id=?");
             pstmt.setLong(1, id);
             
             ResultSet rs =pstmt.executeQuery(); 
            p = new Publisher();
            p.setPublisherId(id);
            while(rs.next()){
                p.setPublisherName(rs.getString("publisher_name"));
                p.setAddress(rs.getString("address"));

                 p.setContactPerson(rs.getString("contact_person"));
                 p.setContactNumber(rs.getString("contact_number"));
            } 
             
         } catch (SQLException ex) {
              p=null;
         }
         finally{
             return p;
         }
    }
    public String[] getAllPublisherNames() {
        String[] p=new String[]{};
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_publishers");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 p[p.length] = rs.getString("publisher_name");
             }
             
         } catch (SQLException ex) {
              p=null;
         }
         finally{
             return p;
         }
    }
    public void savePublisher(Publisher p) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("insert into ezlib_publishers (publisher_name,address,contact_person,contact_number) values(?,?,?,?)");
            
            pstmt.setString(1,p.getPublisherName());
             pstmt.setString(2,p.getAddress());
             pstmt.setString(3,p.getContactPerson());
                          pstmt.setString(4,p.getContactNumber());
                         
              pstmt.executeUpdate();
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    
    
}
