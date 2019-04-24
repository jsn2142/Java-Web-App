<%-- 
    Document   : login
    Created on : Jun 27, 2018, 12:48:36 PM
    Author     : Anubis
--%>

<%-- 
    Document   : index
    Created on : Jun 27, 2018, 1:01:28 PM
    Author     : Anubis
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
        <form action="LoginServlet" method="post">
            <center>
        <input type="text" name="username" placeholder="Username"/>

        <input type="password" name="password" placeholder="Password"/>

        <input type="submit" value="login"/>
            </center>
            </form>
    </body>
</html>
