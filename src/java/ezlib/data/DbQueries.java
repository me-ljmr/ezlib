/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Author;
import ezlib.beans.Book;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
     
    
    
     public void destroyConnection() throws EZException{
        try {
            if(!con.isClosed())
                con.close();
        } catch (SQLException ex) {
            throw new EZException(ex.getMessage());
        }
     }
    
    public void updateCategory(Category c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("update ezlib_categories set description=?, icon_number=? where category_id=?");
             pstmt.setString(1,c.getDescription());
         //    pstmt(2,c.getIcon());
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
    
    
     public List<Author> getAuthors() {

        List<Author> a = new ArrayList<Author>();
        Author aut = null;
        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("select * from ezlib_authors");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                aut = new Author();
                aut.setAuthorId(rs.getLong("author_id"));
                aut.setFirstName(rs.getString("first_name"));
                aut.setLastName(rs.getString("last_name"));

                a.add(aut);
            }

        } catch (SQLException ex) {
            a = null;
        } finally {
            return a;
        }

    }

    public void insertBook(Book b) throws EZException{
            
            //String ISBN, String title, String description, String coverImg, int pages, float price, int pubId, int catId, int pubYear, char bookType, int allowedForReservation, int autId) {

        // List<Author> a=new ArrayList<Author>();
        // Author aut=null;
        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("insert into EZLIB_BOOKS (ISBN,title,description,"
                    + "coverImage,PUBLISHER_ID,pages,likes,price,published_year,category_id,"
                    + "book_Type,allowed_For_Reservation)\n"
                    + "   values (?,?,?,?,?,?,?,?,?,?,?,?);");
            pstmt.setString(1,b.getISBN());
            pstmt.setString(2,b.getTitle());
            pstmt.setString(3,b.getDescription());
            pstmt.setString(4,b.getCoverImage());
            pstmt.setLong(5,b.getPublisherId());
            pstmt.setInt(6,b.getPages());
            pstmt.setInt(7, 0);
            pstmt.setDouble(8,b.getPrice());
            pstmt.setInt(9,b.getYear());
            pstmt.setLong(10,b.getCategoryId());
            pstmt.setString(11, Character.toString('e'));
            pstmt.setInt(12,2);
            
            

            pstmt.executeQuery();
           
            
             PreparedStatement pstmtAuthor;
            pstmtAuthor = con.prepareStatement("insert into EZLIB_BOOK_AUTHORS (isbn,author_id) \n" +
"   values (?,?);\n" +
"   ");
            pstmtAuthor.setString(1,b.getISBN());
            pstmtAuthor.setLong(2,b.getAuthorId());
           
            pstmtAuthor.executeQuery();
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Category> getCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
