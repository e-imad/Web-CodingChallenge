<%-- 
    Document   : shoplist
    Created on : 5 sept. 2018, 20:30:02
    Author     : imad
--%>

<%@page import="Class.Likes"%>
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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#dialog" ).dialog();
  } );
  </script>
    <body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">Close Shops</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
           <a href="favorites.jsp" class="w3-bar-item w3-button">Favorite</a>
            <a href="logout.jsp" class="w3-bar-item w3-button">Disconnect</a>
    </div>
  </div>
</div>
<div class="w3-content" style="max-width:800px">
  
        <div class="wrapper">
        <% 
            Likes b=(Likes)session.getAttribute("like");
            Likes c=(Likes)session.getAttribute("dislike");
        if(session.getAttribute("places")!= null)
        {
        for(Place a: (List<Place>) session.getAttribute("places"))
        {
            if((b==null ||!b.exist(a.getPlaceId()))&& (c==null || !c.exist(a.getPlaceId())))
            {
                
          %>
          
          <div class="box a">
          <table>
              <tr><td colspan="3" align="center" height="100"><small><% out.print(a.getName());%></small><td></tr>
              <tr><td colspan="3" align="center"><img src="<% out.print(a.getIconUrl()); %>" alt="" /></td></tr>
              <tr><td align="center" width="60px"><img src="css/images/like.png" alt="like" width="40px"  onclick= "initForm('<% out.print(a.getPlaceId());%>')"/></td><td align="center" ><img src="css/images/pin.png" alt="like" width="40px" onclick= "map('<% out.print(a.getPlaceId());%>')"/></td><td align="center" width="60px"><img src="css/images/dislike.png" alt="dislike" width="40px" onclick= "initForm2('<% out.print(a.getPlaceId());%>')"/></td></tr>
          </table>
          </div>
          
             
       <% }
            }
}else{
       %> <div id="dialog" title="Basic dialog">
           <p>No shops were found near your location,<p style="color: red"> if you did not allow geolocalisation please allow it for the application to work.</p></p>
</div> <%
}
        %>
        </div>
  </div>
        <form id="like" method="Post"  action="LikedServlet" hidden="true">
            <input type="text" name="ID" value="">
            <input type="submit"  >
        </form>
         <form id="dislike" method="Post"  action="Disliked" hidden="true">
            <input type="text" name="ID" value="">
            <input type="submit"  >
        </form>
           </body>
           <script  type="text/javascript">
               function initForm(v){
               oFormObject = document.forms['like'];
               oFormObject.elements["ID"].value = v;
               var newForm = document.getElementById("like")
               newForm.submit();
           }
           function initForm2(v){
               oFormObject = document.forms['dislike'];
               oFormObject.elements["ID"].value = v;
               var newForm = document.getElementById("dislike")
               newForm.submit();
           }
           function map(v)
           {
               popupWindow = window.open('map.html?ref='+v, 'name', 'width=700,height=350');
               popupWindow.focus();
           }
               </script>
</html>
