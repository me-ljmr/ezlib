/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Author;
import ezlib.beans.Author;
import ezlib.beans.Icon;
import ezlib.exception.EZException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lujamanandhar
 */
public class AuthorDAO {
    private Connection con;
    public AuthorDAO(Connection con){
        this.con = con;
    }
    public List<Author> getAuthors(){
    
        List<Author> c=new ArrayList<Author>();
        Author author=null;
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * FROM EZLIB_AUTHORS");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 author = new Author();
                 author.setAuthorId(rs.getLong("author_id"));
                 author.setFirstName(rs.getString("first_name"));
                 author.setLastName(rs.getString("last_name"));
                 c.add(author);
             }
             rs.close();
             pstmt.close(); 
             
         } catch (SQLException ex) {
              c=null;
         }
         finally{
             return c;
         }
             
    
    }
    public Author getAuthor(long id){
       Author c =null;
        try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("Select * from ezlib_authors where author_id = ?");
             pstmt.setLong(1, id);
             Icon icon=null; 
            try (ResultSet rs = pstmt.executeQuery()) {
                c = new Author();
                c.setAuthorId(id);
                if(rs.next()){
                    c.setAuthorId(rs.getLong("author_id"));
                    c.setFirstName(rs.getString("first_name"));
                    c.setLastName(rs.getString("last_name"));

                }
            }
             pstmt.close(); 
             
         } catch (SQLException ex) {
              c=null;
         }
         finally{
             return c;
         }
    }
     
     
    public void saveAuthor(Author c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("insert into ezlib_authors (first_name, last_name) values(?,?)");
             pstmt.setString(1,c.getFirstName());
             pstmt.setString(2,c.getLastName());
              pstmt.executeUpdate();
               
             pstmt.close(); 
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    
    public void updateAuthor(Author c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("update ezlib_authors set first_name=?, last_name=? where author_id=?");
             pstmt.setString(1,c.getFirstName());
             pstmt.setString(2,c.getLastName());
             pstmt.setLong(3, c.getAuthorId());
              pstmt.executeUpdate();
              
              
             pstmt.close(); 
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    public void deleteAuthor(long id) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("delete from ezlib_authors where author_id=?");
 
             pstmt.setLong(1,id);
              pstmt.executeUpdate();
              
              
             pstmt.close(); 
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
}
