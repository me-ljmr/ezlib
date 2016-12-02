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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
public class BookDAO {
   private Connection con;
   
    public BookDAO(Connection con){
        this.con = con;
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
}
