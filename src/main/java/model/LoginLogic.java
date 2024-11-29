package model;

import dao.AccountsDAO;

public class LoginLogic {
	
	// ログインの可否だけ判定するメソッド
	public boolean execute(Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(login);
		
		return account != null;
	}
	
	// ログインで取得したアカウントを返すメソッド
	public Account getAccount(Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(login);
		
		return account;
	}
}
