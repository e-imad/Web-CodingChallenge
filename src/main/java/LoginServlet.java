/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Class.Likes;
import Class.User;
import Class.UserData;
import GoogleApiService.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author imad
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recovering the users login inforation
                String un=request.getParameter("login");
		String pw=request.getParameter("password");
                // recovering the user's latitude and longetude 
                    //if the user refuses to allow the geolocalisation, latitude and longitude are set to 0 to handle the exception.
                double lat=Double.parseDouble(request.getParameter("lat"));
                double lng=Double.parseDouble(request.getParameter("lng"));
                HttpSession session =request.getSession();
                // check if the user exist in the database
		User a=UserData.findUser(un);
		if(a!=null && a.getPassword().equals(pw))
		{
                    // if the user exist and the login informations are correct
                        // recovering the list of the closest shops in the area
                       session.setAttribute("places",Client.getPlaces(lat,lng));
                       a.setPassword("");
                       // recovering the list of likes 
                       Likes like=new Likes(a.getEmail(),1);
                       // recovering the list of dislikes
                       Likes dislike=new Likes(a.getEmail(),1);
                       // setting the session variables
                       session.setAttribute("user", a);
                       session.setAttribute("like", like);
                       session.setAttribute("dislike", like);
                       session.setAttribute("error", null);
                       
		}
                else
                {
                    // if the login informations are incorrect the user is request retry
                    session.setAttribute("error","Login informations are incorrect");
                }
		
			response.sendRedirect("index.jsp");
		
	}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
