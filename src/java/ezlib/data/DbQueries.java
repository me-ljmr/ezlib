/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Category;
import ezlib.beans.Publisher;
import ezlib.exception.EZException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author SAUMIL
 */
public class DbQueries implements Serializable{
    private Connection con;
     private String errorMessage;
     private boolean errorOcc;
     public boolean hasErrorOccurred(){
         return errorOcc;
     }
    public DbQueries(){
        
        errorOcc = false; 
        errorMessage = "";
        try {
             con = DB.getConnection();
              
         } catch (SQLException ex) { 
             errorMessage = "Some SQL Related Error";
             errorMessage += ex.getMessage();
            errorOcc = true;
            
         } catch (NamingException ex) { 
             errorMessage = "Error with initial Context"; 
             errorOcc = true;
         } 
    }
     
    public List<Category> getCategories(){
    
        List<Category> c=new ArrayList<Category>();
        Category cat=null;
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_categories");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 cat = new Category();
                 cat.setCategoryId(rs.getLong("category_id"));
                 cat.setDescription(rs.getString("description"));
                 cat.setIcon(rs.getInt("icon_number"));
                 c.add(cat);
             }
             
         } catch (SQLException ex) {
              c=null;
         }
         finally{
             return c;
         }
             
    
    }
    public Category getCategory(long id){
       Category c =null;
        try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_categories where category_id=?");
             pstmt.setLong(1, id);
             
             ResultSet rs =pstmt.executeQuery(); 
            c = new Category();
            c.setCategoryId(id);
            while(rs.next()){
                c.setDescription(rs.getString("description"));

                c.setIcon(rs.getInt("icon_number"));
            } 
             
         } catch (SQLException ex) {
              c=null;
         }
         finally{
             return c;
         }
    }
    public String[] getAllCategoryNames() {
        String[] c=new String[]{};
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_categories");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 c[c.length] = rs.getString("description");
             }
             
         } catch (SQLException ex) {
              c=null;
         }
         finally{
             return c;
         }
    }
    public void saveCategory(Category c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("insert into ezlib_categories (description, icon_number) values(?,?)");
             pstmt.setString(1,c.getDescription());
             pstmt.setLong(2,c.getIcon());
              pstmt.executeUpdate();
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    
    public void updateCategory(Category c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("update ezlib_categories set description=?, icon_number=? where category_id=?");
             pstmt.setString(1,c.getDescription());
             pstmt.setLong(2,c.getIcon());
             pstmt.setLong(3,c.getCategoryId());
              pstmt.executeUpdate();
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
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
