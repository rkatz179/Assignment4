/**
* Authors: Rachel Katz (rak5ea), Emma Fass (enf5cb), Summer Thompson (sst2bd) 
*/

/**
* Import all necessary libraries
*/
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
* Define Assignment4Servlet to extend HTTPServlet
*/
public class Assignment4Servlet extends HttpServlet {

	/**
	* Define the page link
	*/
	private static String Assignment4Servlet = "http://localhost:8080/Assignment4/Assignment4Servlet";

	/**
	* Declare all buttons
	*/
	private static String submitBtn;
	private static String convincedBtn;
	private static String disagreeBtn;
	private static String unsureBtn;
	
	/**
	*  Declare counter arguments
	*/
   	private int convinced = 0;
   	private int disgree = 0;
   	private int unsure = 0;

   	/**
	* Declare Claim and Argument fields
	*/
   	private String claimField;
   	private String argumentField;


   	/**
	*  Method Name: doGet()
	*  Summary: This is called when the page is loaded and when data is being sent to the server
	*/
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
	out.println("<center>");
	out.println("<p>Directions: </br></br> In the text below, you will begin by making a claim or assertion,</br> and then in the next box you will explain why you have made this claim.</p>");
	out.println("<form action="+ Assignment4Servlet + " method=\"post\" name=\"info\" >");	
	out.println("<strong> Step 1 </strong> - Assert Something");
	out.println("<textarea name=\"Claim\" placeholder=\"Claim/Assertion:\" rows=\"10\" cols=\"50\">");
	out.println("</textarea></br></br>");
  	out.println("<strong> Step 2 </strong> - Now <i>prove</i> it");
  	out.println("<textarea name=\"Argument\" placeholder=\"Argument/Evidence:\" rows=\"10\" cols=\"50\">");
  	out.println("</textarea></br></br>");
  	out.println("<input type=\"submit\" name=\"Submit\" class=\"counter\" value=\"Submit\" style=\"display: block; margin-left: auto; margin-right: auto;\">");
	out.println("</form><br/>");
	out.println("<form action="+ Assignment4Servlet + " method=\"post\" name=\"buttons\" >");	
	out.println("<table cellpadding=5 cellspacing=2 >");
	out.println("<tr>");
	out.println("<td>Vote here: <input type=\"submit\" name=\"cBtn\" value=\"Convinced\"> <input type=\"submit\" name=\"dBtn\" value=\"Disagree\"><input type=\"submit\" name=\"uBtn\" value=\"Unsure\"></td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</form><br/>");
	out.println("<p>Convinced= " + convinced + " </p>");
	out.println("<p>Disagree= " + disgree + " </p>");
	out.println("<p>Unsure= " + unsure + " </p>");
	out.println("</center>");
	out.println("</BODY>");
	out.println("</HTML>");
    }

    /**
	*  Method Name: doPost()
	*  Summary: This is called when information is received by the server, 
	*  		     and new data must be displayed on the page
	*/
    public void doPost(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
		
			/**
			*  Specify that HTML will be used and initialize the PrintWriter
			*/
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			/**
			*  Get parameters and check for null or empty fields
			*/
			if(submitBtn == null || submitBtn == ""){
				submitBtn = request.getParameter("Submit");
			}

			convincedBtn = request.getParameter("cBtn");
			if(convincedBtn != null && convincedBtn.equals("Convinced")){
				convinced = convinced + 1;
			}
			
			disagreeBtn = request.getParameter("dBtn");
			if( disagreeBtn != null && disagreeBtn.equals("Disagree") ){
				disgree++;
			}

			unsureBtn = request.getParameter("uBtn");
			if( unsureBtn != null && unsureBtn.equals("Unsure") ){
				unsure++;
			}

			if(argumentField == null || argumentField == ""){
				argumentField = request.getParameter("Argument");
			}

			if(claimField == null || claimField == ""){
				claimField = request.getParameter("Claim");
			}


			/**
			*  Changed HTML to be displayed after submission of forms
			*/
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
			out.println("<center>");
			out.println("<p>Directions: </br></br> In the text below, you will begin by making a claim or assertion, <br/>and then in the next box you will explain why you have made this claim.</p>");
			out.println("<form action="+ Assignment4Servlet + " method=\"post\" name=\"info\" >");				
			out.println("<strong> Step 1 </strong> - Assert Something");

			/**
			*  If the claimfield is not null or empty, display the claim inputed by the user.
			*  Else, display an error as well as the original textfield
			*/
			if(claimField != "" && claimField != null){ 
				out.println("<p> Claim: " + claimField + " </p>"); 
			}
			else{
				out.println("<h4 style=\"color: red; font-family: verdana; font-size: 16px;\">You need to have a claim</h4>");
				out.println("<textarea name=\"Claim\" placeholder=\"Claim/Assertion:\" rows=\"10\" cols=\"50\">");
				out.println("</textarea></br></br>");
			}
		  	out.println("<strong> Step 2 </strong> - Now <i>prove</i> it");
		  	
		  	/**
			*  If the argument is not null or empty, display the claim inputed by the user.
			*  Else, display an error as well as the original textfield
			*/
		  	if(argumentField != "" && argumentField != null){ 
				out.println("<p> Argument: " + argumentField + " </p>"); 
			}
			else{
				out.println("<h4 style=\"color: red; font-family: verdana; font-size: 16px;\">You need to have an argument</h4>");
				out.println("<textarea name=\"Argument\" placeholder=\"Argument/Evidence:\" rows=\"10\" cols=\"50\">");
				out.println("</textarea></br></br>");
			}

			/**
			*  Disable the submit button if both the claim and argument were submitted
			*/
			if(claimField != "" && argumentField != "" && submitBtn != null && submitBtn.equals("Submit")){
				out.println("<input type=\"submit\" class=\"counter\" style=\"background-color:grey; opacity:0.40\" disabled=\"disabled\" name=\"Submit\" value=\"Submit\" style=\"display: block; margin-left: auto; margin-right: auto;\">");
			}
			else{
				out.println("<input type=\"submit\" class=\"counter\" name=\"Submit\" value=\"Submit\" style=\"display: block; margin-left: auto; margin-right: auto;\">");
			}
			out.println("</form><br/>");
			out.println("<form action="+ Assignment4Servlet + " method=\"post\" name=\"buttons\" >");	
			out.println("<table cellpadding=5 cellspacing=2 >");
			out.println("<tr>");
			out.println("<td>Vote here: <input type=\"submit\" name=\"cBtn\" value=\"Convinced\" action="+ Assignment4Servlet + " method=\"post\"> <input type=\"submit\" name=\"dBtn\" value=\"Disagree\"><input type=\"submit\"  name=\"uBtn\" value=\"Unsure\"></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form><br/>");
			/**
			*  Update the counts of the voting fields
			*/
			out.println("<p>Convinced= " + convinced + " </p>");
			out.println("<p>Disagree= " + disgree + " </p>");
			out.println("<p>Unsure= " + unsure + " </p>");
			out.println("</center>");
			out.println("</BODY>");
			out.println("</HTML>");

	}
}