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

    public void insertBook(Book b) throws EZException {

        //String ISBN, String title, String description, String coverImg, int pages, float price, int pubId, int catId, int pubYear, char bookType, int allowedForReservation, int autId) {
        // List<Author> a=new ArrayList<Author>();
        // Author aut=null;
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//
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
        //}
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

            //     for(<String> i = someList.iterator(); i.hasNext(); ) {
            //String item = i.next();
            //System.out.println(item);
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
