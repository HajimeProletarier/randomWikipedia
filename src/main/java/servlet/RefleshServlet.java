package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Page;

/**
 * Servlet implementation class RefleshServlet
 */
public class RefleshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RefleshServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// 履歴をセッションスコープに保存する
		@SuppressWarnings("unchecked")
		List<Page> pageArchive = (List<Page>) session.getAttribute("pageArchive");

		pageArchive.clear();
		
		response.sendRedirect("Main");
	}

}
