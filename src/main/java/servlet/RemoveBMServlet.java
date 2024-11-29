package servlet;

import java.io.IOException;

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
 * Servlet implementation class RemoveBMServlet
 */
public class RemoveBMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveBMServlet() {
		super();

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Account をセッションスコープから取得する
		Account account = (Account) session.getAttribute("account");

		// action クエリパラメータから Page 情報を獲得する
		String title = request.getParameter("action");
		Page page = new Page();
		page.setTitle(title);

		// title とユーザー情報を元にして、お気に入りを外す
		BookMarksDAO dao = new BookMarksDAO();
		dao.removeBookMark(account, page);

		// フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookMarkListServlet");
		dispatcher.forward(request, response);
	}

}
