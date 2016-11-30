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
public class Author {
    private long authorId; 
    private String firstName;
    private String lastName;
    private ArrayList<Book> writtenBooks;
    
    
    private String getFullName(){
        return firstName.trim() + " " + lastName.trim();
    }
    /**
     * @return the authorId
     */
    public long getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the writtenBooks
     */
    public ArrayList<Book> getWrittenBooks() {
        return writtenBooks;
    }

    /**
     * @param writtenBooks the writtenBooks to set
     */
    public void setWrittenBooks(ArrayList<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }
    
    public void addBook(Book book){
        this.writtenBooks.add(book);
    }
    
    
}
