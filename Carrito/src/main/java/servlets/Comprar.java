package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;

/**
 * Servlet implementation class Comprar
 */
@WebServlet("/Comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Comprar() {
    	
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Item> carrito = (List<Item>) session.getAttribute("Carrito");
		
		if(carrito == null) {
			
			carrito = new ArrayList<Item>();
			session.setAttribute("Carrito", carrito);
		}
		
		String item = request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty() ? request.getParameter("nombre") : "Desconocido";
		int can = request.getParameter("cantidad") != null && !request.getParameter("cantidad").isEmpty() ? Integer.parseInt(request.getParameter("cantidad")) : 0;	
		double price = request.getParameter("valor") != null && !request.getParameter("valor").isEmpty() ? Double.parseDouble(request.getParameter("valor")) : 0.0;
		
		carrito.add(new Item(item, can, price));
		request.getRequestDispatcher("opciones.html").forward(request, response);
		
	}

}
