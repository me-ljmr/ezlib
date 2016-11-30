package ezlib.beans;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujamanandhar
 */
public class Shelf {
    private long shelfId;
    private String shelfCode;
    private ArrayList<Book> books;

    /**
     * @return the shelfId
     */
    public long getShelfId() {
        return shelfId;
    }

    /**
     * @param shelfId the shelfId to set
     */
    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    /**
     * @return the shelfCode
     */
    public String getShelfCode() {
        return shelfCode;
    }

    /**
     * @param shelfCode the shelfCode to set
     */
    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    /**
     * @return the books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book){
        this.books.add(book);
    }
    
    
}
