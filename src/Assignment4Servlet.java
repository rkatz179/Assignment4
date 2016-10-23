import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Assignment4Servlet extends HttpServlet {

	private static String Assignment4Servlet = "http://localhost:8080/Assignment4/Assignment4Servlet";

	private static String submitBtn;
	private static String convincedBtn;
	private static String disagreeBtn;
	private static String unsureBtn;
	
   	private int convinced = 0;
   	private int disgree = 0;
   	private int unsure = 0;

   	private String claimField;
   	private String argumentField;


    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<HTML>");
	out.println("<HEAD>");
	out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">");
	out.println("<TITLE>CS 4501-006 Assignment - 4</TITLE>");
	out.println("<link rel=\"shortcut icon\" type=\"image/png\" href=\"http://pngimg.com/upload/heart_PNG691.png\"/>");
	out.println("<meta name=\"author\" content=\"Rachel Katz, Summer Thompson, and Emma Fass\">");
	out.println("<meta name=\"description\" content=\"CS 4501-006 - Assignment 4\">");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" /> ");
	out.println("</HEAD>");
	out.println("<BODY>");
	out.println("<h1>CS 4501 Assignment-4</h1> ");
	out.println("<p>Directions: </br></br> In the text below, you will begin by making a claim or assertion, and then in the next box you will explain why you have made this claim.</p>");
	out.println("<form name=\"info\" >");
	out.println("<strong> Step 1 </strong> - Assert Something");
	out.println("<textarea name=\"Claim\" placeholder=\"Claim/Assertion:\" rows=\"10\" cols=\"50\">");
	out.println("</textarea></br></br>");
  	out.println("<strong> Step 2 </strong> - Now <i>prove</i> it");
  	out.println("<textarea name=\"Argument\" placeholder=\"Argument/Evidence:\" rows=\"10\" cols=\"50\">");
  	out.println("</textarea></br></br>");
  	out.println("<input type=\"submit\" name=\"Submit\" value=\"Submit\" style=\"display: block; margin-left: auto; margin-right: auto;\">");
	out.println("</form><br/>");
	out.println("<center>");
	out.println("<table cellpadding=5 cellspacing=2 >");
	out.println("<tr>");
	out.println("<td>Vote here: <input type=\"submit\" value=\"Convinced\"> <input type=\"submit\" value=\"Disagree\"><input type=\"submit\" value=\"Unsure\"></td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</center>");
	out.println("<center>");
	out.println("<form name=\"choice\">");
	out.println("<h2>Choose your favorite ice cream flavor</h5>");
	out.println("<img src=\"https://media1.giphy.com/media/bDcs1vQmKdsqc/200_s.gif\">");
	out.println("<input type=\"submit\" class=\"flavor\" value=\"Vanilla\">");
	out.println("<input type=\"submit\" class=\"flavor\" value=\"Chocolate\">");
	out.println("<input type=\"submit\" class=\"flavor\" value=\"Strawberry\">");
	out.println("</form>");
	out.println("</center>");
	out.println("<center>");
	out.println("<h2>Click the buttons</h5>");
	out.println("<input type=\"submit\" class=\"counter\" value=\"Click Me\">");
	out.println("<input type=\"submit\" class=\"counter\" value=\"Reset\">");
	out.println("<p>The button has been clicked <p id='number'>0</p> times</p>");
	out.println("</center>");
	out.println("</BODY>");
	out.println("</HTML>");
    }

     public void doPost(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		submitBtn = request.getParameter("Submit");
		argumentField = request.getParameter("Argument");
		PrintWriter writer = response.getWriter();

		if (submitBtn.equals("Submit")){
			if (argumentField.length()!=0){
				String htmlResponse = "<html>";
				htmlResponse += "<h2>Argument: " + argumentField + "</h2>";
				htmlResponse += "</html>";
				writer.println(htmlResponse);
			}
		}
		doGet(request, response);
	}
}