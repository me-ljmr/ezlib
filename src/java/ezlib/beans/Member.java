package ezlib.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujamanandhar
 */
public class Member extends User{
     private long memberId; 
     private String cellNumber;
     private String address;
     private String postalCode; 
     private double balance;
     
     private int libraryCardNumber;
private String verficationStatus;
private String confirmationCode;







    /**
     * @return the memberId
     */
    public long getMemberId() {
        return super.getUserId();
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(long memberId) {
        super.setUserId(memberId);
    } 

    /**
     * @return the cellNumber
     */
    public String getCellNumber() {
        return cellNumber;
    }

    /**
     * @param cellNumber the cellNumber to set
     */
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
 
    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the libraryCardNumber
     */
    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    /**
     * @param libraryCardNumber the libraryCardNumber to set
     */
    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    /**
     * @return the verficationStatus
     */
    public String getVerficationStatus() {
        return verficationStatus;
    }

    /**
     * @param verficationStatus the verficationStatus to set
     */
    public void setVerficationStatus(String verficationStatus) {
        this.verficationStatus = verficationStatus;
    }

    /**
     * @return the confirmationCode
     */
    public String getConfirmationCode() {
        return confirmationCode;
    }

    /**
     * @param confirmationCode the confirmationCode to set
     */
    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
     
}

