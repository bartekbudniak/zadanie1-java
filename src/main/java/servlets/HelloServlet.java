package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/harmonogram")
public class HelloServlet extends HttpServlet{
 
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
			String kwotaS = request.getParameter("kwota");
			if(kwotaS==null || kwotaS.equals("")){
				response.sendRedirect("/");
			}
			int kwota = Integer.parseInt(kwotaS);
			String ratyS = request.getParameter("raty");
			if(ratyS==null || ratyS.equals("")){
				response.sendRedirect("/");
			}
			int raty = Integer.parseInt(ratyS);
			String oprocentowanieS = request.getParameter("oprocentowanie");
			if(oprocentowanieS==null || oprocentowanieS.equals("")){
				response.sendRedirect("/");
			}
			int oprocentowanie = Integer.parseInt(oprocentowanieS);
			String oplataS = request.getParameter("oplata");
			if(oplataS==null || oplataS.equals("")){
				response.sendRedirect("/");
			}
			int oplata = Integer.parseInt(oplataS);
			String rodzaj = request.getParameter("rodzaj");
			
			response.setContentType("text/html");
			response.getWriter().println("<table><caption>Harmonogram sp³at</caption><tr>"
					+ "<th>Numer raty</th>"
					+ "<th>Kwota kapita³u</th>"
					+ "<th>Kwota odsetek</th>"
					+ "<th>Op³aty sta³e</th>"
					+ "<th>Ca³kowita kwota raty</th></tr>");
			double rata;
			if(rodzaj=="stala"){
				int q = 1 + oprocentowanie/1200;
				rata = (kwota*Math.pow(q, raty)*(q-1))/(Math.pow(q, raty)-1);
				for(int i = 1;i <= raty; i++){
					response.getWriter().println("<tr>"
							+ "<td>" + i + "</td>" 
							+ "<td>" + kwota/raty + "</td>" 
							+ "<td>" + (rata - oplata - kwota/raty) + "</td>" 
							+ "<td>" + oplata + "</td>" 
							+ "<td>" + rata + "</td>" 
							+ "</tr>");
				}
			}
			else{
				int q = 1 + oprocentowanie/1200;
				rata = (kwota*Math.pow(q, raty)*(q-1))/(Math.pow(q, raty)-1);
				double pozostaloDoSplaty = kwota;
				for(int i = 1;i <= raty; i++){
					response.getWriter().println("<tr>"
							+ "<td>" + i + "</td>" 
							+ "<td>" + kwota/raty + "</td>" 
							+ "<td>" + pozostaloDoSplaty*oprocentowanie/12 + "</td>" 
							+ "<td>" + 0 + "</td>" 
							+ "<td>" + (kwota/raty + pozostaloDoSplaty*oprocentowanie/12) + "</td>" 
							+ "</tr>");
					pozostaloDoSplaty-= kwota/raty + pozostaloDoSplaty*oprocentowanie/12;
				}
			}
			
			response.getWriter().println("</table>");
			
		}
}
