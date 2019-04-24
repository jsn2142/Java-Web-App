<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>HOME</title>
    </head>
    <body>
         <header>
                             
                       
        <%
            String username = null;
            username=(String)session.getAttribute("username"); 
            if(username!=null){  
             
            //Users u = new Users();
            //u.setUsername(username);
            out.print("Hello, "+username+" Welcome to your Profile");  
            
        %>
        <h1>Registration is Successful.</h1>
        <form action="${ pageContext.request.contextPath}/InputServlet" method="post" enctype="multipart/form-data">
            
            Select File:<input type="file" name="Image"/><br/>
            
            <input type="text" name="PropName" placeholder="Property Name"/><br>
            <input type="text" name="Price" placeholder="Price Per Square Feet"/><br>
            <input type="text" name="Size" placeholder="Size in Square Feet"/><br>
            <input type="text" name="Description" placeholder="Description"/><br>
            <input type="text" name="Address" placeholder="Property Address"/><br>
            <select name="Location">
                <option>Rampura</option>
                <option>Khilgaon</option>
                <option>Basabo</option>
                <option>Mirpur</option>
                <option>Aftabnagar</option>
                <option>Uttara</option>
                <option>Basundhara</option>
                <option>Gulshan</option>
                <option>Banani</option>
                <option>Dhanmondi</option>
                <option>Tikatuli</option>
                <option>Naya Paltan</option>
                <option>Badda</option>
                <option>Puran Dhaka</option>
            </select>            
            <button type="submit" value="insert">Submit</button>
        </form>
        
        
        <h2><a href="LogoutServlet">Logout</a></h2>
        <h2><a href="ViewServlet">View all posts</a></h2>
        <h2><a href="ViewOwnServlet">View your posts</a></h2>
        <h2><a href="EditServlet">Edit Posts</a></h2>
        
        <%
            }
            else{
        %>
        <h2>Please <a href="login.jsp">Login</a> or <a href="signup.jsp">Signup</a> first to join the Marketplace.</h2>
        <%}%>
    </body>
</html>
