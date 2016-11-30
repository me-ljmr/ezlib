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
public class BorrowPool {
    private long borrowId;
    private Member member;
    private Copy bookCopy;
    private Date borrowedOn;
    private Date reservedOn;
    private Date returnedOn;
    private char status;
    private boolean allowedToShare; 

    /**
     * @return the borrowId
     */
    public long getBorrowId() {
        return borrowId;
    }

    /**
     * @param borrowId the borrowId to set
     */
    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    /**
     * @return the member
     */
    public Member getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * @return the bookCopy
     */
    public Copy getBookCopy() {
        return bookCopy;
    }

    /**
     * @param bookCopy the bookCopy to set
     */
    public void setBookCopy(Copy bookCopy) {
        this.bookCopy = bookCopy;
    }

    /**
     * @return the borrowedOn
     */
    public Date getBorrowedOn() {
        return borrowedOn;
    }

    /**
     * @param borrowedOn the borrowedOn to set
     */
    public void setBorrowedOn(Date borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    /**
     * @return the reservedOn
     */
    public Date getReservedOn() {
        return reservedOn;
    }

    /**
     * @param reservedOn the reservedOn to set
     */
    public void setReservedOn(Date reservedOn) {
        this.reservedOn = reservedOn;
    }

    /**
     * @return the returnedOn
     */
    public Date getReturnedOn() {
        return returnedOn;
    }

    /**
     * @param returnedOn the returnedOn to set
     */
    public void setReturnedOn(Date returnedOn) {
        this.returnedOn = returnedOn;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * @return the allowedToShare
     */
    public boolean isAllowedToShare() {
        return allowedToShare;
    }

    /**
     * @param allowedToShare the allowedToShare to set
     */
    public void setAllowedToShare(boolean allowedToShare) {
        this.allowedToShare = allowedToShare;
    }
    
    
}
