package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountsDAOTest {

	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
	}

	public static void testFindByLoginOK() {
		Login login = new Login("morikawa", "somehoge");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);

		if (result != null) {
			System.out.println("成功：正しいログイン情報でログインできました");
			System.out.println(result.getUserId() + ": " + result.getMail() + ": " + result.getPassword());
		} else {
			System.out.println("失敗：正しいログイン情報でログインできませんでした");
		}
	}

	public static void testFindByLoginNG() {
		Login login = new Login("morikaweeee", "somehogeeee");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);

		if (result == null) {
			System.out.println("成功：不正なログイン情報ではログインできませんでした");
		} else {
			System.out.println("失敗：不正なログイン情報でもログインできました");
		}
	}

}
