package ezlib.beans;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujamanandhar
 */
public class Book {
    private String ISBN;
    private String title;
    private String description;
    private String coverImage;
    private Publisher publisher;
    private ArrayList<Author> authors;
    private int pages;
    private ArrayList<Tag> tags;
    private String bookType;
    private File file;
    private Long categoryId;
    private Long publisherId;
    private List<Long> authorId;
    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAllowedForReservation() {
        return allowedForReservation;
    }

    public void setAllowedForReservation(int allowedForReservation) {
        this.allowedForReservation = allowedForReservation;
    }
    private int likes;
    private int rating;
    private double price;
    private int year;
    private Category category;
   
    private int allowedForReservation;

    /**
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the publisherId
     */
    public Long getPublisherId() {
        return publisherId;
    }

    /**
     * @param publisherId the publisherId to set
     */
    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * @return the authorId
     */
    public List<Long> getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(List<Long> authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the bookType
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * @param bookType the bookType to set
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    
}
