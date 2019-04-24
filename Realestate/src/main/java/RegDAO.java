
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JsN_RiFaT
 */
public class RegDAO {
    public static Connection getConnection() throws SQLException{
        Connection con = null;
        DBconnection conDB = new DBconnection();
        String url = conDB.getDBurl();
        String DBuser = conDB.getDBusername();
        String DBpass= conDB.getDBpassword();
        String Driver = conDB.getDriver();
        
        try{
            Class.forName(Driver);  
            con=DriverManager.getConnection(url, DBuser, DBpass);
        }catch(Exception e){System.out.println(e);}
    return con;    
    }
    
    //For Registration of a User
    public static int regUser(Users u) throws SQLException{
        int row = 0;
        try{
            Connection con = RegDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into users(name, uname, email, password) values(?,?,?,?)");
            
            ps.setString(1, u.getName());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            
            row = ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
        
        return row;
    }
    
    //For Logging in of a User
    public static boolean logUser(Users u) throws SQLException{
        //int row = 0;
        boolean status= false;
        try{
            Connection con = RegDAO.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where uname=? and password=?");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            
            ResultSet rs=ps.executeQuery();  
            status=rs.next();
            
            //row = ps.executeUpdate();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }
    
    
}
