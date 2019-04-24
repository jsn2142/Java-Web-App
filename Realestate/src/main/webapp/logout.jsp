<%-- 
    Document   : logout
    Created on : Jun 27, 2018, 1:04:48 PM
    Author     : Anubis
--%>

<%
session.setAttribute("uname", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>