package Controller_User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Entities.Cart;
import Entities.Oder;
import Entities.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet({ "/CartController/add", "/CartController/delete" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao daoP;
	private Cart carts;

	public CartController() {
		super();
		this.daoP = new ProductDao();
		this.carts = new Cart();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.sum(request, response);
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if (uri.contains("add")) {
			this.add(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
		this.sum(request, response);

	}
 

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.carts = new Cart();
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.daoP.findById(id);
		HttpSession session = request.getSession();
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("lstCart");

		if (cart == null) {
			cart = new HashMap<Integer, Cart>();
			this.carts = new Cart(p, 1);
			cart.put(id, this.carts);
		} else {
			if (cart.containsKey(id)) {
				// cái key tồn tại trong giỏ hàng sẽ tăng dần số lượng
				this.carts = cart.get(id);
				this.carts.addQuantity();

			} else {
				this.carts = new Cart(p, 1);
				cart.put(id, this.carts);
			}
		}
		session.setAttribute("lstCart", cart);

		response.sendRedirect(request.getContextPath() + "/CartController/add" + "?success=1");

	}
	private void sum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		double sum =0;
		
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("lstCart");
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
			Integer key = entry.getKey();
			Cart val = entry.getValue();
			sum += val.getProduct().getDonGia() * val.getAmount();
		}
	  
		session.setAttribute("sum", sum);


	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.daoP.findById(id);
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("lstCart");
		
	   if(cart.containsKey(id)) {
		    cart.remove(id);
		    //this.carts = cart.get(id);
	   }
		session.setAttribute("lstCart", cart);
		response.sendRedirect(request.getContextPath() + "/CartController/add" + "?successdelete=1");

	}
}
