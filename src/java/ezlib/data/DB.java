/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.exception.EZException;
import javax.sql.*;
import java.sql.*;
import javax.naming.*; 

/**
 *
 * @author SAUMIL
 * @modified by Luja 
 */
public class DB {
 
    private static DataSource ds;
     
    public static Connection getConnection() throws EZException{
        try{
            Context ctx = new InitialContext(); 
            ds = (DataSource) ctx.lookup("jdbc/myDatasource");
        }catch(NamingException nex){
            throw new EZException(nex.getMessage());
        }
        finally{
            try{
                return ds.getConnection("n01128805","oracle");
            }catch(SQLException ex){
                throw new EZException(ex.getMessage());
            }
        }
        
    } 
    public static void destroy(){
         ds = null;
    }
    
}
