<%-- 
    Document   : login
    Created on : 5 sept. 2018, 16:54:52
    Author     : imad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
        <title>Page de connexion</title>
    </head>
        <div class="login-card">
         <h1>Register</h1><br>      
        <form method="post" action="RegisterServlet">
            <input type="email" name="login" placeholder="E-mail" required="true">
            <input type="text" name="lat" value="33.9954233" hidden="true">
            <input type="text" name="lng"   value=" -6.8522169" hidden="true" >
            <input type="password" name="password" placeholder="Password" required="true">
            <input type="submit" name="Register" class="login login-submit" value="Register">
             <%if(session.getAttribute("error")!=null)
                {
                    out.print("<p style=\"color:red;\">"+ session.getAttribute("error")+"</p>");
                }
                %>
        </form>
        </div>
    
    </body>
      <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
  
      function init() {
      
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            oFormObject = document.forms['login'];
            oFormObject.elements["lat"].value = pos.lat;
            oFormObject.elements["lng"].value = pos.lng;
           
          }, function() {
            
          });
        } else {
          // Browser doesn't support Geolocation
         
        }
        
      }
init();
    
    </script>
</html>
