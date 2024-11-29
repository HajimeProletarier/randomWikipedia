package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.ResisterLogic;
import model.Validation;

/**
 * Servlet implementation class ResisterServlet
 */
public class ResisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/resister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		
		HttpSession session = request.getSession();

		// サーバーサイドでのバリデーション
		boolean isValidId = Validation.isValidUserId(userId);
		if (isValidId == false) {
			session.setAttribute("isValidUserId", false);
		} else {
			session.setAttribute("isValidUserId", true);
		}
		
		boolean isValidPassword = Validation.isValidPassword(password);
		if (isValidPassword == false) {
			session.setAttribute("isValidPassword", false);
		} else {
			session.setAttribute("isValidPassword", true);
		}

		// 入力が適正なので情報が重複していないかを DB に照会する
		// アカウントのインスタンスを作成する
		Account account = new Account(userId, mail, password);
		
		// 重複の調査をする
		ResisterLogic rl = new ResisterLogic();
		
		boolean isResisteredId = rl.checkResisteredUserId(account);
		if(isResisteredId) {
			session.setAttribute("isResisteredUserId", true);
		} else {
			session.setAttribute("isResisteredUserId", false);
		}
		
		boolean isResisteredMail = rl.checkResisteredMail(account);
		if (isResisteredMail) {
			session.setAttribute("isResisteredMail", true);
		} else {
			session.setAttribute("isResisteredMail", false);
		}
		
		// ↑ 似ているものの繰返しになっている。リファクタリングしたい… 
		// ここまでで問題があればリダイレクトしてエラーメッセージを見せる
		if (!isValidId || !isValidPassword || isResisteredId || isResisteredMail) {
			response.sendRedirect("ResisterServlet");
			return;
		}

		// ここまでで問題がなければ登録！
		rl.resister(account);
		session.setAttribute("account", account);
		
		System.out.println("登録処理を実行しました。");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
