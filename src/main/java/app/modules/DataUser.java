package app.modules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import app.exception.ErrorMessage;

public class DataUser {
	private static Set<User> users = new LinkedHashSet<>();
	private static User activeUser = new User("", "", "");

	public static String Error;

	public static void initData() {
		users.add(new Seller("URSULA", "L8x2Qm"));
		users.add(new Seller("YALNA", "I0ADSHY925"));
		users.add(new Seller("MARUI", "TE730123ADNC"));
		users.add(new Donator("RALSNA", "Zp9T7v"));
		users.add(new Donator("PLINA", "U63KTPAS"));
		users.add(new Buyer("ILYA", "Qe6B1n"));
		users.add(new Buyer("BOSHA", "12QERSe6KUn"));
		users.add(new Recipient("USHA", "D4wJ9y"));
		users.add(new Recipient("SAHSA", "IXYA817P"));
	}

	public static Set<User> getUsers() {
		return users;
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public static User getDataUser(int index) {
		ArrayList<User> userList = new ArrayList<>(users);
		return userList.get(index);
	}

	public static void setDataUser(User u) {
		users.add(u);
	}

	public static void setUserRole(String name, String pass, String selectedRole) {
		switch (selectedRole) {
		case "Penjual":
			activeUser = new Seller(name, pass);
			break;
		case "Donatur":
			activeUser = new Donator(name, pass);
			break;
		case "Pembeli":
			activeUser = new Buyer(name, pass);
			break;
		case "Penerima":
			activeUser = new Recipient(name, pass);
			break;
		}
	}

	public static boolean verifyUser() {
		if (checkPassChar(activeUser.getPassword())) {
			Error = ErrorMessage.PASSWORD_TOO_SHORT.getMessage();
			return false;
		} else {
			if (checkUser(activeUser)) {
				if (checkPassword(activeUser)) {
					return true;
				} else {
					Error = ErrorMessage.WRONG_PASSWORD.getMessage();
					return false;
				}
			} else {
				users.add(activeUser);
				return true;
			}
		}
	}

	public static boolean checkUser(User u) {
		for (User user : users) {
			boolean sameUser = user.getUsername().equalsIgnoreCase(u.getUsername());
			boolean sameRole = user.getRole().equalsIgnoreCase(u.getRole());
			if (sameUser && sameRole) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkPassword(User u) {
		for (User user : users) {
			boolean sameUser = user.getUsername().equalsIgnoreCase(u.getUsername());
			boolean sameRole = user.getRole().equalsIgnoreCase(u.getRole());
			boolean samePass = user.getPassword().equals(u.getPassword());
			if (sameUser && sameRole && samePass) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkPassChar(String pass) {
		char[] cPass = pass.toCharArray();
		if (cPass.length >= 6) {
			return false;
		}
		return true;
	}

}
