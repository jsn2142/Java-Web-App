
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpSession;


/**
 *
 * @author JSN2142
 */
public class PropDAO {
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
    
    public static int insertProp(Property p, InputStream inputstream, String username) throws SQLException{
        int row = 0;
        try{
            Connection con;
            con = PropDAO.getConnection();
            PreparedStatement ps2 = con.prepareStatement("SELECT id FROM users WHERE uname=?");
            ps2.setString(1, username);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                p.setUID(rs2.getInt(1));
            }
            
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO property (Image, Location, PropName, Price, Size, Description, Address, UID) VALUES (?,?,?,?,?,?,?,?)");
 
            if (inputstream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(1, inputstream);
                
            }
            //ps.setBinaryStream(1, flItem.getInputStream(), (int) flItem.getSize());
            ps.setString(2, p.getLocation());
            ps.setString(3, p.getPropName());
            ps.setInt(4, p.getPrice());
            ps.setInt(5, p.getSize());
            ps.setString(6, p.getDescription());
            ps.setString(7, p.getAddress());
            ps.setInt(8, p.getUID());
            row = ps.executeUpdate();
            
            
            
        }catch(Exception ex){ex.printStackTrace();} 
        
        
        
        return row;
    }
    
    public static List<Property> getAllProperties() throws SQLException{
        List<Property> list = new ArrayList<Property>();
        Blob image = null;
        //ServletOutputStream output = response.getOutputStream();
        
        try{
            Connection con = PropDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT PID, Location, PropName, Price, Size, Description, Address, Image FROM property");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Property p = new Property();
                p.setPID(rs.getInt(1));
                p.setLocation(rs.getString(2));
                p.setPropName(rs.getString(3));
                p.setPrice(rs.getInt(4));
                p.setSize(rs.getInt(5));
                p.setDescription(rs.getString(6));
                p.setAddress(rs.getString(7));
                
                //entire process of retrieving an image form the Database starts here and....
                image = rs.getBlob(8);
                InputStream inputStream = image.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                p.setBase64Image(base64Image);
                //inputStream.close();
                //outputStream.close();
                
                //....ends here
                list.add(p);
            }
            con.close();
            
        }catch(Exception e){e.printStackTrace();}
       
        
        return list;
    }
    
    
    public static int delete(int id) throws SQLException{
        int status = 0;
        try{
            Connection con = PropDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM property WHERE PID=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
        
        return status;
    }
    
    /**
     *
     * @param p
     * @return
     * @throws SQLException
     */
    public static int update(Property p, InputStream inputstream) throws SQLException{
        int status = 0;
        try{
            Connection con = PropDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE property SET Location=?, PropName=?, Price=?, Size=?, Description=?, Address=?, Image=?");
            ps.setString(1, p.getLocation());
            ps.setString(2, p.getPropName());
            ps.setInt(3, p.getPrice());
            ps.setInt(4, p.getSize());
            ps.setString(5, p.getDescription());
            ps.setString(6, p.getAddress());
            if (inputstream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(7, inputstream);
                
            }
            status = ps.executeUpdate();
            
            con.close();
        }catch(Exception e){e.printStackTrace();}
        
        return status;
    }
    
    public static Property getPropertybyID(int id) throws SQLException{
        Property p = new Property();
        
        try{
            Connection con = PropDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT PID, Location, PropName, Price, Size, Description, Address FROM property WHERE UID=?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setPID(rs.getInt(1));
                p.setLocation(rs.getString(2));
                p.setPropName(rs.getString(3));
                p.setPrice(rs.getInt(4));
                p.setSize(rs.getInt(5));
                p.setDescription(rs.getString(6));
                p.setAddress(rs.getString(7));
            }
        }catch(Exception e){e.printStackTrace();}
        
        return p;
    }
    
        
}
