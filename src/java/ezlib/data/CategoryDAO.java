/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Category;
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
public class CategoryDAO {
    private Connection con;
    public CategoryDAO(Connection con){
        this.con = con;
    }
    public List<Category> getCategories(){
    
        List<Category> c=new ArrayList<Category>();
        Category cat=null;
        Icon icon = null;
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select cat.*,icn.title as icon_title,icn.file_name from ezlib_categories cat inner join ezlib_icons icn on cat.icon_number =icn.icon_number");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 cat = new Category();
                 cat.setCategoryId(rs.getLong("category_id"));
                 cat.setDescription(rs.getString("description"));
                 icon = new Icon();
                 icon.setFileName(rs.getString("file_name"));
                 icon.setIconNumber(rs.getInt("icon_number"));
                 icon.setIconTitle(rs.getString("icon_title"));
                 
                 cat.setIcon(icon);
                 c.add(cat);
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
    public Category getCategory(long id){
       Category c =null;
        try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select cat.*,icn.title as icon_title,icn.file_name from ezlib_categories cat inner join ezlib_icons icn on cat.icon_number =icn.icon_number where category_id=?");
             pstmt.setLong(1, id);
             Icon icon=null; 
             ResultSet rs =pstmt.executeQuery(); 
            c = new Category();
            c.setCategoryId(id);
            while(rs.next()){
                c.setDescription(rs.getString("description")); 
                icon = new Icon();
                icon.setFileName(rs.getString("file_name"));
                icon.setIconNumber(rs.getInt("icon_number"));
                icon.setIconTitle(rs.getString("icon_title"));

                c.setIcon(icon);
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
     
     
    public void saveCategory(Category c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("insert into ezlib_categories (description, icon_number) values(?,?)");
             pstmt.setString(1,c.getDescription());
             pstmt.setLong(2,c.getIcon().getIconNumber());
              pstmt.executeUpdate();
               
             pstmt.close(); 
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
    
    public void updateCategory(Category c) throws EZException{
         
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("update ezlib_categories set description=?, icon_number=? where category_id=?");
             pstmt.setString(1,c.getDescription());
             pstmt.setLong(2,c.getIcon().getIconNumber());
             pstmt.setLong(3,c.getCategoryId());
              pstmt.executeUpdate();
              
              
             pstmt.close(); 
             
         } catch (SQLException ex) {
               throw new ezlib.exception.EZException(ex.getMessage());
         } 
    }
}
