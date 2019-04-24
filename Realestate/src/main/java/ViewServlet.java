/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JsN_RiFaT
 */
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='home.jsp'>Add New Property</a>");
        out.println("<h1>Property List</h1>");

        List<Property> list = null;
        
        
        try {
            list = PropDAO.getAllProperties();
        } catch (SQLException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.print("<table border='1' width='100%'");
        out.print("<tr> <th>Property Name</th> <th>Size</th> <th>Price</th> <th>Location</th> <th>Address</th> <th>Description</th> <th>Image</th> </tr>");  
        for (Property p : list) {
            out.print("<tr> <td>"+ p.getPropName()+"</td> <td>"+ p.getSize()+"</td> <td>"+p.getPrice()+"</td> <td>"+p.getLocation()+"</td> <td>"+p.getAddress()+"</td> <td>"+p.getDescription()+"</td> <td><img src='data:image/jpg;base64,"+p.getBase64Image()+" '  style='width:150px; height:125px;'></td> <td><a href ='EditServlet?id="+p.getPID()+"'>edit</a></td> <td><a href ='DeleteServlet?id="+p.getPID()+"'>delete</a></td> </tr>");  
        }  
        out.print("</table>");

        out.close();
    }

}


