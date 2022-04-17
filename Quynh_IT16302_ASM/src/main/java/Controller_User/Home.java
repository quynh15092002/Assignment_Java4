package Controller_User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import Entities.Product;

@WebServlet("/HomeUser")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao daoP;

	public Home() {
		super();
		this.daoP = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> ds = this.daoP.getAll();
		request.setAttribute("ds", ds);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
