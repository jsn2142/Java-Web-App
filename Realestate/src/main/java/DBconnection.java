
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JsN_RiFaT
 */
public class DBconnection {
    protected String DBurl = "jdbc:mysql://127.0.0.1:3306/realestate";
    protected String DBusername ="root";
    protected String DBpassword = "";
    protected String driver = "com.mysql.jdbc.Driver";
    protected Connection Condb;
    
    public DBconnection(){
        
    }
    public String getDBurl(){
        return DBurl;
    }
    public String getDBusername(){
        return DBusername;
    }
    public String getDBpassword(){
        return DBpassword;
    }
    public String getDriver(){
        return driver;
    }
    
    public void DBconnection() throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection(DBurl, DBusername, DBpassword);
    }
  
    
}
