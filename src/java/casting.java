/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SUJANYA
 */
public class casting extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet casting</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet casting at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
             Connection co=null;
            GetDbConn gd=new GetDbConn();
            try {
            co = gd.GetdbConnection("OnlinePoleConn.xml", "ONPOLL");

            Statement stmt = null;
            ResultSet rs = null;
            String unm = "";
            PreparedStatement pst = null;
            /* TODO output your page here. You may use following sample code. */
            stmt = co.createStatement();
            
            String vote_id = request.getParameter("vote_id");
            
          
            // String ls_sql = "SELECT COUNT(*) FROM Table CASTING where PARTY_ID = " + P1 + " and PARTY_2 = " + p2 +" and PARTY_3 = " + p3 + " and PARTY_4 = " + p4;
            
              //  rs = stmt.executeQuery(ls_sql);
            
           /* int p1 = "SELECT COUNT(*) FROM Table CASTING where PARTY_1 = " + p1;
            int p2 = "SELECT COUNT(*) FROM Table CASTING where PARTY_2 = " + p2;
            int p3 = "SELECT COUNT(*) FROM Table CASTING where PARTY_3 = " + p3;
            int p4 = "SELECT COUNT(*) FROM Table CASTING where PARTY_4 = " + p4;*/
            
             String ls_sql = "SELECT VOTE_MAX FROM CASTING where PARTY_ID = '" + vote_id +"'";
               rs = stmt.executeQuery(ls_sql);
               int max_no=0;
               while (rs.next()) {
                    max_no = rs.getInt(1);
                }
                rs.close();
                max_no = max_no + 1;
           
            
            ls_sql = "update CASTING set VOTE_MAX = "+max_no+"where PARTY_ID = '"+vote_id+"'";
            
             
             
             pst = co.prepareStatement(ls_sql);
            
                   try{ 
            pst.executeUpdate();
            pst.close();
            
//            try{
//            co.commit();
            
           //  out.println("<script>");
           //out.println("alert('Successfull');");
           
           //out.println("</script>");
             request.getRequestDispatcher("index.html").forward(request,response);
     
            /* TODO output your page here. You may use following sample code. */
           
           
           }catch(Exception ex2){
               out.println("Error in commit--->"+ex2.getMessage());
               
           }
           
           }catch(Exception ex1){
               out.println("Error in Query--->"+ex1.getMessage());
               
           }
         } catch (Exception ex3) {
            System.out.println("Error in Query--->" + ex3.getMessage());

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
