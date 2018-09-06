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
        <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
        <title>Page de connexion</title>
    </head>
        <div class="login-card">
         <h1>Register</h1><br>      
        <form method="post" action="RegisterServlet">
            <input type="email" name="login" placeholder="E-mail" required="true">
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
</html>
