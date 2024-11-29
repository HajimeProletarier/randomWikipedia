package test;

import dao.AccountsDAO;
import model.Account;

public class isResisteredTest {

	public static void main(String[] args) {
		testIsResisteredIdOK();
		testIsResisterdMailOK();
		
		// NG パターンもテスト
		testIsResisteredIdNG();
		testIsResisterdMailNG();

	}

	public static void testIsResisteredIdOK() {
		Account account = new Account("morikawa", "somehoge@some.hoge.mail", "somehoge");
		AccountsDAO dao = new AccountsDAO();

		if (dao.isResisteredId(account)) {
			System.out.println("成功：正しいIDでマッチしました");
		} else {
			System.out.println("失敗：正しいIDでマッチしません");
		}
	}

	// メアド版にきちんと書き直す。
	public static void testIsResisterdMailOK() {
		Account account = new Account("morikawa", "somehoge@some.hoge.mail", "somehoge");
		AccountsDAO dao = new AccountsDAO();

		if (dao.isResisteredMail(account)) {
			System.out.println("成功：正しいメールでマッチしました");
		} else {
			System.out.println("失敗：正しいメールでマッチしません");
		}
	}
	
	public static void testIsResisteredIdNG() {
		Account account = new Account("morikawaaaa", "somehoge@some.hoge.mail", "somehoge");
		AccountsDAO dao = new AccountsDAO();

		if (dao.isResisteredId(account)) {
			System.out.println("失敗：正しくないIDでマッチしました");
		} else {
			System.out.println("成功：正しくないIDでマッチしません");
		}
	}
	
	public static void testIsResisterdMailNG() {
		Account account = new Account("morikawa", "somehogeeee@some.hoge.mail", "somehoge");
		AccountsDAO dao = new AccountsDAO();

		if (dao.isResisteredMail(account)) {
			System.out.println("失敗：正しくないメールでマッチしました");
		} else {
			System.out.println("成功：正しくないメールでマッチしません");
		}
	}

}
