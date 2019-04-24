
import java.sql.Blob;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JSN2142
 */
public class Property {
    private int PID;
    private String PropName;
    private int Price;
    private int Size;
    private String Description;
    private String Location;
    private String Address;
    private String base64Image;
    private byte[] Image;
    private String ImageName;
    private int UID;
    
    public int getPID(){
        return PID;
    }
    public void setPID(int pid){
        this.PID = pid;
    }
    
    public int getUID(){
        return UID;
    }
    public void setUID(int uid){
        this.UID = uid;
    }

    public String getLocation(){
        return Location;
    }
    public void setLocation(String Location){
        this.Location = Location;
    }
    
    public String getPropName(){
        return PropName;
    }
    public void setPropName(String PropName){
        this.PropName = PropName;
    }
    
    public int getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    
    public int getSize(){
        return Size;
    }
    public void setSize(int Size){
        this.Size = Size;
    }
    
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    
    public byte[] getImage() {
        return Image;
    }
 
    public void setImage(byte[] Image) {
        this.Image = Image;
    }
    
    public String getImageName() {
        return ImageName;
    }
 
    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }
    
}
