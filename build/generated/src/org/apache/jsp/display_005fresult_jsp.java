package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class display_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            STYLE type=\"text/css\">\n");
      out.write("  h1 { text-align: center}\n");
      out.write(" \n");
      out.write("h1 { \n");
      out.write("  display: block;\n");
      out.write("  font-size: 2em;\n");
      out.write("  margin-top: 0.67em;\n");
      out.write("  margin-bottom: 0.67em;\n");
      out.write("  margin-left: 0;\n");
      out.write("  margin-right: 0;\n");
      out.write("  font-weight: bold;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body style =\"background: url(https://smallbiztrends.com/wp-content/uploads/2015/12/trophy-award.jpg) ; background-size: 100% 100% ; background-repeat: no-repeat;background-size: cover;\">\n");
      out.write("   \n");
      out.write("    <body>\n");
      out.write("        ");
 
            HttpSession s = request.getSession();
            String ad1 ="";
            
            ad1 =(String)s.getAttribute("ad");
            
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <centre> <h1>Winning Party ---> ");
      out.print(ad1);
      out.write("</h1>    </centre>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
