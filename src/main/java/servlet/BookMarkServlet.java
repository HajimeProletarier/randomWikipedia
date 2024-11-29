package servlet;

import java.io.IOException;
import java.util.List;

import dao.BookMarksDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Page;

/**
 * Servlet implementation class BookMarkServlet
 */
public class BookMarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookMarkServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// action クエリストのパラメータを取得
		String title = request.getParameter("action");
		
		// DAO に page を記録させる
		Page page = new Page();
		
		List<Page> pageArchive = (List<Page>) session.getAttribute("pageArchive");
		for (var wage : pageArchive) {
			if(wage.getTitle().equals(title)) {
				page = wage;
			}
		}
		
		// user_id と title と timestamp を bookMarksテーブルに記録させる
		Account account = (Account) session.getAttribute("account");
		BookMarksDAO dao = new BookMarksDAO();
		
		dao.bookMark(account, page);

		// フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
