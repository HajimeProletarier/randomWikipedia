package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class BookMarkListServlet
 */
public class BookMarkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookMarkListServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// アカウント情報からブックマーク一覧を取得する
		Account account = (Account) session.getAttribute("account");
		BookMarksDAO dao = new BookMarksDAO();

		ArrayList<Page> bookmarks = dao.findBookMark(account);

		session.setAttribute("bookmarks", bookmarks);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BookMarkList.jsp");
		dispatcher.forward(request, response);
	}

}
