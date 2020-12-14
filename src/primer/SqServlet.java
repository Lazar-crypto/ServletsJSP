package primer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		//ovo je sa dispecerom tj i dalje je ovo request objekat iz AddSevlet klase
		//int k = (int)req.getAttribute("sum");
		//k = k * k;
		
		//sa sendRedirectom: kada saljemo podatke pomocu request objekta
		//int k = Integer.parseInt(req.getParameter("sum"));
		//                 :kada ih saljemo u sesiji tj objekta iz sesije koja je opet objekat requesta
		//HttpSession session = req.getSession();
		//int k = (int)session.getAttribute("sum"); // vraca tip objekat pa ga conv u int
		//k = k * k;
						//:preko cookija
		//klijent salje sve cookije,ne zna koji ti treba
		int k = 0;
		Cookie cookies[] = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("sum"))
				k = Integer.parseInt(c.getValue());
		}
		k = k * k;
		PrintWriter out = res.getWriter();
		out.println("Result is: " + k);
		
	}
}
