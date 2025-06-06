package app.modules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import app.exception.ErrorMessage;

public class DataUser {
	private static Set<User> users = new LinkedHashSet<>();
	private static User trialUser  = new User("", "", "");
	
	public static String Error;
	
	public static void initData() {
		users.add(new Seller("URSULA", "L8x2Qm"));
		users.add(new Donator("RALSNA", "Zp9T7v"));
		users.add(new Buyer("ILYA", "Qe6B1n"));
		users.add(new Recipient("USHA", "D4wJ9y"));
	}
	
	public static Set<User> getUsers() {
		return users;
	}
	
	public static User getDataUser(int index) {
		ArrayList<User> userList = new ArrayList<>(users);
		return userList.get(index);
	}
	
	private static void setDataUser(User u) {
		users.add(u);
	}
	
	public static void setUserRole(String name, String pass, String selectedRole) {
		switch(selectedRole) {
		case "Penjual":
			trialUser = new Seller(name, pass);
			break;
		case "Donatur":
			trialUser = new Donator(name, pass);
			break;
		case "Pembeli":
			trialUser = new Buyer(name, pass);
	        break;
		case "Penerima":
			trialUser = new Recipient(name, pass);
	        break;
		}
	}
	
	public static boolean verifyUser() {
		if (checkPassChar(trialUser.getPassword())) {
			Error = ErrorMessage.PASSWORD_TOO_SHORT.getMessage();
			return false;
		} else {
			if (checkUser(trialUser)) {
				if (checkPassword(trialUser)) {
					return true;
				} else {
					Error = ErrorMessage.WRONG_PASSWORD.getMessage();
					return false;
				}
			} else {
				users.add(trialUser);
				return true;
			}
		}
	}
	
	private static boolean checkUser(User u) {
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
