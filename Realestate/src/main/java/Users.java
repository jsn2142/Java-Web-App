

/**
 *
 * @author JsN_RiFaT
 */
public class Users{
        protected int id;
        protected String name;
        protected String username;
        protected String email;
        protected String password;
        
        public Users(){
            
        }
        public Users(int id){
            this.id = id;
        }
        
        public Users(int id, String name, String username, String email, String password){
            this(name, username, email, password);
            this.id = id;
        }
        public Users(String name, String username, String email, String password){
            this.name = name;
            this.username = username;
            this.email = email;
            this.password = password;
        }
        
        public int getID(){
            return id;
        }
        public String getName(){
            return name;
        }
        public String getUsername(){
            return username;
        }
        public String getEmail(){
            return email;
        }
        public String getPassword(){
            return password;
        }
        
        public void setName(String name){
            this.name = name;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setPassword(String password){
            this.password = password;
        }

    void getUsers(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
