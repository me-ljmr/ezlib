/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Author;
import ezlib.beans.Book;
import ezlib.beans.Category;
import ezlib.beans.Icon;
import ezlib.beans.Publisher;
import ezlib.exception.EZException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
public class BookDAO {

    private Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

    public List<Book> getBooks() {
        List<Book> b = new ArrayList<Book>();
        Book book = null;
        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("select * from ezlib_Books");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setISBN(rs.getString("ISBN"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setCoverImage(rs.getString("coverimage"));
                book.setPublisherId(rs.getLong("publisher_id"));
                book.setPages(rs.getInt("pages"));
                book.setLikes(rs.getInt("likes"));
                book.setPrice(rs.getDouble("price"));
                book.setYear(rs.getInt("published_year"));
                book.setCategoryId(rs.getLong("category_id"));
                book.setBookType(rs.getString("book_type"));
                b.add(book);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            b = null;
        } finally {
            return b;
        }
    }

//    public Publisher getPublisher(long id){
//       Publisher p =null;
//        try {
//             PreparedStatement pstmt;
//             pstmt = con.prepareStatement("select * from ezlib_publishers where publisher_id=?");
//             pstmt.setLong(1, id);
//             
//             ResultSet rs =pstmt.executeQuery(); 
//            p = new Publisher();
//            p.setPublisherId(id);
//            while(rs.next()){
//                p.setPublisherName(rs.getString("publisher_name"));
//                p.setAddress(rs.getString("address"));
//
//                 p.setContactPerson(rs.getString("contact_person"));
//                 p.setContactNumber(rs.getString("contact_number"));
//            } 
//             
//         } catch (SQLException ex) {
//              p=null;
//         }
//         finally{
//             return p;
//         }
//    }
    public Book getBook(String isbn) {

        Book book = null;
        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("select * from ezlib_Books where isbn=?");
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            book = new Book();
            book.setISBN(isbn);
            while (rs.next()) {

                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setCoverImage(rs.getString("coverimage"));
                book.setPublisherId(rs.getLong("publisher_id"));
                book.setPages(rs.getInt("pages"));
                book.setLikes(rs.getInt("likes"));
                book.setPrice(rs.getDouble("price"));
                book.setYear(rs.getInt("published_year"));
                book.setCategoryId(rs.getLong("category_id"));
                book.setBookType(rs.getString("book_type"));

            }
            
        } catch (SQLException ex) {
            book = null;
        } finally {
            return book;
        }
    }

    public void updateBook(Book b) throws EZException {

        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("update ezlib_books set "
                    + "title=?,"
                    + "description=?,\n"
                    + "                    coverImage=?,\n"
                    + "                    PUBLISHER_ID=?,\n"
                    + "                    pages=?,\n"
                    + "                    likes=?,\n"
                    + "                    price=?,\n"
                    + "                    published_year=?,\n"
                    + "                    category_id=?,\n"
                    + "                    book_Type=?,\n"
                    + "                    allowed_For_Reservation=? where isbn=?");
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getDescription());
            pstmt.setString(3, b.getCoverImage());
            pstmt.setLong(4, b.getPublisherId());
            pstmt.setInt(5, b.getPages());
            pstmt.setInt(6, 0);
            pstmt.setDouble(7, b.getPrice());
            pstmt.setInt(8, b.getYear());
            pstmt.setLong(9, b.getCategoryId());
            pstmt.setString(10, b.getBookType());
            pstmt.setInt(11, b.getAllowedForReservation());
            pstmt.setString(12, b.getISBN());

            pstmt.executeQuery();
            List<Long> a = b.getAuthorId();

            for (Long i : a) {
                PreparedStatement pstmtAuthor;
                pstmtAuthor = con.prepareStatement("update EZLIB_BOOK_AUTHORS set author_id=? where isbn=? \n");

                pstmtAuthor.setLong(1, i);
                pstmtAuthor.setString(2, b.getISBN());

                pstmtAuthor.executeQuery();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void insertBook(Book b) throws EZException {

        //String ISBN, String title, String description, String coverImg, int pages, float price, int pubId, int catId, int pubYear, char bookType, int allowedForReservation, int autId) {
        // List<Author> a=new ArrayList<Author>();
        // Author aut=null;
//        File file=b.getFile();
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes;
//                bytes = file.getBytes();
//                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//                logger.info("Server File Location="
//                        + serverFile.getAbsolutePath());
//
//                return "You successfully uploaded file=" + name;
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
//        }
//        }
        try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("insert into EZLIB_BOOKS (ISBN,title,description,"
                    + "coverImage,PUBLISHER_ID,pages,likes,price,published_year,category_id,"
                    + "book_Type,allowed_For_Reservation)\n"
                    + "   values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, b.getISBN());
            pstmt.setString(2, b.getTitle());
            pstmt.setString(3, b.getDescription());
            pstmt.setString(4, b.getCoverImage());
            pstmt.setLong(5, b.getPublisherId());
            pstmt.setInt(6, b.getPages());
            pstmt.setInt(7, 0);
            pstmt.setDouble(8, b.getPrice());
            pstmt.setInt(9, b.getYear());
            pstmt.setLong(10, b.getCategoryId());
            pstmt.setString(11, b.getBookType());
            pstmt.setInt(12, b.getAllowedForReservation());

            pstmt.executeQuery();
            List<Long> a = b.getAuthorId();

            for (Long i : a) {
                PreparedStatement pstmtAuthor;
                pstmtAuthor = con.prepareStatement("insert into EZLIB_BOOK_AUTHORS (isbn,author_id) \n"
                        + "   values (?,?)\n");
                pstmtAuthor.setString(1, b.getISBN());
                pstmtAuthor.setLong(2, i);
                pstmtAuthor.executeQuery();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
