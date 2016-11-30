/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

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
     
    public static Connection getConnection() throws SQLException, NamingException{
        Context ctx = new InitialContext(); 
        ds = (DataSource) ctx.lookup("jdbc/myDatasource");
          
        return ds.getConnection("n01128805","oracle");
    } 
    
}
