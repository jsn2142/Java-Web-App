/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author JsN_RiFaT
 */
@WebServlet(urlPatterns = {"/InputServlet"})
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*50)
public class InputServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        HttpSession session=request.getSession();
        String username;
        username=(String)session.getAttribute("username");
        
        InputStream inputstream = null;
        String imageName = null;
        String PropName = request.getParameter("PropName");
        String Location =request.getParameter("Location");
        int Price= Integer.parseInt(request.getParameter("Price"));
        int Size= Integer.parseInt(request.getParameter("Size"));
        String Description=request.getParameter("Description");
        String Address=request.getParameter("Address");
        Property p=new Property();
        //ResultSet result = new ResultSet();
        //p.setImage(Image);
        p.setPropName(PropName);
        p.setLocation(Location);
        p.setPrice(Price);
        p.setSize(Size);
        p.setDescription(Description);
        p.setAddress(Address);
       
        //Image input 
        Part filePart = request.getPart("Image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputstream = filePart.getInputStream();
            imageName = filePart.getName();
            
        }

        
        try {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();

            int row=PropDAO.insertProp(p, inputstream, username);
            if(row>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("home.jsp").include(request, response);
            }else{
                out.println("Sorry! unable to save record "+username);
            }
              
            out.close();
        } catch(Exception e){System.out.println(e);}
    } 

}
