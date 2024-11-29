package model;

public class Login {
	// ログイン情報を表す Entity

	private String authString; // ここにはメアドもしくはユーザーIDが入る
	private String password;

	public Login(String authString, String password) {
		this.authString = authString;
		this.password = password;
	}

	public String getAuthString() {
		return authString;
	}

	public String getPassword() {
		return password;
	}

}
