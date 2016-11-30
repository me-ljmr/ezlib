/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data; 
import ezlib.exception.*;
import java.sql.*; 
/**
 *
 * @author Luja Manandhar
 * @purpose Connecting to the database, retrieving data from the tables and saving data to the database
 */
public class EZConnection {
    private String user;
	private String passwd;
	private String url;
        private Connection connection;
        private boolean isactive;
        
        public EZConnection(){
            this.isactive = false;
        }
	public Connection getConnection(){
            return connection;
        }
        public boolean isActive()  {
             
                return this.isactive;
             
        }
        public ResultSet getRecords(String selectString) throws EZException{
            try {
                Statement stmt = null;
                ResultSet rs = null;

                stmt = connection.createStatement();
                rs = stmt.executeQuery(selectString);
                return rs;
            } catch (SQLException ex) {
                throw new EZException(ex.getMessage());
            }  
            
        }
        public void execute(String sqlString) throws EZException{
            try {
                if (connection == null) {
                    throw new EZException("Database is not connected");
                }

                Statement stmt = null;
                stmt = connection.createStatement();
                stmt.executeUpdate(sqlString);
                
            } catch (SQLException ex) {
                throw new EZException(ex.getMessage());
            }
        
        }
//	public void connectToDB() throws EZException{
//            try{
//                String user = //PublicConstants.DBConstraints.USER;
//                String passwd = PublicConstants.DBConstraints.PWD;
//
//                url = PublicConstants.DBConstraints.CONNECTION_STRING;
//                Class.forName(PublicConstants.DBConstraints.DRIVER).newInstance(); 
//                connection = DriverManager.getConnection(url, user, passwd);
// 
//                this.isactive= true;
//                System.out.println("Successfully Connected to Database");
//                
//                
//            //SQLException,InstantiationException,
//                //IllegalAccessException,ClassNotFoundException
//            } catch (SQLException ex) {
//                throw new EZException(ex.getMessage());
//            } catch (ClassNotFoundException ex) { 
//                throw new EZException(ex.getMessage());
//        } catch (InstantiationException ex) {
//            throw new EZException(ex.getMessage());
//        } catch (IllegalAccessException ex) {
//            throw new EZException(ex.getMessage());
//        } 
//             
//	}
        public void disconnect() throws EZException{
            try{
                this.connection.close(); 
            }catch(SQLException ex){
                throw new EZException(ex.getMessage());
            }
        }

 
}
