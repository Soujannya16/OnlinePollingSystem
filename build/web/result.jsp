<%-- 
    Document   : result
    Created on : Feb 23, 2019, 2:49:12 PM
    Author     : SUJANYA
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULT</title>
        <script>
            </script>
    </head>
    
        <%
            
                   GetDbConn gd = new GetDbConn();
        try {
            Connection co = null;
               Statement stmt = null;
            ResultSet rs = null;
         
            co = gd.GetdbConnection("OnlinePoleConn.xml", "ONPOLL");
            stmt = co.createStatement();
            String ad= request.getParameter("ad");
            
//           String ls_sql=" SELECT PARTY_ID FROM CASTING WHERE VOTE_MAX = (SELECT MAX(VOTE_MAX) FROM CASTING)";
//          try{
//           rs = stmt.executeQuery(ls_sql);
//            String ad="";
//               while (rs.next()) {
//                    ad = rs.getString(1);
//                }
//                rs.close();
//          
          //  System.out.println(ad + "WON");
            
            
        
    %>
    <body>
        <h1>Winning Party ---> <%=ad%></h1>
        
        <%
//            }catch(Exception ex){
//              out.println("Error in query"+ex.getMessage());
//            }
        }catch(Exception ex1){
               out.println("Error in Connection--->"+ex1.getMessage());
            }
         %>
    </body>
</html>
