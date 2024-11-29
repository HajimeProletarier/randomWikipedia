package model;

import dao.AccountsDAO;

public class ResisterLogic {
	// Id が重複してたら true 
	public boolean checkResisteredUserId(Account account) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.isResisteredId(account);
		return result;
	}
	
	// Mail が重複してたら true 
	public boolean checkResisteredMail(Account account) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.isResisteredMail(account);
		return result;
	}
	
	// アカウントを登録する
	public void resister(Account account) {
		AccountsDAO dao = new AccountsDAO();
		dao.resister(account);
	}
}
