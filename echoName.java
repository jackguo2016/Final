//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

//Import Java Libraries
import java.io.*;

public class echoName extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<html>\n<head>\n\n");
		out.print("<title>SWE 432 fianl: boolean truth table</title>\n");
		out.print("<style>table tr td,table tr th{text-align:center;padding:10px 40px;border-bottom:1px solid #000;}</style>\n");
		out.print("</head>\n");
		out.print("<body>\n");
		out.print("<center><h2>Name echoing</h2></center>\n");
		out.print("<hr>\n");

		String exp = request.getParameter("exp");
		String show = request.getParameter("type");
		out.print("Your boolean logical expression is "+exp+".<br>");
		int type=validaion(exp);
		String exp_low=exp.toLowerCase();
		String A="";
		String B="";
		String T="T";
		String F="F";
		String[] sub=null;
		if(type==0){
			out.print("<font color=red>Sorry, your input is invalid. Please reinput.</font><br>");
		}else{
			if(show.equals("0")){
				T="t";
				F="f";
			}else if(show.equals("2")){
				T="1";
				F="0";
			}else if(show.equals("3")){
				T="true";
				F="false";
			}
			switch (type) {
			case 1://and 
				sub = exp_low.split(" and ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table  cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><th>"+T+"</th></tr>");
				out.print("</table>");
				break;
			case 2://&&
				sub = exp_low.split(" && ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table  cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><th>"+T+"</th></tr>");
				out.print("</table>");
				break;
			case 3://&
				sub = exp_low.split(" & ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table  cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><th>"+F+"</th></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><th>"+T+"</th></tr>");
				out.print("</table>");
				break;
			case 4://or
				sub = exp_low.split(" or ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table  cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><td>"+F+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("</table>");
				break;
			case 5://||
				sub = exp_low.split(" || ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table  cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><td>"+F+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("</table>");
				break;
			case 6://|
				sub = exp_low.split(" \\| ");
				A=exp.substring(0, sub[0].length());
				B=exp.substring(exp.length()-sub[1].length(), exp.length());
				out.print("<table cellpadding=0 cellspacing=0>");
				out.print("<tr><th>"+A+"</th><th>"+B+"</th><th>"+A+" "+exp.substring(sub[0].length()+1,exp.length()-sub[1].length()-1)+" "+B+"</th></tr>");
				out.print("<tr><td>"+F+"</td><td>"+F+"</td><td>"+F+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+F+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+F+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("<tr><td>"+T+"</td><td>"+T+"</td><td>"+T+"</td></tr>");
				out.print("</table>");
				break;
							
			default:
				out.print("<font color=red>Sorry, your input is invalid. Please reinput.</font><br>");
				break;
			}
			
		}
		out.print("<a href='/Boolean/final.html'>Back</a>\n");
		out.print("</body>\n");
		out.print("</html>\n");

		out.close ();
	}
	private int validaion(String exp) {
		String exp_low=exp.toLowerCase();
		if(exp_low.contains(" and ")){
			return 1;//and
		}else if(exp_low.contains(" && ")){
			return 2;//&&
		}else if(exp_low.contains(" & ")){
			return 3;//&
		}else if(exp_low.contains(" or ")){
			return 4;//or
		}else if (exp_low.contains(" || ")) {
			return 5;//||
		}else if(exp_low.contains(" | ")){
			return 6;//|
		}else{
			return 0;//invalid
		}
	}

}