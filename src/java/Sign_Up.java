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
 * @author USER
 */
public class Sign_Up extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Connection co=null;
            GetDbConn gd=new GetDbConn();
            try {
            co = gd.GetdbConnection("OnlinePoleConn.xml", "ONPOLL");
            
            
            
            Statement st=null;
            ResultSet rs=null;
            String unm="";
            PreparedStatement pst = null;
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String password=request.getParameter("psw");
            String dob=request.getParameter("dob");
            String gen=request.getParameter("gender");
            String vid=request.getParameter("vid");
            int adhar=Integer.parseInt(request.getParameter("ano"));
            int pin=Integer.parseInt(request.getParameter("pno"));
            
            
           /* st=co.createStatement();
            String query="select * from VOTER_DETAILS where name="+username;
            rs=st.executeQuery(query);*/
    
            
            String query = "insert into VOTER_DETAILS(NAME,DOB,GENDER,PIN_NO,ADHAR_NO,VOTER_ID,PASSWORD)"
                    + " values('"+name+"',to_date('"+dob+"','dd/mm/yyyy'),'"+gen+"',"+pin+","+adhar+",'"+vid+"','"+password+"')";
            out.println(query);
             pst = co.prepareStatement(query);
            
                   try{ 
            pst.executeUpdate();
            pst.close();
            
//            try{
//            co.commit();
            
             out.println("<script>");
           out.println("alert('Successfull');");
           out.println("Location='index.html'");
           out.println("</script>");
           
            /* TODO output your page here. You may use following sample code. */
           
           
//           }catch(Exception ex2){
//               out.println("Error in commit--->"+ex2.getMessage());
//               
//           }
           
           }catch(Exception ex1){
               out.println("Error in Query--->"+ex1.getMessage());
               
           }
            }catch(Exception ex){
                out.println("Error in getting connection--->"+ex.getMessage());
                
            }  
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Sign_Up.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Sign_Up.class.getName()).log(Level.SEVERE, null, ex);
        }
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

