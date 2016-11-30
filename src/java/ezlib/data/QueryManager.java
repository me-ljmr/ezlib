/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Category;
import ezlib.common.TypeChecker;
import ezlib.exception.EZException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lujamanandhar
 */


public class QueryManager {
    private Connection con;
    public QueryManager(Connection con){
        this.con = con;
    }
    public ResultSet getRecords(String selectString) throws EZException{
        try {
            Statement stmt = null;
            ResultSet rs = null;

            stmt = con.createStatement();
            rs = stmt.executeQuery(selectString);
            return rs;
        } catch (SQLException ex) {
            throw new EZException(ex.getMessage());
        }  
            
    }
    public void execute(String sqlString) throws EZException{
        try {
            if (con == null) {
                throw new EZException("Database is not connected");
            }

            Statement stmt = null;
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);

        } catch (SQLException ex) {
            throw new EZException(ex.getMessage());
        }

    }
    public int execute(String sqlString, Object[] params){
        int c=0;
        try 
        {
            String s;
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(sqlString);
            for(int i=1;i<params.length;i++){
                s = params[i-1].getClass().getName();
                System.out.println(s);
                switch(params[i-1].getClass().getName()){
                    
                }
            }
             
            c = pstmt.executeUpdate();
             
        } catch (SQLException ex) {
             c=0;
        }
        finally{
            return c;
        }
    }
}
