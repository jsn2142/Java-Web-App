/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JsN_RiFaT
 */
public class EditServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>"); 
        
        String eid = request.getParameter("id");
        
        int pid = Integer.parseInt(eid);
        
        try {
            Property p;
            p = PropDAO.getPropertybyID(pid);
            
            out.print("<form action=\"${ pageContext.request.contextPath}/UpdateServlet\" method=\"post\" enctype=\"multipart/form-data\">");
        out.print("Select File:<input type=\"file\" name=\"Image\"/><br/>");
        out.print("<input type=\"text\" name=\"PropName\" value="+p.getPropName()+"/><br>");
        out.print("<input type=\"text\" name=\"Price\" value="+p.getPrice() +"/><br>");
        out.print("<input type=\"text\" name=\"Size\" value="+p.getSize() +"/><br>");
        out.print("<input type=\"text\" name=\"Description\" value="+p.getDescription() +"/><br>");
        out.print("<input type=\"text\" name=\"Address\" value="+p.getAddress() +"/><br>");
        out.print("<select name=\"Location\">"
                + "<option>Rampura</option>"
                + "<option>Khilgaon</option>"
                + "<option>Basabo</option>"
                + "<option>Mirpur</option>"
                + "<option>Aftabnagar</option>"
                + "<option>Uttara</option>"
                + "<option>Basundhara</option>"
                + "<option>Gulshan</option>"
                + "<option>Banani</option>"
                + "<option>Dhanmondi</option>"
                + "<option>Tikatuli</option>"
                + "<option>Naya Paltan</option>"
                + "<option>Badda</option>"
                + "<option>Puran Dhaka</option>");
        out.print("</select>");
        out.print("<button type=\"submit\" value=\"update\">Submit</button>");
        out.print("</form>");
        out.print("<h2><a href=\"home.jsp\">Go Back</a></h2>");
        
            
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    

}
