<%-- 
    Document   : logour
    Created on : 6 sept. 2018, 11:09:37
    Author     : imad
--%>

<%
session.invalidate();
response.sendRedirect("index.jsp");
%>