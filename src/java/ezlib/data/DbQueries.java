/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Category;
import ezlib.beans.Icon;
import ezlib.exception.EZException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author SAUMIL
 */
public class DbQueries implements Serializable{
    private Connection con;
     private String errorMessage;
     private boolean errorOcc;
     public boolean hasErrorOccurred(){
         return errorOcc;
     }
     
    
    
     public void destroyConnection() throws EZException{
        try {
            if(!con.isClosed())
                con.close();
        } catch (SQLException ex) {
            throw new EZException(ex.getMessage());
        }
     }
    
}
