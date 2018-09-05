<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<% Cookie[] cookie_jar = request.getCookies();
if (session.getAttribute("user")==null)
{
    %>
    <%@include file="login.jsp" %>
    <%
}
else
{%>
<%@include file="shoplist.jsp" %>
<%}
%>
