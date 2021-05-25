/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class log_in extends HttpServlet {

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
        Connection co = null;
        GetDbConn gd = new GetDbConn();
        try {
            co = gd.GetdbConnection("OnlinePoleConn.xml", "ONPOLL");

            Statement stmt = null;
            ResultSet rs = null;
            String unm = "";
            PreparedStatement pst = null;
            /* TODO output your page here. You may use following sample code. */
            stmt = co.createStatement();

            String password = request.getParameter("pass");
            int adhar = Integer.parseInt(request.getParameter("ano").toString());

            String ls_sql = "SELECT COUNT(*) FROM VOTER_DETAILS where ADHAR_NO = " + adhar;
            try {
                rs = stmt.executeQuery(ls_sql);
                int ad = 0;
                while (rs.next()) {
                    ad = rs.getInt(1);
                }
                rs.close();
                try {
                    if (ad > 0) {
                        String ps_sql = "SELECT COUNT(*) FROM  VOTER_DETAILS where PASSWORD = '" + password + "' and ADHAR_NO= " + adhar;
                        rs = stmt.executeQuery(ps_sql);
                        int adps = 0;
                        while (rs.next()) {
                            adps = rs.getInt(1);
                        }
                        rs.close();
                        if (adps > 0) {
                                  request.getRequestDispatcher("casting_page.html").forward(request,response);
                          //  response.sendRedirect("casting_page.html");
                            //   return;
                        } else {
                            System.out.println("WRONG PASSWORD");
                        }

                    } else {
                        System.out.println("WRONG ADHAR_NO");

                    }

                } catch (Exception ex1) {
                    System.out.println("Error in Query--->" + ex1.getMessage());

                }
            } catch (Exception ex2) {
                System.out.println("Error in Query--->" + ex2.getMessage());

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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

