package model;

public class Validation {
	public static boolean isValidUserId(String userId) {
		// [A-Za-z0-9_]{1,10}
		if (userId.matches("[A-Za-z0-9_]{1,10}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPassword(String password) {
		// [A-Za-z0-9@#$%^&*!?_]{8,20}
		if (password.matches("[A-Za-z0-9@#$%^&*!?_]{8,20}")) {
			return true;
		} else {
			return false;
		}
	}
}
