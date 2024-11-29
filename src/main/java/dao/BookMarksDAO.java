package dao;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Account;
import model.Page;

public class BookMarksDAO {
	// ブックマークを登録
	public boolean bookMark(Account account, Page page) {
		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO bookmarks(user_id, title, timestamp) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, page.getTitle());
			pStmt.setString(3, page.getTimestamp());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// ユーザーID からブックマーク一覧を取得する
	public ArrayList<Page> findBookMark(Account account) {
		List<Page> result = new ArrayList<>();

		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM bookmarks WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String timestamp = rs.getString("timestamp");

				String encoded = URLEncoder.encode(title, "UTF-8");
				String titleUrl = "https://ja.wikipedia.org/wiki/" + encoded;
				URL url = new URL(titleUrl);

				Page page = new Page(title, url, timestamp);
				result.add(page);
			}

		} catch (SQLException | NamingException | MalformedURLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return (ArrayList<Page>) result;
	}

	// ブックマークを外す
	public boolean removeBookMark(Account account, Page page) {
		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "DELETE FROM bookmarks WHERE user_id = ? AND title = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, page.getTitle());
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
