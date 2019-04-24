/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
          
            String name=request.getParameter("name");  
            String username=request.getParameter("username");  
            String email=request.getParameter("email");  
            String password=request.getParameter("password");
            String password2=request.getParameter("password2");
            
            Users u = new Users();
            u.setName(name);
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(password);
            
            if(password == null ? password2 == null : password.equals(password2)){
            try{  
       
                int row = RegDAO.regUser(u);
                
                if(row>0){  
                    out.print("Welcome, "+username); 
                    RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
                    rd.include(request,response);
                    HttpSession session=request.getSession();  
                    session.setAttribute("username",username);
                }
          
                }catch (Exception e2) {System.out.println(e2);}  
            }
            else{
                out.print("Passwords don't match, try again!");
                RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");  
                rd.include(request,response);
            }
            
            out.close();  
    } 
}
