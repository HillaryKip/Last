package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.*;

public final class PdfGenerator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class PdfGenerator{
           Connection conn = null;
           PreparedStatement pst = null;
           String db="jdbc:mysql:///vettingsystem";
           String user = "root";
           String password = "";
           
           public PdfGenerator(){
               try{
               conn = DriverManager.getConnection(db,user,password);
               pst=conn.prepareStatement("select * from applicants_detailsb where Email=?");
               }catch(SQLException e){
                   e.printStackTrace();
               }
              }
           
           public ResultSet getApplicantDetails(String email){ 
               ResultSet rs=null;
               try{
                  pst.setString(1, email);
                  rs=pst.executeQuery();
               }catch(SQLException e){
                   e.printStackTrace();
               }
               return rs; 
           }
        }
        
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

 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!--start favicon--><link rel=\"shortcut icon\" href=\"image/favicon.ico\"><!--end favicon-->\n");
      out.write("        <title>pdf</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

               PdfPTable table = new PdfPTable(6); 
               PdfPCell c1 = new PdfPCell();
               
               c1 = new PdfPCell(new Phrase("First Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);
               
               c1 = new PdfPCell(new Phrase("Last Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);

               c1 = new PdfPCell(new Phrase("Gender"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);

               c1 = new PdfPCell(new Phrase("Date Of Birth"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);
               table.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Postal Address"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);
               table.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Country"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table.addCell(c1);
               table.setHeaderRows(1);

            response.setContentType("application/pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            String relativeWebPath = "/image/mmustlogo.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image image = Image.getInstance(absoluteDiskPath);
            
            document.addTitle("Application Form");
            document.add(image); 
            
            String email="kkkk";
            PdfGenerator pdf=new PdfGenerator();
            ResultSet rs1=pdf.getApplicantDetails(email);
            if(rs1.next()) {
            table.addCell(rs1.getString("First_Name"));
            table.addCell(rs1.getString("Last_Name"));
            table.addCell(rs1.getString("Gender"));
            table.addCell(rs1.getString("DoB"));
            table.addCell(rs1.getString("Postal_Address"));
            table.addCell(rs1.getString("Country"));
            }
            document.add(table); 
            document.close();
            
        
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
