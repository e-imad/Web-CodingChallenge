/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Class.LikeID;
import Class.Likes;
import Class.User;
import Class.UserData;
import GoogleApiService.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author imad
 */
public class LikedServlet extends HttpServlet {

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
            out.println("<title>Servlet LikedServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LikedServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  // recovering the placeID
                    String id=request.getParameter("ID");
                    HttpSession session =request.getSession();
                    // recovering the user's email
                    User a=(User) session.getAttribute("user");
                    String user=a.getEmail();	
                    
                if(request.getParameter("remove")==null||!request.getParameter("remove").equals("true"))
                {// if the request is to add a liked place to the data base
                    // adding the like place to the data base
                    LikeID.AddLike(user, id);
                    //recovering the list of liked places
                    Likes b=new Likes(a.getEmail(),1);
                    //setting the like attribute in the session with the new results
                    session.setAttribute("like",b);
                    response.sendRedirect("index.jsp");
                }
                else
                {
                  // if the request is to remove a liked place to the data base
                    // removing the like place to the data base
                    LikeID.RemoveLike(user, id);
                    //recovering the list of liked places
                    Likes b=new Likes(a.getEmail(),1);
                    //setting the like attribute in the session with the new results
                    session.setAttribute("like",b);
                    response.sendRedirect("favorites.jsp");
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
