package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Account;
import model.Login;

public class AccountsDAO {

	// ログイン情報をDBに照合してアカウントを返す
	public Account findByLogin(Login login) {
		Account account = null;
		// authString が ユーザーID か メールなのかで場合分けする
		String authString = login.getAuthString();
		boolean isMail = authString.contains("@");

		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql;
			PreparedStatement pStmt = null;
			if (isMail) {
				sql = "SELECT user_id, pass, mail FROM accounts WHERE mail = ? AND pass = ?"; // 自分で名付けたものは小文字で書く
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, login.getAuthString());
				pStmt.setString(2, login.getPassword());

			} else {
				sql = "SELECT user_id, pass, mail FROM accounts WHERE user_id = ? AND pass = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, login.getAuthString());
				pStmt.setString(2, login.getPassword());
			}
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String userId = rs.getString("user_id");
				String mail = rs.getString("mail");
				String password = rs.getString("pass");

				account = new Account(userId, mail, password);
			}

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return account;

	}

	// ID の重複を調べる：つまり、登録済みかを調べる
	public boolean isResisteredId(Account account) {
		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "SELECT user_id FROM accounts WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getUserId());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return false;
		}
	}

	// メールアドレスの重複を調べる：つまり、登録済みかを調べる
	public boolean isResisteredMail(Account account) {

		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "SELECT mail FROM accounts WHERE mail = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getMail());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return false;
		}
	}

	// アカウントを登録する
	public boolean resister(Account account) {
		try {
			Context initCtx = new InitialContext();
			DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/randomwikipedia");
			Connection conn = dataSource.getConnection();

			String sql = "INSERT INTO accounts(user_id, mail, pass) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getMail());
			pStmt.setString(3, account.getPassword());

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
}
