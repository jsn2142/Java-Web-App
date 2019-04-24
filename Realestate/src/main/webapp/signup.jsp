<%-- 
    Document   : signup
    Created on : Jun 27, 2018, 10:02:01 AM
    Author     : JsN_RiFaT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Here</h1>
        <form action="RegisterServlet" method="post">
        <pre>
        <input type="text" name="name" placeholder="Full Name" />
        <input type="text" name="username" placeholder="Username" />
        <input type="text" name="email" placeholder="Email" />
        <input type="password" name="password" placeholder="Password"/>
        <input type="password" name="password2" placeholder="Confirm Password"/>
        <button type="submit" value="register">Submit</button>
        </pre>
        </form>
    </body>
</html>
