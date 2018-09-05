<%-- 
    Document   : shoplist
    Created on : 5 sept. 2018, 20:30:02
    Author     : imad
--%>

<%@page import="se.walkercrou.places.Place"%>
<%@page import="GoogleApiService.Client"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Class.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </head>
    <body>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">Close Shops</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="#about" class="w3-bar-item w3-button">Disconnect</a>
      <a href="#menu" class="w3-bar-item w3-button">Favorite</a>
      <a href="#contact" class="w3-bar-item w3-button">Disliked</a>
    </div>
  </div>
</div>
<div class="w3-content" style="max-width:800px">
  
        <div class="wrapper">
        <% 
        for(Place a: Client.getPlaces())
        {
          %>
          
          <div class="box a">
          <table>
              <tr><td colspan="3" align="center" height="100"><small><%out.print(a.getName());%></small><td></tr>
              <tr><td colspan="3" align="center"><img src="<% out.print(a.getIconUrl()); %>" alt="" /></td></tr>
              <tr><td align="center" width="60px"><img src="css/images/like.png" alt="like" width="40px" /></td><td align="center" ><img src="css/images/pin.png" alt="like" width="40px" /></td><td align="center" width="60px"><img src="css/images/dislike.png" alt="dislike" width="40px" /></td></tr>
          </table>
          </div>
          
             
       <% }
        
        %>
        </div>
  </div>
     
           </body>
</html>
