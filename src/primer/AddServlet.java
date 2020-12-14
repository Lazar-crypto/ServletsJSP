package primer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
				//u service metodi imaju i doPost i doGet
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int sum = number1 + number2 ;


//		PrintWriter out = response.getWriter();
//		out.print("Result is: " + sum);
		
		//kod dispecera kada samo prosledjuemo isti obejkat
		//request.setAttribute("sum", sum);
		
		//ovde saljemo objekat kod sendRedirekta,jedan od nacina URL Rewriting
		//response.sendRedirect("sq?sum=" + sum);
		
		//maintain data through session ,drugi nacin
//		HttpSession session = request.getSession();
//		session.setAttribute("sum", sum);
//		response.sendRedirect("sq");
		
		//kada saljes req serveru on salje res obj sa cookijem i onda opet kada saljes req 
		//prema serveru opet mozes taj isti cookie da posaljes
		Cookie cookie = new Cookie("sum", sum + "");
		response.addCookie(cookie); //addServ responduje cookijem,klijent ce opet da salje req i sad u
									// sqServ ga treba prihvatiti
		
		response.sendRedirect("sq");
		//Session mngmt - kada hoces da razmenjujes podatke izmedju servleta,URL,Session,Cokies
		
		//Request dispacher and redirect-kako pozvati drugi servlet u ovom 
		//sa dispacerom browser ne zna da li response dolazi od prvog ili drugog servleta
		//sa redirectom to zna,tj s1 obavestava browser da response dolazi od s2
		//tj  imamo dva razlicita objekta iz oba servleta za razliku od dispecera
		
//		RequestDispatcher rd = request.getRequestDispatcher("sq");
//		rd.forward(request, response);
		
		
	}
}
