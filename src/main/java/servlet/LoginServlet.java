package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String authString = request.getParameter("authString");
		String password = request.getParameter("pass");

		// リクエストパラメータ から ログインを行う
		Login login = new Login(authString, password);

		// DB に問い合わせてログインの成否判定をする
		LoginLogic bo = new LoginLogic();
		Account account = bo.getAccount(login); // null かもしれない

		HttpSession session = request.getSession();
		// ログインの成否によって処理を分岐する
		if (account != null) {
			// セッションスコープにユーザIDを保存
			session.setAttribute("account", account);

			session.setAttribute("wasFailLogin", false);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("wasFailLogin", true);
			
			response.sendRedirect("LoginServlet");
		}

	}

}
