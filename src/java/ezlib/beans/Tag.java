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
public class Tag {
    private long tagId;
    private String tag;
    private ArrayList<Book> books;

    /**
     * @return the tagId
     */
    public long getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    /**
     * @return the book
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * @param books to set
     *  
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public void addBook(Book book){
        this.books.add(book);
    }
    
    
}
