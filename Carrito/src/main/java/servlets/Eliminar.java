package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> carrito = (List<Item>) session.getAttribute("Carrito");
		
		if(carrito != null) {
			int position = request.getParameter("pos") != null && !request.getParameter("pos").isEmpty() ? Integer.parseInt(request.getParameter("pos")) : 0;
			carrito.remove(position);
		}
		request.getRequestDispatcher("VerCarrito").forward(request, response);
	}

}
