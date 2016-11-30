package ezlib.beans;


 
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujamanandhar
 */
public class Copy {
    private long copyId;
    private Book book;
    private String note;
    private char format;
    private String language;
    private int status;
    
    private Date addedOn;
    private Administrator addedBy;
    private Date updatedOn;
    private Administrator updatedBy; 
}
