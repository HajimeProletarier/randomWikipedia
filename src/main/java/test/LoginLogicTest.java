package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {
		testExecuteOK();
		testExecuteNG();
	}

	public static void testExecuteOK() {
		Login login = new Login("morikawa", "somehoge");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		if (result) {
			System.out.println("成功:正しいログイン情報でログインできました");
		} else {
			System.out.println("失敗:正しいログイン情報でログインできませんでした");
		}
	}

	public static void testExecuteNG() {
		Login login = new Login("morikaweee", "somehogeee"); // ログインできないので result == false のはず
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		if(result) {
			System.out.println("成功:正しくないログイン情報でもログインできてしまいました");
		} else {
			System.out.println("失敗:正しくないログイン情報ではログインできませんでした");
		}
	}
}
