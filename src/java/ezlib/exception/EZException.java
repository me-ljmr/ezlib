/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.exception;

/**
 *
 * @author Luja Manandhar 
 */
public class EZException extends Exception{
    
    private int messageType;
    public int getMessagetype(){
        return this.messageType;
    }
    public EZException(String message){
        super(message);
        this.messageType=1;
                 
        
 
        
    }
    public EZException(String message, int messageType){
        super(message);
        this.messageType = messageType;
        
  
    }
    
    public String getMessage(){
        return super.getMessage();
    }
    
}
