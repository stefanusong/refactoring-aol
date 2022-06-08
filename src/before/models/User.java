package before.models;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class User {
	private int id;
	private UserInfo userInfo;
	
	private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SALT = "fgtqrPjOTVREroGPd8CbLTRR8TDrMP";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
	
	public User(int id, UserInfo userInfo) {
		this.id = id;
		this.userInfo = userInfo;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public abstract String getGreetingMessage();
    
	public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    
    public static String getSecurePassword(String password) {
    	
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), SALT.getBytes());
 
        returnValue = Base64.getEncoder().encodeToString(securePassword);
 
        return returnValue;
    }
    
    public static boolean verifyPassword(String providedPassword,
            String securedPassword)
    {
        boolean returnValue = false;
        
        // Generate New secure password with the same salt
        String newSecurePassword = getSecurePassword(providedPassword);
        
        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
	
}