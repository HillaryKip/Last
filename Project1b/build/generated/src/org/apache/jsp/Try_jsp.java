package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.DecimalFormat;

public final class Try_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public class AppDetails{
        PreparedStatement pst=null;
        PreparedStatement pst2=null;
        PreparedStatement pst3=null;
        PreparedStatement pst4=null;
        PreparedStatement pst5=null; 
        PreparedStatement pst6=null;  
        PreparedStatement pst7=null;
        PreparedStatement pst8=null;
        PreparedStatement pst9=null;
        PreparedStatement pst10=null; 
        Connection conn=null;  
        ResultSet rs=null;
        String db="jdbc:mysql:///vettingsystem";
        String user="root";
        String password="";
        
        public AppDetails(){
            try{ 
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("insert into applicants_detailsb values(?,?,?,?,?,?,?,?,?)");
            
            pst2=conn.prepareStatement("update qualification2 set PhysicsGrade=?, MathsGrade=?, Subject3Grade=?, Subject4Grade=?, MeanGrade=?, WeightedClusterPoints=? where Email=?");
            
            pst3=conn.prepareStatement("select * from min_cluster_points where minClusterpoints<=?");
            
            pst4=conn.prepareStatement("select WeightedClusterPoints from qualification2 where Email=?");
            
            pst5=conn.prepareStatement("select crs_name from courses where crs_id=?");
            
            pst6=conn.prepareStatement("select Level_name from course_levels where Level_id=?");
            
            pst7=conn.prepareStatement("select * from campuses");
            
            pst8=conn.prepareStatement("insert into course_app_details values (?,?,?,?,?)");  
            
            pst9=conn.prepareStatement("select Level_id from course_levels where Level_name=?");
            
            pst10=conn.prepareStatement("select crs_id from courses where crs_name=?");
            
            }
            catch(SQLException e){ 
                e.printStackTrace();
            }
        }
              
            public int setApplicants(String email, String fname, String mname, String lname, String gender, String dob, String postalAddress, String mobile, String country){
                int i=0; 
                try{
                    pst.setString(1,email);
                    pst.setString(2,fname);
                    pst.setString(3,mname);
                    pst.setString(4,lname);
                    pst.setString(5,gender);
                    pst.setString(6,dob);
                    pst.setString(7,postalAddress);
                    pst.setString(8,mobile);
                    pst.setString(9,country);
                    i=pst.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return i; 
            }
            
            public int setQualificationPoints(String subj1, String subj2, String subj3, String subj4, String meanGrade, double aggregatePoints){
                int j=0;
                String kip="rok@yahoo.com";
                try{
                pst2.setString(1,subj1);
                pst2.setString(2,subj2);
                pst2.setString(3,subj3);
                pst2.setString(4,subj4); 
                pst2.setString(5,meanGrade);
                pst2.setDouble(6,aggregatePoints);  
                pst2.setString(7,kip);
                j=pst2.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return j;  
            }
            
            public ResultSet setCourseName(int id){
                ResultSet info1=null;
                try{
                pst5.setInt(1, id); 
                info1=pst5.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return info1; 
            }
            
            public ResultSet setCourseLevel(int id){
                ResultSet info2=null;
                try{
                    pst6.setInt(1, id);
                    info2=pst6.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return info2; 
            }
            
            public ResultSet setCampuses(){
                ResultSet campus=null; 
                try{
                    campus=pst7.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return campus; 
            }
            
            public int setCourseAppDetails(String email, int crsLevel, int crsId, String modeOfStudy, String campus){
                int k=0;
                try{
                pst8.setString(1,email);
                pst8.setInt(2,crsLevel);
                pst8.setInt(3,crsId);
                pst8.setString(4,modeOfStudy);
                pst8.setString(5,campus);
                k=pst8.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return k;  
            }
            
            public ResultSet getLevelId(String levelName){ 
                ResultSet results=null; 
            try{
                pst9.setString(1, levelName); 
                results=pst9.executeQuery(); 
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return results; 
            }
            
            public ResultSet getCourseId(String courseName){ 
                ResultSet results=null; 
            try{
                pst10.setString(1, courseName);
                results=pst10.executeQuery(); 
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return results; 
            }
            
            public ResultSet selectClusters(double clusterPoints){
                try{
                pst3.setDouble(1, clusterPoints); 
                rs=pst3.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return rs; 
            }
            
            public ResultSet selectClusterPoints(String email){
                ResultSet rsCluster=null;
                try{
                pst4.setString(1, email);
                rsCluster=pst4.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return rsCluster;
            }
            
            public double calculateClusterPoints(double subj1, double subj2, double subj3, double subj4, double aggPoints){
                double res1=(subj1+subj2+subj3+subj4);
                double res2=(res1/48); 
                double res3=(aggPoints/84);
                double res4=(res2*res3);
                double res5=(Math.sqrt(res4));
                double w=(res5*48);
                DecimalFormat df = new DecimalFormat("#.##");
                String w1 = df.format(w);
                return Double.parseDouble(w1);
            }
            
            public double convertGradestoPoints(String grade){ 
               double points=0.00;  
                if(grade.equals("A")){
                    points=12;
                }
                else if(grade.equals("A-")){
                    points=11;
                }
                else if(grade.equals("B+")){
                    points=10;
                }
                else if(grade.equals("B")){
                    points=9;
                }
                else if(grade.equals("B-")){
                    points=8; 
                }
                else if(grade.equals("C+")){
                    points=7;
                }
                else if(grade.equals("C")){
                    points=6;
                }
                else if(grade.equals("C-")){
                    points=5;
                }
                else if(grade.equals("D+")){
                    points=4;
                }
                else{
                    points=3; 
                }
                return points;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!--DOCTYPE-->\n");
      out.write("\n");
      out.write(" \n");
Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<title>Application Form</title>\n");
      out.write("<!--start favicon--><link rel=\"shortcut icon\" href=\"image/favicon.ico\"><!--end favicon-->\n");
      out.write("<!--starts accordion advice-->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion2/defaults.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion2/demo.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/accordion2/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/accordion2/accordion.js\"></script>\n");
      out.write("<!--ends accordion advice-->\n");
      out.write("<!--start datepicker-->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"datepicker/jsDatePick_ltr.min.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"datepicker/jsDatePick.min.1.3.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\twindow.onload = function(){\n");
      out.write("\t\tnew JsDatePick({\n");
      out.write("\t\t\tuseMode:2,\n");
      out.write("\t\t\ttarget:\"inputField\",\n");
      out.write("\t\t\tdateFormat:\"%Y-%m-%d\"\n");
      out.write("\t\t\t/*selectedDate:{\t\t\t\tThis is an example of what the full configuration offers.\n");
      out.write("\t\t\t\tday:5,\t\t\t\t\t\tFor full documentation about these settings please see the full version of the code.\n");
      out.write("\t\t\t\tmonth:9,\n");
      out.write("\t\t\t\tyear:2006\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tyearsRange:[1978,2020],\n");
      out.write("\t\t\tlimitToToday:false,\n");
      out.write("\t\t\tcellColorScheme:\"beige\",\n");
      out.write("\t\t\tdateFormat:\"%m-%d-%Y\",\n");
      out.write("\t\t\timgPath:\"img/\",\n");
      out.write("\t\t\tweekStartDay:1*/\n");
      out.write("\t\t});\n");
      out.write("\t};\n");
      out.write("</script>\n");
      out.write("<!--end datepicker-->  \n");
      out.write("<!--start accordions-->\n");
      out.write("<link rel=\"stylesheet\" href=\"css/jquery.mobile-1.4.5.min.css\">\n");
      out.write("<script src=\"js/jquery-1.11.3.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.mobile-1.4.5.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"layout/styles/layout.css\"> \n");
      out.write("<!--start accordions-->\n");
      out.write("<!-- Core CSS - Include with every page -->\n");
      out.write("<link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"mycss/style2.css\" style type=\"text/css\">\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/validate.js\"></script> \n");
      out.write("</head> \n");
      out.write("<body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("   <div class=\"header\"> \n");
      out.write("      <div class=\"imagelogo\" style=\"margin-left: 120px; margin-top: 10px;\"><img src=\"image/mmustlogo.png\" style=\"width: 100px; height: 100px;\"/></div>\n");
      out.write("    \n");
      out.write("    <div class=\"mmust_title\">\n");
      out.write("        <h1 class=\"style1\">MASINDE MULIRO UNIVERSITY OF SCIENCE AND TECHNOLOGY</h1>\n");
      out.write("      <h2 class=\"style2\">DEPARTMENT OF COMPUTER SCIENCE </h2>\n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("  </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!--Starts main content --> \n");
      out.write(" <div class=\"row\" style=\"margin-top: 50px;\">\n");
      out.write("     <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1000px; margin-left: 200px;\"> \n");
      out.write("     <div class=\"login-panel panel panel-default\">\n");
      out.write("         \n");
      out.write("         <div class=\"panel-heading\">\n");
      out.write("              <h3 class=\"panel-title\" style=\"text-align: center;\">Provide The required Information in the Sections Below.</h3>\n");
      out.write("         </div>\n");
      out.write("         \n");
      out.write("   <div class=\"panel-body\">\n");
      out.write("  \n");
      out.write("   <!--Starts collapsible SECTION A--> \n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("    \n");
      out.write("    ");
if(request.getParameter("submit1")!=null){

    int result1=0; 
    String email="rok@yahoo.com";
    String fname=request.getParameter("fname");
    String mname=request.getParameter("mname");
    String lname=request.getParameter("lname");
    String gender=request.getParameter("gender");
    String dob=request.getParameter("dob");
    String postalAddress=request.getParameter("postalAddress");
    String mobile=request.getParameter("mobNumber");
    String nationality=request.getParameter("country");
    AppDetails appdet1=new AppDetails();
    result1=appdet1.setApplicants(email, fname, mname, lname, gender, dob, postalAddress, mobile, nationality); 
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");

    if(result1>0){
      out.write(" \n");
      out.write("    <h1 style=\"color: green;\">SECTION A: Applicants Personal Details...Details Saved Successfully, Proceed to the next section!</h1><br>\n");
      out.write("    ");
}else{
      out.write("\n");
      out.write("        <h1 style=\"color: red;\">SECTION A: Applicants Personal Detail...Sorry, Details Not Saved, Try Again!</h1><br>\n");
      out.write("   ");
 }
        
    }else{
    
      out.write("\n");
      out.write("        <h1>SECTION A: Applicants Personal Details</h1><br>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"Try.jsp\" onsubmit=\"return validateForm(this)\">\n");
      out.write("      <fieldset>\n");
      out.write("         <table style=\"width: 600px; height: 50px;\">\n");
      out.write("           <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">First Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("        <td valign=\"top\"><input autocomplete=\"off\" name=\"fname\" id=\"fname\" type=\"text\">\n");
      out.write("        <span id=\"fnameError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("              <tr>\n");
      out.write("\t       <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t       <td valign=\"top\"><input autocomplete=\"off\" name=\"mname\" id=\"mname\" type=\"text\">\n");
      out.write("                <span id=\"mnameError\"> </span></td>       \n");
      out.write("\t       <td valign=\"top\"></td>\n");
      out.write("             </tr>\n");
      out.write("             <tr>\n");
      out.write("\t       <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Last Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t       <td valign=\"top\"><input autocomplete=\"off\" name=\"lname\" id=\"lname\" type=\"text\">\n");
      out.write("               <span id=\"lnameError\" style=\"color: #ff6699;\"> </span></td>              \n");
      out.write("\t       <td valign=\"top\"></td>\n");
      out.write("             </tr>\n");
      out.write("\n");
      out.write("             <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Gender:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("              <td valign=\"top\"><input name=\"gender\" id=\"genderMale\" value=\"Male\" type=\"radio\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male\n");
      out.write("                  <input name=\"gender\" id=\"genderFemale\" value=\"Female\" type=\"radio\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female\n");
      out.write("               <span id=\"genderError\" style=\"color: #ff6699;\"> </span></td>        \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Date Of Birth:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t      <td valign=\"top\"><input autocomplete=\"off\" name=\"dob\" id=\"inputField\" placeholder=\"yyyy-mm-dd\" type=\"text\" >\n");
      out.write("               <span id=\"dobError\" style=\"color: #ff6699;\"> </span> </td>       \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Postal Address:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t      <td valign=\"top\"><input autocomplete=\"off\" name=\"postalAddress\" id=\"postalAddress\" type=\"text\">\n");
      out.write("               <span id=\"addressError\" style=\"color: #ff6699;\"> </span></td>       \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("           <tr>\n");
      out.write("\t    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Mobile:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t    <td valign=\"top\"><input autocomplete=\"off\" name=\"mobNumber\" id=\"mobNumber\" type=\"text\">\n");
      out.write("            <span id=\"mobileError\" style=\"color: #ff6699;\"> </span></td>        \n");
      out.write("\t   <td valign=\"top\"></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Nationality:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"country\" id=\"country\" type=\"text\">\n");
      out.write("        <span id=\"countryError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t<td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <input type=\"submit\" value=\"Submit\" name=\"submit1\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <strong><input name=\"reset\" value=\"Reset\" type=\"reset\"></strong> <br/></td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("</tr>\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("      </fieldset>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--ends collapsible SECTION A-->\n");
      out.write("    \n");
      out.write("    <!--Starts collapsible SECTION B-->\n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("        \n");
      out.write("        ");

    double aggregatePoints=0.00;
    int result2=0;
    if(request.getParameter("submit2")!=null){
    AppDetails appdet2=new AppDetails();
    String subj1=request.getParameter("subj1");
    String subj2=request.getParameter("subj2");
    String subj3=request.getParameter("subj3");
    String subj4=request.getParameter("subj4");  
    String meanGrade=request.getParameter("meangrade");
    String aggregatePointsString=request.getParameter("aggregatepoints");
    double aggregatePointsInt=Double.parseDouble(aggregatePointsString);//  Integer.parseInt(aggregatePointsString);
    
    double subj1Converted=appdet2.convertGradestoPoints(subj1);
    double subj2Converted=appdet2.convertGradestoPoints(subj2);
    double subj3Converted=appdet2.convertGradestoPoints(subj3);
    double subj4Converted=appdet2.convertGradestoPoints(subj4); 
    aggregatePoints=appdet2.calculateClusterPoints(subj1Converted, subj2Converted, subj3Converted, subj4Converted, aggregatePointsInt);  
    
    result2=appdet2.setQualificationPoints(subj1, subj2, subj3, subj4, meanGrade, aggregatePoints);  
      
    if(result2>0){
        
      out.write("\n");
      out.write("        <h1>SECTION B: Applicant's Education Background...Details Saved Successfully, Proceed to the next section!</h1>  \n");
      out.write("      ");
} else{
      out.write("\n");
      out.write("            \n");
      out.write("           <h1>SECTION B: Applicant's Education Background...Sorry, Details Not Saved, Try Again! </h1> \n");
      out.write("        ");
} 
    }else {
      out.write("\n");
      out.write("              <h1>SECTION B: Applicant's Education Background</h1>  \n");
      out.write("                ");
}
      out.write("\n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"\" onsubmit=\"\"><br>\n");
      out.write("          <fieldset>\n");
      out.write("              <table style=\"width: 600px; height: 50px;\">\n");
      out.write("                  <tbody>\n");
      out.write("                      <tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Physics Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj1\" id=\"subj1\" type=\"text\">\n");
      out.write("        <span id=\"physcsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Maths Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj2\" id=\"subj2\" type=\"text\">\n");
      out.write("        <span id=\"mathsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">GROUP II or any GROUP III Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj3\" id=\"subj3\" type=\"text\">\n");
      out.write("        <span id=\"subj3Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">GROUP II/GROUP III/GROUP IV/GROUP V Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj4\" id=\"subj4\" type=\"text\">\n");
      out.write("        <span id=\"subj4Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Mean Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"meangrade\" id=\"meangrade\" type=\"text\">\n");
      out.write("        <span id=\"meangradeError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Aggregate Points:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"aggregatepoints\" id=\"aggregatepoints\" type=\"text\">\n");
      out.write("        <span id=\"qggregatepointsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t<td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <input type=\"submit\" value=\"Submit\" name=\"submit2\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <strong><input name=\"reset\" value=\"Reset\" type=\"reset\"></strong> <br/></td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("          </fieldset>\n");
      out.write("      </form>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <!--Starts collapsible SECTION B-->\n");
      out.write("    \n");
      out.write("    <!--Starts collapsible SECTION C--> \n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("        \n");
      out.write("            ");
if(request.getParameter("submit3")!=null){

    ResultSet result1=null; 
    ResultSet result3=null;
    int result4=0;
    int courseLevelId=0; 
    int courseId=0; 
    String email="rok@yahoo.com";
    String crsLevel=request.getParameter("levelName");
    String crsName=request.getParameter("courseName");
    String modeOfStudy=request.getParameter("mod");
    String studyCampus=request.getParameter("studyCampus");
    AppDetails appdet3=new AppDetails();
    result1=appdet3.getLevelId(crsLevel);  
    result3=appdet3.getCourseId(crsName); 
    if(result1.next()){
       courseLevelId=result1.getInt("Level_id");  
       
    }
    if(result3.next()){   
         
       courseId=result3.getInt("crs_id"); 
    }
    result4=appdet3.setCourseAppDetails(email, courseLevelId, courseId, modeOfStudy, studyCampus);  
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");

    if(result4>0){
      out.write("  \n");
      out.write("    <h1 style=\"color: green;\">SECTION C: Course Application Details...Details Saved Successfully, Proceed to the next section!</h1><br>\n");
      out.write("    ");
}else{
      out.write("\n");
      out.write("        <h1 style=\"color: red;\">SECTION C: Course Application Details...Sorry, Details Not Saved, Try Again!</h1><br>\n");
      out.write("   ");
 }   
    }else{
    
      out.write("\n");
      out.write("        \n");
      out.write("      <h1>SECTION C: Course Application Details</h1>\n");
      out.write("      ");
}
      out.write("\n");
      out.write("      <!--start accordion advice-->\n");
      out.write("      <div class=\"try\" style=\"width: auto; height: auto; margin-left: 300px; margin-right: 300px;\">\n");
      out.write("          <h5 style=\"text-align: center; color: green;\">You qualify for the following programmes:</h5>\n");
      out.write("      ");

    double ch=0.00;
    int count=1;
    String email="rok@yahoo.com";
    ResultSet rs1=null;
    ResultSet rs22=null;
    ResultSet campuses=null; 
    AppDetails kip=new AppDetails();
    rs22=kip.selectClusterPoints(email);
    campuses=kip.setCampuses();
    if(rs22.next()){
        ch=rs22.getDouble("WeightedClusterPoints");
        rs1=kip.selectClusters(ch);
       while(rs1.next()){
               int crsId=rs1.getInt("Course_Id");
               int crsLevel=rs1.getInt("Level_Id");
               ResultSet info11=kip.setCourseName(crsId); 
               ResultSet info22=kip.setCourseLevel(crsLevel); 
      if(info11.next() && info22.next()){
          String crsName=info11.getString("crs_name");
          String crsLevelName=info22.getString("Level_name"); 
      
      
      out.write(" \n");
      out.write("           \n");
      out.write("           \n");
      out.write("      <input type=\"text\" value=\"");
      out.print(count);
      out.write('.');
      out.write(' ');
      out.print(crsLevelName);
      out.write(" in ");
      out.print(crsName);
      out.write("\" readonly>   \n");
      out.write("        \n");
      out.write("          ");
 }
      count++;
            }
       }
      
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!--ends accordion advice-->\n");
      out.write("    \n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"Try.jsp\" onsubmit=\"\"><br>\n");
      out.write("          <fieldset>\n");
      out.write("              <table style=\"width: 600px; height: 50px;\">\n");
      out.write("                  <tbody>\n");
      out.write("\n");
      out.write("                      <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Select Level:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"levelName\">\n");
      out.write("                                <option selected=\"\">select level</option> \n");
      out.write("                                <option>Degree</option>\n");
      out.write("                                <option>Diploma</option>\n");
      out.write("                                <option>Certificate</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"programmeError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Select programme:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"courseName\">\n");
      out.write("                                <option selected=\"\">select programme</option> \n");
      out.write("                                <option>Computer Science</option>\n");
      out.write("                                <option>Information Technology</option>\n");
      out.write("                                <option>Computer Studies</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"programmeError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("               \n");
      out.write("                       <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Mode of Study:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"mod\">\n");
      out.write("                                <option selected=\"\">mode of study</option> \n");
      out.write("                                <option>Full Time</option>\n");
      out.write("                                <option>Part Time</option>\n");
      out.write("                                <option>Evening Classes</option>\n");
      out.write("                                <option>Weekend Classes</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"modeofstudyError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                       <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Campus/Study Center:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"studyCampus\">\n");
      out.write("                                <option selected=\"\">study center</option> \n");
      out.write("                                ");

                                while(campuses.next()){
                                
      out.write("\n");
      out.write("                                <option>");
      out.print(campuses.getString("Campus_Name"));
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                              </select>\n");
      out.write("                           <span id=\"studycenterError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("\t               <td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t               <td valign=\"top\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                       <input type=\"submit\" name=\"submit3\" value=\"Submit\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                      <td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("                    </tr>\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("          </fieldset>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--ends collapsible SECTION C-->\n");
      out.write("       \n");
      out.write("    <!--Starts collapsible SECTION D-->\n");
      out.write("    <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("      <h1>SECTION D: Print Your Form</h1>\n");
      out.write("      <a href=\"Click.jsp\">print</a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <!--ends collapsible SECTION D-->\n");
      out.write("    \n");
      out.write("   </div> \n");
      out.write("</div>\n");
      out.write(" </div>\n");
      out.write("</div>\n");
      out.write("<!--ends main content --> \n");
      out.write("    </div>\n");
      out.write("</body>\n");
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
