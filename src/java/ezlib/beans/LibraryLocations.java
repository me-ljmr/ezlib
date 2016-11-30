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
public class LibraryLocations {
    private long locationId;
    //private MapInfo map;
    private String title;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private float longitude;
    private float latitude;
    private String contactNumber;
    private String[] openHours;// 0 index being sunday 

    public LibraryLocations(){
        openHours = new String[7];
    }
    /**
     * @return the locationId
     */
    public long getLocationId() {
        return locationId;
       
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
    
    public void setAddress(String streetAddress, String city,String province,String postal, String country){
        this.setAddress(streetAddress);
        this.setCity(city);
        this.setProvince(province);
        this.setCountry(country);
        this.setPostalCode(postal);
    }
    

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
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
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the WorkingHours
     */
    public String[] getOpenHours() {
        return openHours;
    }

    /**
     * @param WorkingHours the WorkingHours to set
     */
    public void setOpenhours(String[] openHours) {
        this.openHours=openHours;
    }
    
    public void addOpenHour(int dayIndex,String hours){
        this.openHours[dayIndex] = hours;
    }

    /**
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

     
   
     
    
    
    
    
}
