/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JSN2142
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

   public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    
    boolean status = false;
  
    String username=request.getParameter("username");  
    String password=request.getParameter("password");  
    
    Users u = new Users();
    u.setUsername(username);
    u.setPassword(password);
 
    try{
        status = RegDAO.logUser(u);
        if(status == true){
            out.print("Welcome, "+username);
            HttpSession session=request.getSession();  
            session.setAttribute("username",username); 
            RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
            rd.forward(request,response); 
            
        }
        
        else{  
            out.print("Sorry username or password error "+status);  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);  
        }
    }catch (Exception e2) {System.out.println(e2);}
      
    out.close();  
    }  
}
