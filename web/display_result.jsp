<%-- 
    Document   : display_result
    Created on : 25 Jan, 2019, 4:57:26 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            STYLE type="text/css">
  h1 { text-align: center}
 
h1 { 
  display: block;
  font-size: 2em;
  margin-top: 0.67em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
}
</style>

    </head>
    <body style ="background: url(https://smallbiztrends.com/wp-content/uploads/2015/12/trophy-award.jpg) ; background-size: 100% 100% ; background-repeat: no-repeat;background-size: cover;">
   
    <body>
        <% 
            HttpSession s = request.getSession();
            String ad1 ="";
            
            ad1 =(String)s.getAttribute("ad");
            %>
        
        
    <centre> <h1>Winning Party ---> <%=ad1%></h1>    </centre>


    </body>
</html>
