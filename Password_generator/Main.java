import java.security.SecureRandom;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        String password = generatePassword(12);
        System.out.println(password);
    }
    public static String generatePassword(int length) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()_+-=[]{};:,.<>/?";
        String characters = uppercase + lowercase + digits + symbols;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}


    