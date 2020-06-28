import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpressionValidate extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
           
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        int count=0;
        
        PrintWriter out = response.getWriter();
        
        Pattern namePattern = Pattern.compile("Kartik\\sMukati");
        Matcher nameMatcher =   namePattern.matcher(name);
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<center>");
        if(nameMatcher.find()){
            out.println("<p>"+name+" - Yes, its me</p>");
            count++;
        }
        else{
            out.println("<p>"+name+" - Its not me.</p>");
        }
        
        Pattern emailPattern = Pattern.compile("[a-z]+@wappgo.com");
        Matcher emailMatcher =   emailPattern.matcher(email);
        
        if(emailMatcher.find()){
            out.println("<p>"+email+" - Welcome ! to Wappgo. You belong to our community.</p>");
            count++;
        }
        else{
            out.println("<p>"+email+" - Sorry, you are not a member of Wappgo Community</p>");
        }
        
        Pattern mobilePattern = Pattern.compile("9131651944");
        Matcher mobileMatcher =   mobilePattern.matcher(mobile);
        
        if(mobileMatcher.find()){
            out.println("<p>"+mobile+" - Number you have provided is correct.</p>");
            count++;
        }
        else{
            out.println("<p>"+mobile+" - Mobile number dosen't match.</p>");
        }
        
        if(count == 3){
            
            out.println("<a href=\"https://wappgo.com/\" />Wappgo</a>");
            out.println("</center>");
            out.println("</BODY>");
            out.println("</HTML>");
        }
            
        
    }

}
