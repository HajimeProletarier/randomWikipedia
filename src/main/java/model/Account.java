package model;

public class Account {
	// Accounts テーブルのレコードを表す Entity

	private String userId;
	private String mail;
	private String password;

	public Account(String userId, String mail, String password) {
		this.userId = userId;
		this.mail = mail;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}
}
