package Controller_Staff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import Dao.UserDao;
import Entities.User;
import Utils.EncryptUtils;

/**
 * Servlet implementation class QLUser
 */
@MultipartConfig
@WebServlet({
	"/QLUser/index",
	"/QLUser/store",
	"/QLUser/edit",
	"/QLUser/update",
	"/QLUser/delete",
})
public class QLUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    public QLUser() {
        super();
        this.userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("index")) {
			this.index(request, response);
		}else if(uri.contains("edit")) {
			this.edit(request, response);
		}else if(uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("store")) {
			this.store(request, response);
		}else if(uri.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> lstKH = this.userDao.getAll();
		request.setAttribute("lstKH" , lstKH);
		request.setAttribute("view", "/views/Users/create.jsp");
		request.setAttribute("table", "/views/Users/index.jsp");
		request.getRequestDispatcher("/views/Staff/homeStaff.jsp").forward(request, response);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> lstKH = this.userDao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		User u = this.userDao.findById(id);
		File file = new File(request.getServletContext().getRealPath("/image"));
		if(!file.exists()) {
			file.mkdirs();
		}
		request.setAttribute("user", u);
		request.setAttribute("lstKH" , lstKH);
		request.setAttribute("view", "/views/Users/edit.jsp");
		request.setAttribute("table", "/views/Users/index.jsp");
		request.getRequestDispatcher("/views/Staff/homeStaff.jsp").forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		User u = this.userDao.findById(id);
		try {
			session.setAttribute("message", "Xóa thành công");
			this.userDao.deleteById(u.getId());
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		} catch (Exception e) {
			session.setAttribute("error", "Xóa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		}
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		try {
			User u = new User();
			BeanUtils.populate(u, request.getParameterMap());
			String ecrypted = EncryptUtils.encrypt(request.getParameter("password"));
			String realPath =request.getServletContext().getRealPath("/files");
			Path path = Paths.get(realPath);
			if(!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("avatar");
			String fileUpload = part.getSubmittedFileName();
			if(!"".equals(fileUpload)) {
				String avatar = Path.of(fileUpload).getFileName().toString();
				part.write(Paths.get(realPath.toString(),avatar).toString());
				u.setAvatar(avatar);
			}
			u.setPassword(ecrypted);
			session.setAttribute("message", "Thêm thành công");
			this.userDao.insert(u);
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		} catch (Exception e) {
			session.setAttribute("error", "Thêm thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		User u = this.userDao.findById(id);
		try {
			BeanUtils.populate(u, request.getParameterMap());
			String ecrypted = EncryptUtils.encrypt(request.getParameter("password"));
			String realPath =request.getServletContext().getRealPath("/files");
			Path path = Paths.get(realPath);
			if(!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("avatar");
			String fileUpload = part.getSubmittedFileName();
			if(!"".equals(fileUpload)) {
				String avatar = Path.of(fileUpload).getFileName().toString();
				part.write(Paths.get(realPath.toString(),avatar).toString());
				u.setAvatar(avatar);
			}
			u.setPassword(u.getPassword());
			session.setAttribute("message", "Sửa thành công");
			this.userDao.update(u);
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		} catch (Exception e) {
			session.setAttribute("error", "Sửa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLUser/index");
		}
	}

}
