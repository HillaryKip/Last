package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Messaging_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"mycss/chatbox/bootstrap.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("        <link href=\"mycss/chatbox/chatbox.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("            <div class=\"portlet portlet-default\">\n");
      out.write("                <div class=\"portlet-heading\">\n");
      out.write("                    <div class=\"portlet-title\">\n");
      out.write("                        <h4><i class=\"fa fa-circle text-green\"></i> Jane Smith</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"portlet-widgets\">\n");
      out.write("                        <div class=\"btn-group\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-white dropdown-toggle btn-xs\" data-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-circle text-green\"></i> Status\n");
      out.write("                                <span class=\"caret\"></span>\n");
      out.write("                            </button>\n");
      out.write("                            <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-circle text-green\"></i> Online</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-circle text-orange\"></i> Away</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-circle text-red\"></i> Offline</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <span class=\"divider\"></span>\n");
      out.write("                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#chat\"><i class=\"fa fa-chevron-down\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"chat\" class=\"panel-collapse collapse in\">\n");
      out.write("                    <div>\n");
      out.write("                    <div class=\"portlet-body chat-widget\" style=\"overflow-y: auto; width: auto; height: 300px;\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <p class=\"text-center text-muted small\">January 1, 2014 at 12:23 PM</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                        <img class=\"media-object img-circle\" src=\"http://lorempixel.com/30/30/people/1/\" alt=\"\">\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h4 class=\"media-heading\">Jane Smith\n");
      out.write("                                            <span class=\"small pull-right\">12:23 PM</span>\n");
      out.write("                                        </h4>\n");
      out.write("                                        <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                        <img class=\"media-object img-circle\" src=\"http://lorempixel.com/30/30/people/7/\" alt=\"\">\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h4 class=\"media-heading\">John Smith\n");
      out.write("                                            <span class=\"small pull-right\">12:28 PM</span>\n");
      out.write("                                        </h4>\n");
      out.write("                                        <p>Yeah I did. Everything looks good.</p>\n");
      out.write("                                        <p>Did you have an update on purchase order #302?</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                        <img class=\"media-object img-circle\" src=\"http://lorempixel.com/30/30/people/7/\" alt=\"\">\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h4 class=\"media-heading\">Jane Smith\n");
      out.write("                                            <span class=\"small pull-right\">12:39 PM</span>\n");
      out.write("                                        </h4>\n");
      out.write("                                        <p>No not yet, the transaction hasn't cleared yet. I will let you know as soon as everything goes through. Any idea where you want to get lunch today?</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"portlet-footer\">\n");
      out.write("                        <form role=\"form\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <textarea class=\"form-control\" placeholder=\"Enter message...\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default pull-right\">Send</button>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col-md-4 -->\n");
      out.write("    </div>\n");
      out.write("</div>                \n");
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
