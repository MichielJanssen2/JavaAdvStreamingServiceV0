package be.pxl.ja.streamingservice.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";
	private static final String ALGORITHM = "MD5";

	public static String encodePassword(String password){
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		messageDigest.update(password.getBytes(), 0, password.length());
		return new BigInteger(1, messageDigest.digest()).toString(16);
	}

	public static int calculateStrength(String password) {
		if (password.length() < 6){
			return 0;
		} else{
			int score;
			boolean hasDigits = false;
			boolean hasLower = false;
			boolean hasUpper = false;
			boolean hasSpecial = false;
			char c;
			if (password.length() <= 10){
				score = 1;
			} else{
				score = 2;
			}
			for (int i = 0; i < password.length(); i++){
				c = password.charAt(i);
				if (Character.isDigit(c)){
					hasDigits = true;
				} else if (Character.isLowerCase(c)){
					hasLower = true;
				} else if (Character.isUpperCase(c)){
					hasUpper = true;
				} else if (SPECIAL_CHARACTERS.indexOf(c) != -1){
					hasSpecial = true;
				}
			}
			if (hasDigits){
				score += 2;
			}
			if (hasLower){
				score += 2;
			}
			if (hasUpper){
				score += 2;
			}
			if (hasSpecial){
				score += 2;
			}
			return score;
		}
	}

	public static boolean isValid(String providedPassword, String securedPassword){
		return securedPassword.equals(encodePassword(providedPassword));
	}
}
