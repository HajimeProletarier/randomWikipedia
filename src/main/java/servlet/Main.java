package servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Page;
import model.TitleGetter;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		HttpSession session = request.getSession();
		// 履歴の上限を表す定数を設定
		final Integer maxPageNum = 10;
		session.setAttribute("maxPageNum", maxPageNum);

		// 履歴をセッションスコープに保存する
		List<Page> pageArchive = (List<Page>) session.getAttribute("pageArchive");

		if (pageArchive == null) {
			pageArchive = new ArrayList<>();
			session.setAttribute("pageArchive", pageArchive);
		}
		// 履歴が条件以上の個数だったら古い履歴を破棄する
		while (pageArchive.size() > maxPageNum) {
			pageArchive.remove(0);
		}

		// 履歴にランダムな Wikipedia ページを追加する
		URL url;
		try {
			url = new URL("https://ja.wikipedia.org/wiki/Special:Random");
			// ページの取得と保存
			Page wikiPage = TitleGetter.makePage(url);
			pageArchive.add(wikiPage);

			session.setAttribute("pageArchive", pageArchive);

			// フォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} catch (IOException e) {
			System.out.println("メイン処理で例外が発生しました。");
			e.printStackTrace();
		}
	}

}